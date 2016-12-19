package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AnuncioDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Usuario;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class AnuncioRole extends SuperClassRole<Anuncio> {

	@Autowired
	private AnuncioDAO anuncioDAO;
	

	public Anuncio insert(Anuncio entidade) throws ExceptionValidation {
		return ((Anuncio)anuncioDAO.insert(entidade));
	}


	public void delete(long codigo) throws  ExceptionValidation,ExceptionNotFoundRecord {
		this.anuncioDAO.delete(codigo);
	}

	public Anuncio find(long codigo)  throws  ExceptionValidation {
		return anuncioDAO.find(codigo);
	}


	public Anuncio update(Anuncio entidade)  throws  ExceptionValidation{
		return ((Anuncio)anuncioDAO.update(entidade));
	}
	
	public List<Anuncio> consultaPorUsuario(long idUsuario) {
		return this.anuncioDAO.consultaPorUsuario(idUsuario);
	}
	
}
