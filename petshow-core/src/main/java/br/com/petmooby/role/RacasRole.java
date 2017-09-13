package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petmooby.dao.RacaDao;
import br.com.petmooby.enums.EnumTipoAnimal;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Racas;
import br.com.petmooby.util.ValidationUtil;

public class RacasRole extends SuperClassRole<Racas> {
	
	@Autowired
	private RacaDao racaDao;
	
	public Racas find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.racaDao.find(codigo);
	}

	
	

	public List<Racas> consultaRacas(EnumTipoAnimal tpAnimal)  throws ExceptionValidation {
		return this.racaDao.consultaRacas( tpAnimal);
	}




	@Override
	public Racas insert(Racas entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Racas update(Racas entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

}
