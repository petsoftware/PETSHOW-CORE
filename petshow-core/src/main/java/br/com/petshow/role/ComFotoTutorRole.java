package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.ComFotoTutorDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.ComFotoLocal;
import br.com.petmooby.model.ComFotoTutor;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ComFotoTutorRole extends SuperClassRole<ComFotoTutor> {

	@Autowired
	private ComFotoTutorDAO comFotoTutorDAO;
	
	public ComFotoTutor insert(ComFotoTutor entidade) throws ExceptionValidation{
		
		return (ComFotoTutor) this.comFotoTutorDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.comFotoTutorDAO.delete(codigo);
	}

	
	public ComFotoTutor update(ComFotoTutor entidade) throws ExceptionValidation{
	
		return (ComFotoTutor) this.comFotoTutorDAO.update(entidade);
	}

	
	public ComFotoTutor find(long codigo) throws ExceptionValidation {
	
		return this.comFotoTutorDAO.find(codigo);
	}

	

}
