package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.CheckInPetshop;

@Repository
public class CheckInPetshopDAO extends SuperClassDAO<CheckInPetshop> {

	public CheckInPetshopDAO() {
		
	}
	@Override
	public CheckInPetshop find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(CheckInPetshop.class, codigo);
	}

}
