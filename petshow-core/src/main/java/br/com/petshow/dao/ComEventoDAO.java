package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.ComEvento;
/**
 * 
 * @author antoniorafael
 * @since Versão 1.0 - dia 23/11/2016 as 09:42
 */
@Repository
public class ComEventoDAO extends SuperClassDAO<ComEvento> {

	public ComEventoDAO() {
		
	}
	
	@Override
	public ComEvento find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(ComEvento.class, codigo);
	}

}
