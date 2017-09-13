package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.ComLocal;
@Repository
public class ComLocalDAO extends SuperClassDAO<ComLocal> {

	
	public ComLocalDAO() {
		
	}
	
	public ComLocal find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(ComLocal.class, codigo);
	}

}
