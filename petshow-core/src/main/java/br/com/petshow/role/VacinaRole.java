package br.com.petshow.role;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.PerdidoDAO;
import br.com.petshow.dao.VacinaDAO;
import br.com.petshow.enums.EnumVacina;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Perdido;
import br.com.petshow.model.Vacina;
import br.com.petshow.util.DateUtil;
import br.com.petshow.util.ValidationUtil;



@Service
public class VacinaRole extends SuperClassRole<Vacina> {

	@Autowired
	private VacinaDAO vacinaDAO;
	@Override
	public Vacina insert(Vacina entidade) throws ExceptionValidation {
		Vacina retorno =(Vacina) this.vacinaDAO.insert(entidade);
		
		
		if(!ValidationUtil.isCampoComValor(entidade.getData())){
			throw new ExceptionValidation("A data de aplicação deve ser informada!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getAnimal())){
			throw new ExceptionValidation("O animal não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getTpVacina())){
			throw new ExceptionValidation("O tipo de vacina não foi informado!");
		}
		
		
		if(entidade.isFlAplicada()){
			Vacina vacinaProx= new Vacina();
			vacinaProx.setAnimal(entidade.getAnimal());
			vacinaProx.setEstabelecimento(entidade.getEstabelecimento());
			vacinaProx.setTpVacina(EnumVacina.getEnum(entidade.getTpVacina().getId()));
			vacinaProx.setData(entidade.getPrevisaoProxima());
		
			HashMap<String,String> dados= new VacinaRole().getRegrasVacina(vacinaProx.getTpVacina(),vacinaProx.getData());

			Calendar calendar =  Calendar.getInstance();
			calendar.set( Integer.parseInt(dados.get("dtProx").substring(6,10)),  Integer.parseInt(dados.get("dtProx").substring(3,5))-1, Integer.parseInt(dados.get("dtProx").substring(0,2)));

			Date dataPrevisao =calendar.getTime();

			vacinaProx.setPrevisaoProxima(dataPrevisao);
			
			this.vacinaDAO.insert(vacinaProx);
		}
		
		
		
		return retorno;
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		this.vacinaDAO.delete(codigo);
		
	}

	@Override
	public Vacina update(Vacina entidade) throws ExceptionValidation {
		Vacina vacinaCadastrada=find(entidade.getId());
		
		if(!ValidationUtil.isCampoComValor(entidade.getId())){
			throw new ExceptionValidation("O id não foi informado!");
		}
		
		if(!ValidationUtil.isCampoComValor(entidade.getData())){
			throw new ExceptionValidation("A data de aplicação deve ser informada!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getAnimal())){
			throw new ExceptionValidation("O animal não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getTpVacina())){
			throw new ExceptionValidation("O tipo de vacina não foi informado!");
		}
		
		
		if(vacinaCadastrada.isFlAplicada()){
			throw new ExceptionValidation("A vacina já foi aplicada e não poderá ser alterada");
		}
		
		if(vacinaCadastrada.isFlAplicada() ==false && entidade.isFlAplicada() ==true ){
			Vacina vacinaProx= new Vacina();
			vacinaProx.setAnimal(entidade.getAnimal());
			vacinaProx.setEstabelecimento(entidade.getEstabelecimento());
			vacinaProx.setTpVacina(EnumVacina.getEnum(entidade.getTpVacina().getIdProxima()));
			vacinaProx.setData(entidade.getPrevisaoProxima());
		
			HashMap<String,String> dados=  VacinaRole.getRegrasVacina(vacinaProx.getTpVacina(),vacinaProx.getData());

			Calendar calendar =  Calendar.getInstance();
			calendar.set( Integer.parseInt(dados.get("dtProx").substring(6,10)),  Integer.parseInt(dados.get("dtProx").substring(3,5))-1, Integer.parseInt(dados.get("dtProx").substring(0,2)));

			Date dataPrevisao =calendar.getTime();

			vacinaProx.setPrevisaoProxima(dataPrevisao);
			
			this.vacinaDAO.insert(vacinaProx);
		}
		
		
		
		return (Vacina) this.vacinaDAO.update(entidade);
	}

	@Override
	public Vacina find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.vacinaDAO.find(codigo);
	}
	
	public List<Vacina> consultaPorAnimal(Long id)  throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.vacinaDAO.consultaPorAnimal(id);
	}
	
	
	public static HashMap<String,String> getRegrasVacina(EnumVacina tipo,Date data){
		HashMap<String,String> regras= new HashMap<String,String>();
		
		
		if(tipo == EnumVacina.CPOLIVALENTE){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			
		}else if(tipo == EnumVacina.CPOLIVALENTE_R1){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CPOLIVALENTE_R2){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina CPOLIVALENTE_R2 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CANTIRRABICA){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina CANTIRRABICA previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGRIPE_CANINA){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGRIPE_CANINA_R1){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGIARDIASE){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGIARDIASE_R1){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CLEISHMANIOSE){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CLEISHMANIOSE_R1){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CLEISHMANIOSE_R2){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CPOLIVALENTE_ANUAL){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CANTIRRABICA_ANUAL){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGRIPE_CANINA_ANUAL){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CGIARDIASE_ANUAL){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}else if(tipo == EnumVacina.CLEISHMANIOSE_ANUAL){
			if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
			regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
		}
		
		

		return regras;
	}
	
	
	
	
	
	
}
