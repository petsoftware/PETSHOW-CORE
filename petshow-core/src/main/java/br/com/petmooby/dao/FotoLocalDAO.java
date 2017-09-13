package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.FotoLocal;
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
