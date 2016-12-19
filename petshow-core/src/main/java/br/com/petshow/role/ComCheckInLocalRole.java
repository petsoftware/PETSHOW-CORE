package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComCheckInLocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComCheckInEvento;
import br.com.petshow.model.ComCheckInLocal;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComCheckInLocalRole extends SuperClassRole<ComCheckInLocal> {

	@Autowired
	private ComCheckInLocalDAO checkInLocalDAO;
	
	public ComCheckInLocal insert(ComCheckInLocal entidade) throws ExceptionValidation{
		
		return (ComCheckInLocal) this.checkInLocalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.checkInLocalDAO.delete(codigo);
	}

	
	public ComCheckInLocal update(ComCheckInLocal entidade) throws ExceptionValidation{
	
		return (ComCheckInLocal) this.checkInLocalDAO.update(entidade);
	}

	
	public ComCheckInLocal find(long codigo) throws ExceptionValidation {
	
		return this.checkInLocalDAO.find(codigo);
	}



}
