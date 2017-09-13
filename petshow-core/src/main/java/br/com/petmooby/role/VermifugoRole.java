package br.com.petmooby.role;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.VermifugoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Vermifugo;
import br.com.petmooby.util.DateUtil;
import br.com.petmooby.util.ValidationUtil;

@Service
public class VermifugoRole extends SuperClassRole<Vermifugo> {
	
	@Autowired
	private VermifugoDAO vermifugoDAO;

	@Override
	public Vermifugo insert(Vermifugo entidade) throws ExceptionValidation {
		if(entidade.isTomou1() ==false && entidade.isTomouReforco()){
			throw new ExceptionValidation("O reforço não pode ser tomado antes da primeira dose!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDtVermifugoDose1())){
			throw new ExceptionValidation("A data da primeira dose não foi informada!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDtVermifugoDoseReforco())){
			throw new ExceptionValidation("A data do reforço não foi informado");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getAnimal())){
			throw new ExceptionValidation("O animal não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getFrequencia())){
			throw new ExceptionValidation("A frequência não foi informada!");
		}

		cadastrarVermifugoAnterior(entidade); 
		
		
		return (Vermifugo) this.vermifugoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.vermifugoDAO.delete(codigo);
		
	}

	@Override
	public Vermifugo update(Vermifugo entidade) throws ExceptionValidation {
		
		
		if(entidade.isTomou1() ==false && entidade.isTomouReforco()){
			throw new ExceptionValidation("O reforço não pode ser tomado antes da primeira dose!");
		}
		
		if(!ValidationUtil.isCampoComValor(entidade.getDtVermifugoDose1())){
			throw new ExceptionValidation("A data da primeira dose não foi informada!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDtVermifugoDoseReforco())){
			throw new ExceptionValidation("A data do reforço não foi informado");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getAnimal())){
			throw new ExceptionValidation("O animal não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getFrequencia())){
			throw new ExceptionValidation("A frequência não foi informada!");
		}
		
		cadastrarVermifugoAnterior(entidade); 
		
		
		return (Vermifugo) this.vermifugoDAO.update(entidade);
	}

	@Override
	public Vermifugo find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.vermifugoDAO.find(codigo);
	}
	
	public Vermifugo consultaPorAnimal(Long id)  throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.vermifugoDAO.consultaPorAnimal(id);
	}
	
	public void cadastrarVermifugoAnterior(Vermifugo vermifugo) throws ExceptionValidation {
		if(vermifugo.isTomou1() && vermifugo.isTomouReforco()){
			
			vermifugo.setDtVermifugoDose1Ant(vermifugo.getDtVermifugoDose1());
			vermifugo.setDtVermifugoDoseReforcoAnt(vermifugo.getDtVermifugoDoseReforco());
			
			Date dateNovaDose1 = new Date();
			dateNovaDose1.setTime(vermifugo.getDtVermifugoDose1().getTime());
			dateNovaDose1=DateUtil.addDays(dateNovaDose1, DateUtil.getDaysFrequenciaVermifugo(vermifugo.getFrequencia()));
			vermifugo.setDtVermifugoDose1(dateNovaDose1);
			

			Date dateNovaReforco = new Date();
			dateNovaReforco.setTime(vermifugo.getDtVermifugoDose1().getTime());
			dateNovaReforco=DateUtil.addDays(dateNovaReforco, 15);
			vermifugo.setDtVermifugoDoseReforco(dateNovaReforco);
			
			
			vermifugo.setTomou1(false);
			vermifugo.setTomouReforco(false);
			
		}
	}
	
	

}