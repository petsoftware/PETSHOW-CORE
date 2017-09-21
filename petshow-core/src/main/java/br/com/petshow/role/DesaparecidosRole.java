package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.DesaparecidosDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Desaparecidos;

@Service
@Transactional
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
