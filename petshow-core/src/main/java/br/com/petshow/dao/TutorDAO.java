package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Tutor;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class TutorDAO extends SuperClassDAO<Tutor> {

	public TutorDAO() {
		 
	}
	
		@Override
	public Tutor find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Tutor.class, codigo);
	}

}
