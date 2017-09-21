package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComEventoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComCheckInPetshop;
import br.com.petmooby.model.ComEvento;

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
