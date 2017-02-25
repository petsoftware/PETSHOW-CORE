package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Estado;


@Repository
public class EstadoDAO extends SuperClassDAO<Estado>{
	public EstadoDAO() {
		
	}


	public Estado find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Estado.class, codigo);
	}

	public List<Estado> consultaEstados()  {
		
		return manager.createNamedQuery(Estado.ALL).getResultList();
	}
}
