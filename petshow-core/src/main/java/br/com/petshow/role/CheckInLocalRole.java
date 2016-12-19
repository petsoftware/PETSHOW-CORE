package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AgendamentoDAO;
import br.com.petshow.dao.CheckInLocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.CheckInEvento;
import br.com.petshow.model.CheckInLocal;

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
