package br.com.petmooby.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Animal;
import br.com.petmooby.model.UsuarioCliente;


@Repository
public class UsuarioClienteDAO extends SuperClassDAO<UsuarioCliente> {

	public UsuarioClienteDAO() {
	
	}

	

	public UsuarioCliente find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(UsuarioCliente.class, codigo);
	}
	
	
	

}
