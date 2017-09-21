package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComFotoTutor;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class ComFotoTutorDAO extends SuperClassDAO<ComFotoTutor> {

	public ComFotoTutorDAO() {
		
	}
	
	@Override
	public ComFotoTutor find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(ComFotoTutor.class, codigo);
	}

}
