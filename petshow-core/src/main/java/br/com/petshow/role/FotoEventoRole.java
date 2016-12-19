package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.FotoEventoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Evento;
import br.com.petshow.model.FotoEvento;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class FotoEventoRole extends SuperClassRole<FotoEvento> {
	@Autowired
	private FotoEventoDAO fotoEventoDAO;

	public FotoEvento insert(FotoEvento entidade) throws ExceptionValidation{
		
		return (FotoEvento) this.fotoEventoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.fotoEventoDAO.delete(codigo);
	}

	
	public FotoEvento update(FotoEvento entidade) throws ExceptionValidation{
	
		return (FotoEvento) this.fotoEventoDAO.update(entidade);
	}

	
	public FotoEvento find(long codigo) throws ExceptionValidation {
	
		return this.fotoEventoDAO.find(codigo);
	}

}
