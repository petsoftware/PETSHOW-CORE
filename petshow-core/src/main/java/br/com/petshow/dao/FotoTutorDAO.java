package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.FotoTutor;
@Repository
public class FotoTutorDAO extends SuperClassDAO<FotoTutor> {

	public FotoTutorDAO() {
		
	}
	
	@Override
	public FotoTutor find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(FotoTutor.class, codigo);
	}

}
