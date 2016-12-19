package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComEventoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComCheckInPetshop;
import br.com.petshow.model.ComEvento;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComEventoRole extends SuperClassRole<ComEvento> {

	@Autowired
	private ComEventoDAO comEventoDAO;
	
	
	public ComEvento insert(ComEvento entidade) throws ExceptionValidation{
		
		return (ComEvento) this.comEventoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.comEventoDAO.delete(codigo);
	}

	
	public ComEvento update(ComEvento entidade) throws ExceptionValidation{
	
		return (ComEvento) this.comEventoDAO.update(entidade);
	}

	
	public ComEvento find(long codigo) throws ExceptionValidation {
	
		return this.comEventoDAO.find(codigo);
	}
	
	

}
