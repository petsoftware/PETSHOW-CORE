package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.DesaparecidosDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.ComLocal;
import br.com.petshow.model.Desaparecidos;

@Service
public class DesaparecidosRole extends SuperClassRole<Desaparecidos> {

	@Autowired
	private DesaparecidosDAO desaparecidosDAO;
	
	public Desaparecidos insert(Desaparecidos entidade) throws ExceptionValidation{
		
		return (Desaparecidos) this.desaparecidosDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.desaparecidosDAO.delete(codigo);
	}

	
	public Desaparecidos update(Desaparecidos entidade) throws ExceptionValidation{
	
		return (Desaparecidos) this.desaparecidosDAO.update(entidade);
	}

	
	public Desaparecidos find(long codigo) throws ExceptionValidation {
	
		return this.desaparecidosDAO.find(codigo);
	}
	
	public List<Desaparecidos> findAll() {
		return this.desaparecidosDAO.findAll();
	}

}
