package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.ComCheckInLocal;
@Repository
public class ComCheckInLocalDAO extends SuperClassDAO<ComCheckInLocal> {

	public ComCheckInLocalDAO() {
	
	}
	@Override
	public ComCheckInLocal find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(ComCheckInLocal.class, codigo);
	}

}
