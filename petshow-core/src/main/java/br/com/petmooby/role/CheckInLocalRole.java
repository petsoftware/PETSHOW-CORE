package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.AgendamentoDAO;
import br.com.petmooby.dao.CheckInLocalDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.CheckInEvento;
import br.com.petmooby.model.CheckInLocal;

@Service
public class CheckInLocalRole extends SuperClassRole<CheckInLocal> {

	@Autowired
	private CheckInLocalDAO checkInLocalDAO;
	
	public CheckInLocal insert(CheckInLocal entidade) throws ExceptionValidation{
		
		return (CheckInLocal) this.checkInLocalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.checkInLocalDAO.delete(codigo);
	}

	
	public CheckInLocal update(CheckInLocal entidade) throws ExceptionValidation{
	
		return (CheckInLocal) this.checkInLocalDAO.update(entidade);
	}

	
	public CheckInLocal find(long codigo) throws ExceptionValidation {
	
		return this.checkInLocalDAO.find(codigo);
	}

}
