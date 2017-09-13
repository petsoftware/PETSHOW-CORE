package br.com.petmooby.dao;

import org.springframework.stereotype.Service;

import br.com.petmooby.model.CheckInLocal;
@Service
public class CheckInLocalDAO extends SuperClassDAO<CheckInLocal> {

	public CheckInLocalDAO() {
		
	}
	
	@Override
	public CheckInLocal find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(CheckInLocal.class, codigo);
	}

}
