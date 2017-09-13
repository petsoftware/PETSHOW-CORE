package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.AnimalDAO;
import br.com.petmooby.dao.UsuarioClienteDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Agendamento;
import br.com.petmooby.model.Animal;
import br.com.petmooby.model.Anuncio;
import br.com.petmooby.model.UsuarioCliente;
import br.com.petmooby.util.ValidationUtil;

@Transactional
@Service
public class UsuarioClienteRole extends SuperClassRole<UsuarioCliente> {

	@Autowired
	private UsuarioClienteDAO dao;
	
	
	public UsuarioCliente insert(UsuarioCliente entidade) throws ExceptionValidation{
	
		return (UsuarioCliente) this.dao.insert(entidade);
	}


	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.dao.delete(codigo);
	}

	
	public UsuarioCliente update(UsuarioCliente entidade) throws ExceptionValidation{
	
		return (UsuarioCliente) this.dao.update(entidade);
	}

	
	public UsuarioCliente find(long codigo) throws ExceptionValidation {
	
		return this.dao.find(codigo);
	}

	
	

}
