package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ComFotoLocalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComFotoEvento;
import br.com.petshow.model.ComFotoLocal;

@Service
public class ComFotoLocalRole extends SuperClassRole<ComFotoLocal> {

	@Autowired
	private ComFotoLocalDAO comFotoLocalDAO;

	public ComFotoLocal insert(ComFotoLocal entidade) throws ExceptionValidation{
		
		return (ComFotoLocal) this.comFotoLocalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.comFotoLocalDAO.delete(codigo);
	}

	
	public ComFotoLocal update(ComFotoLocal entidade) throws ExceptionValidation{
	
		return (ComFotoLocal) this.comFotoLocalDAO.update(entidade);
	}

	
	public ComFotoLocal find(long codigo) throws ExceptionValidation {
	
		return this.comFotoLocalDAO.find(codigo);
	}

	

}
