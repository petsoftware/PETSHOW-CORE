package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.FotoTutorDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.FotoLocal;
import br.com.petshow.model.FotoTutor;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
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
