package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComCheckInEventoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.CheckInPetshop;
import br.com.petmooby.model.ComCheckInEvento;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComCheckInEventoRole extends SuperClassRole<ComCheckInEvento> {

	@Autowired
	private ComCheckInEventoDAO chekInEventoDAO;

	public ComCheckInEvento insert(ComCheckInEvento entidade) throws ExceptionValidation{
		
		return (ComCheckInEvento) this.chekInEventoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.chekInEventoDAO.delete(codigo);
	}

	
	public ComCheckInEvento update(ComCheckInEvento entidade) throws ExceptionValidation{
	
		return (ComCheckInEvento) this.chekInEventoDAO.update(entidade);
	}

	
	public ComCheckInEvento find(long codigo) throws ExceptionValidation {
	
		return this.chekInEventoDAO.find(codigo);
	}
	

}
