package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Local;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class LocalDAO extends SuperClassDAO<Local> {

	public LocalDAO() {
	 
	}
	
	@Override
	public Local find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Local.class, codigo);
	}

}
