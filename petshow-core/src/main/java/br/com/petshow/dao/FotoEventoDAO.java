package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.FotoEvento;
@Repository
public class FotoEventoDAO extends SuperClassDAO<FotoEvento> {

	public FotoEventoDAO() {
	
	}
	
	@Override
	public FotoEvento find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(FotoEvento.class, codigo);
	}

}
