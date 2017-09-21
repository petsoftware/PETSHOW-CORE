package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComFotoLocal;
@Repository
public class ComFotoLocalDAO extends SuperClassDAO<ComFotoLocal> {

	public ComFotoLocalDAO() {
		
	}
	
	
	@Override
	public ComFotoLocal find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(ComFotoLocal.class, codigo);
	}

}
