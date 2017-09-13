package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.ComFotoEvento;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class ComFotoEventoDAO extends SuperClassDAO<ComFotoEvento> {

	public ComFotoEventoDAO() {
		
	}
	
	@Override
	public ComFotoEvento find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(ComFotoEvento.class, codigo);
	}

}
