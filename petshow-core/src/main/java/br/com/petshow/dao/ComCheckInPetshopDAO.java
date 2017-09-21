package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComCheckInPetshop;
/**
 * 
 * @author antoniorafael
 * dia 23/11/2016 as 09:39
 */
@Repository
public class ComCheckInPetshopDAO extends SuperClassDAO<ComCheckInPetshop> {

	public ComCheckInPetshopDAO() {
	
	}
	

	@Override
	public ComCheckInPetshop find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(ComCheckInPetshop.class, codigo);
	}

}
