package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.EventoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Evento;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
public class EventoRole extends SuperClassRole<Evento> {
	@Autowired
	private EventoDAO eventoDAO;
	
	public Evento insert(Evento entidade) throws ExceptionValidation{
		
		return (Evento) this.eventoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.eventoDAO.delete(codigo);
	}

	
	public Evento update(Evento entidade) throws ExceptionValidation{
	
		return (Evento) this.eventoDAO.update(entidade);
	}

	
	public Evento find(long codigo) throws ExceptionValidation {
	
		return this.eventoDAO.find(codigo);
	}
	
	public List<Evento> findAll() {
		return this.eventoDAO.findAll();
	}
}
