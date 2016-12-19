package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.LocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.FotoTutor;
import br.com.petshow.model.Local;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class LocalRole extends SuperClassRole<Local> {

	@Autowired
	private LocalDAO localDAO;

	public Local insert(Local entidade) throws ExceptionValidation{
		
		return (Local) this.localDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.localDAO.delete(codigo);
	}

	
	public Local update(Local entidade) throws ExceptionValidation{
	
		return (Local) this.localDAO.update(entidade);
	}

	
	public Local find(long codigo) throws ExceptionValidation {
	
		return this.localDAO.find(codigo);
	}
	

}
