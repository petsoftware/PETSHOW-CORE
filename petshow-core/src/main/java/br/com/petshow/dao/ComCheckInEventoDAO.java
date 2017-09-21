package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComCheckInEvento;
@Repository
public class ComCheckInEventoDAO extends SuperClassDAO<ComCheckInEvento> {

	public ComCheckInEventoDAO() {
		
	}
	
	@Override
	public ComCheckInEvento find(long codigo)  {
		// TODO Auto-generated method stub
		return manager.find(ComCheckInEvento.class, codigo);
	}

}
