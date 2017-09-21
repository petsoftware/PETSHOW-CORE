package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComCheckInPetshopDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComCheckInLocal;
import br.com.petmooby.model.ComCheckInPetshop;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComCheckPetshopRole extends SuperClassRole<ComCheckInPetshop> {

	@Autowired
	private ComCheckInPetshopDAO checkPetshopDAO;
	
	public ComCheckInPetshop insert(ComCheckInPetshop entidade) throws ExceptionValidation{
		
		return (ComCheckInPetshop) this.checkPetshopDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.checkPetshopDAO.delete(codigo);
	}

	
	public ComCheckInPetshop update(ComCheckInPetshop entidade) throws ExceptionValidation{
	
		return (ComCheckInPetshop) this.checkPetshopDAO.update(entidade);
	}

	
	public ComCheckInPetshop find(long codigo) throws ExceptionValidation {
	
		return this.checkPetshopDAO.find(codigo);
	}
	
}
