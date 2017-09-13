package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.ComLocalDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComLocal;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
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
