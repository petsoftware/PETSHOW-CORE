package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.EstadoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Estado;



@Service
@Transactional
public class EstadoRole extends SuperClassRole<Estado> {

	@Autowired
	private EstadoDAO estadoDAO;
	
	public EstadoRole() {
		
	}
	
	
	
	public Estado insert(Estado entidade) throws ExceptionValidation {
	
		return null;
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		
		 
	}

	
	public Estado find(long codigo) throws ExceptionValidation {
		
		return this.estadoDAO.find(codigo);
	}

	
	public Estado update(Estado entidade) throws ExceptionValidation {
		
		return null;
		
	}
	
	public List<Estado> getEstados()  throws  ExceptionValidation{
	
		return this.estadoDAO.consultaEstados();
	}
	
}
