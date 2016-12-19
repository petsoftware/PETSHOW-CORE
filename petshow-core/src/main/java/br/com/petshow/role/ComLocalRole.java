package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComLocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComFotoTutor;
import br.com.petshow.model.ComLocal;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComLocalRole extends SuperClassRole<ComLocal> {

	@Autowired
	private ComLocalDAO comLocalDAO;
	
	public ComLocal insert(ComLocal entidade) throws ExceptionValidation{
		
		return (ComLocal) this.comLocalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.comLocalDAO.delete(codigo);
	}

	
	public ComLocal update(ComLocal entidade) throws ExceptionValidation{
	
		return (ComLocal) this.comLocalDAO.update(entidade);
	}

	
	public ComLocal find(long codigo) throws ExceptionValidation {
	
		return this.comLocalDAO.find(codigo);
	}

	
}
