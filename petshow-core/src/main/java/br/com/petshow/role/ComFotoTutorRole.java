package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComFotoTutorDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComFotoLocal;
import br.com.petshow.model.ComFotoTutor;

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
