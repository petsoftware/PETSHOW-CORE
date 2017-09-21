package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.petshow.enums.EnumUF;
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
		return manager.createNamedQuery(Cidade.CIDADE_POR_ESTADO_POR_ID,Cidade.class).setParameter("id", id).getResultList();
	}
	public List<Cidade> consultaPorEstadoUF(String uf)  {
		
		return manager.createNamedQuery(Cidade.CIDADE_POR_ESTADO_POR_UF,Cidade.class).setParameter("uf", uf).getResultList();
	}
	
	public  List<Cidade> findAllByUF(EnumUF enumUF) {
		try{
			TypedQuery<Cidade> qry = getManager().createNamedQuery(Cidade.FIND_ALL_BY_UF, Cidade.class)
					.setParameter("uf", enumUF);
			return qry.getResultList();
		}catch(NoResultException e){
			return new ArrayList<>();
		}
	}
}
