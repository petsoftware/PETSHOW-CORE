package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.BairroDAO;
import br.com.petshow.dao.EstadoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;

import br.com.petshow.model.Bairro;
import br.com.petshow.model.Estado;
import br.com.petshow.util.ValidationUtil;



@Service
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
