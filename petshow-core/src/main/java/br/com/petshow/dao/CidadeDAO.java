package br.com.petshow.dao;

import java.util.Date;
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

	public List<Cidade> consultaPorEstadoID(long id)  {
		System.out.println("trace descobrir lentidao:entrou consultaPorEstadoID:"+new Date().toString());
		return manager.createNamedQuery(Cidade.CIDADE_POR_ESTADO_POR_ID).setParameter("id", id).getResultList();
	}
public List<Cidade> consultaPorEstadoUF(String uf)  {
		
		return manager.createNamedQuery(Cidade.CIDADE_POR_ESTADO_POR_UF).setParameter("uf", uf).getResultList();
	}
}
