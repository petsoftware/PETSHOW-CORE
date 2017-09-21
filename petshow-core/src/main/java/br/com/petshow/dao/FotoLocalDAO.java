package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.FotoLocal;
@Repository
public class FotoLocalDAO extends SuperClassDAO<FotoLocal> {

	public FotoLocalDAO() {
		
	}

	@Override
	public FotoLocal find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(FotoLocal.class, codigo);
	}

}
