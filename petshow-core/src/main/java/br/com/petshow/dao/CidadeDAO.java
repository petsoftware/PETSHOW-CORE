package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Cidade;


@Repository
public class CidadeDAO extends SuperClassDAO<Cidade>{
	public CidadeDAO() {
		
	}


	public Cidade find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Cidade.class, codigo);
	}

	public List<Cidade> consultaPorEstado(String uf)  {
		
		return manager.createNamedQuery(Cidade.CIDADE_POR_ESTADO).setParameter("uf", uf).getResultList();
	}
}
