package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.AnimalDAO;
import br.com.petshow.dao.UsuarioClienteDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Agendamento;
import br.com.petshow.model.Animal;
import br.com.petshow.model.Anuncio;
import br.com.petshow.model.UsuarioCliente;
import br.com.petshow.util.ValidationUtil;

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
