package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.LocalDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Local;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
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
