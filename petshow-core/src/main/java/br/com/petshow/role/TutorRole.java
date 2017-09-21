package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.TutorDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Tutor;
import br.com.petshow.model.Usuario;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class TutorRole extends SuperClassRole<Tutor> {
	
	public TutorRole() {
	}
	@Autowired
	private TutorDAO tutorDAO;

	public Tutor insert(Tutor entidade) throws ExceptionValidation{
		return (Tutor) this.tutorDAO.insert(entidade);
	}

	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.tutorDAO.delete(codigo);
	}

	public Tutor update(Tutor entidade) throws ExceptionValidation{
	
		return (Tutor) this.tutorDAO.update(entidade);
	}

	public Tutor find(long codigo) throws ExceptionValidation {
	
		return this.tutorDAO.find(codigo);
	}

	public Tutor findByUser(Usuario usuario) {
		return tutorDAO.findByUser(usuario);
	}
}
