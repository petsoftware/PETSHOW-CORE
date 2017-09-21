package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.ComFotoTutor;
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
