package br.com.petshow.role;

import br.com.petshow.dao.CheckInEventoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Animal;
import br.com.petshow.model.CheckInEvento;

public class CheckInEventoRole extends SuperClassRole<CheckInEvento> {

	private CheckInEventoDAO CheckInEventoDAO;
	
	public CheckInEvento insert(CheckInEvento entidade) throws ExceptionValidation{
		
		return (CheckInEvento) this.CheckInEventoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.CheckInEventoDAO.delete(codigo);
	}

	
	public CheckInEvento update(CheckInEvento entidade) throws ExceptionValidation{
	
		return (CheckInEvento) this.CheckInEventoDAO.update(entidade);
	}

	
	public CheckInEvento find(long codigo) throws ExceptionValidation {
	
		return this.CheckInEventoDAO.find(codigo);
	}


}
