package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
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
	
public List<Venda> consultaPorUsuario(long idUsuario)  {
		
		
		return manager.createNamedQuery(Venda.VENDA_POR_USUARIO).setParameter("idUsuario", idUsuario).getResultList();
	}

}
