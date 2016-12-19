package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComFotoEvento;
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
