package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.CheckInPetshopDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.CheckInLocal;
import br.com.petshow.model.CheckInPetshop;
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
