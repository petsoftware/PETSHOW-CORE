package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshow.dao.VacinaCalendarDAO;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumVacina;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Vacina;
import br.com.petshow.model.VacinaCalender;
import br.com.petshow.util.DateUtil;

public class VacinaCalendarRole extends SuperClassRole<VacinaCalender> {

	@Autowired
	private VacinaCalendarDAO dao;
	@Override
	public VacinaCalender insert(VacinaCalender entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return dao.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		// TODO Auto-generated method stub
		dao.delete(codigo);
	}

	@Override
	public VacinaCalender update(VacinaCalender entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return dao.update(entidade);
	}

	@Override
	public VacinaCalender find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return dao.find(codigo);
	}
	
	public void gerarCalender(Vacina vacina) {
		if(dao.findAll().isEmpty()){
			gerarCalendario(vacina);
		}
	}
	
	private void gerarCalendario(Vacina vacina) {
		for (EnumVacina tpVacina : EnumVacina.values()) {
			VacinaCalender vacinaCalender = new VacinaCalender();
			vacinaCalender.setAnimal(vacina.getAnimal());
			boolean aplicada = false;
			if(vacina.getTpVacina().equals(vacinaCalender.getVacina())){
				aplicada = vacina.isFlAplicada();
				vacinaCalender.setDtAplicacao(vacina.getData());
			}else{
				vacinaCalender.setDtAplicacao(null);
			}
			vacinaCalender.setAplicada(aplicada);
			vacinaCalender.setDescricao(tpVacina.getNome());
			if(tpVacina == EnumVacina.CPOLIVALENTE){
				//if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
				//regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
				//Inserir mais duas doses
				
			}else if(tpVacina == EnumVacina.CPOLIVALENTE_R1){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CPOLIVALENTE_R2){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina CPOLIVALENTE_R2 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CANTIRRABICA){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina CANTIRRABICA previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGRIPE_CANINA){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGRIPE_CANINA_R1){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGIARDIASE){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGIARDIASE_R1){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CLEISHMANIOSE){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CLEISHMANIOSE_R1){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 21)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CLEISHMANIOSE_R2){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CPOLIVALENTE_ANUAL){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CANTIRRABICA_ANUAL){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGRIPE_CANINA_ANUAL){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CGIARDIASE_ANUAL){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}else if(tpVacina == EnumVacina.CLEISHMANIOSE_ANUAL){
//				if(data!=null)regras.put("dtProx", DateUtil.dateTo_ddMMYYYY(DateUtil.addDays(data, 365)));
//				regras.put("desc", "Vacina V8/V10 previne varias doenças, indicado tomar 3 doses apartir do 3 mes de vida com um intervalo de 21 a 30 dias..");
			}
			vacinaCalender.setDtProvavel(DateUtil.addMonths(vacina.getData(),3));
			vacinaCalender.setProxima(tpVacina.getIdProxima());
			vacinaCalender.setTpAnimal(EnumTipoAnimal.CACHORRO);
			vacinaCalender.setVacina(tpVacina);
			dao.insert(vacinaCalender);
		}
	}

}
