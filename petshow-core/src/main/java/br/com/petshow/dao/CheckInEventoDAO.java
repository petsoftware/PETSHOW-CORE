package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.CheckInEvento;

@Repository
public class CheckInEventoDAO extends SuperClassDAO<CheckInEvento> {

	public CheckInEventoDAO() {
	
	}
	@Override
	public CheckInEvento find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(CheckInEvento.class, codigo);
	}

}
