package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.FotoEvento;
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
