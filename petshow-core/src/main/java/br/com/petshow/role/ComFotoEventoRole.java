package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComFotoEventoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComEvento;
import br.com.petmooby.model.ComFotoEvento;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComFotoEventoRole extends SuperClassRole<ComFotoEvento> {

	@Autowired
	private ComFotoEventoDAO comFotoEventoDAO;
	
	public ComFotoEvento insert(ComFotoEvento entidade) throws ExceptionValidation{
		
		return (ComFotoEvento) this.comFotoEventoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.comFotoEventoDAO.delete(codigo);
	}

	
	public ComFotoEvento update(ComFotoEvento entidade) throws ExceptionValidation{
	
		return (ComFotoEvento) this.comFotoEventoDAO.update(entidade);
	}

	
	public ComFotoEvento find(long codigo) throws ExceptionValidation {
	
		return this.comFotoEventoDAO.find(codigo);
	}
	
	
}
