package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.FotoLocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.FotoLocal;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
public class FotoLocalRole extends SuperClassRole<FotoLocal> {

	@Autowired
	private FotoLocalDAO fotoLocalDAO;

	public FotoLocal insert(FotoLocal entidade) throws ExceptionValidation{
		
		return (FotoLocal) this.fotoLocalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.fotoLocalDAO.delete(codigo);
	}

	
	public FotoLocal update(FotoLocal entidade) throws ExceptionValidation{
	
		return (FotoLocal) this.fotoLocalDAO.update(entidade);
	}

	
	public FotoLocal find(long codigo) throws ExceptionValidation {
	
		return this.fotoLocalDAO.find(codigo);
	}
}
