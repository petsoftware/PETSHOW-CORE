package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.FotoTutorDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.FotoTutor;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
public class FotoTutorRole extends SuperClassRole<FotoTutor> {

	@Autowired
	private FotoTutorDAO fotoTutorDAO;

	public FotoTutor insert(FotoTutor entidade) throws ExceptionValidation{
		
		return (FotoTutor) this.fotoTutorDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.fotoTutorDAO.delete(codigo);
	}

	
	public FotoTutor update(FotoTutor entidade) throws ExceptionValidation{
	
		return (FotoTutor) this.fotoTutorDAO.update(entidade);
	}

	
	public FotoTutor find(long codigo) throws ExceptionValidation {
	
		return this.fotoTutorDAO.find(codigo);
	}

}
