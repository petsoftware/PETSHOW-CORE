package br.com.petmooby.role;

import br.com.petmooby.dao.CheckInEventoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Animal;
import br.com.petmooby.model.CheckInEvento;

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
