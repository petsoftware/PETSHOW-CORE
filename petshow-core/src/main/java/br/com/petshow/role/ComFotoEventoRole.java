package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComFotoEventoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComEvento;
import br.com.petshow.model.ComFotoEvento;

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
