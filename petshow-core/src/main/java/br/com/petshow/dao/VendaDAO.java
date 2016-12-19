package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Venda;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class VendaDAO extends SuperClassDAO<Venda> {

	public VendaDAO() {
	
	}
	
	@Override
	public Venda find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Venda.class, codigo);
	}

}
