package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshow.dao.RacaDao;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;

import br.com.petshow.model.Racas;
import br.com.petshow.util.ValidationUtil;

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
