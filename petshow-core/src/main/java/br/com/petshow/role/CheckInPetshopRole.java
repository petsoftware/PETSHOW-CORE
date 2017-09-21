package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.CheckInPetshopDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.CheckInLocal;
import br.com.petmooby.model.CheckInPetshop;
@Service
public class CheckInPetshopRole extends SuperClassRole<CheckInPetshop> {

	@Autowired
	private CheckInPetshopDAO checkInPetshopDAO;
	
	public CheckInPetshop insert(CheckInPetshop entidade) throws ExceptionValidation{
		
		return (CheckInPetshop) this.checkInPetshopDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.checkInPetshopDAO.delete(codigo);
	}

	
	public CheckInPetshop update(CheckInPetshop entidade) throws ExceptionValidation{
	
		return (CheckInPetshop) this.checkInPetshopDAO.update(entidade);
	}

	
	public CheckInPetshop find(long codigo) throws ExceptionValidation {
	
		return this.checkInPetshopDAO.find(codigo);
	}

}
