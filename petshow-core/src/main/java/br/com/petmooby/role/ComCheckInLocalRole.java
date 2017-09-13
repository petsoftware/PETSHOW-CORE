package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComCheckInLocalDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComCheckInEvento;
import br.com.petmooby.model.ComCheckInLocal;
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
