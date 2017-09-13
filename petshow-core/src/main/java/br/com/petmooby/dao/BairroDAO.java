package br.com.petmooby.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Bairro;


@Repository
public class BairroDAO extends SuperClassDAO<Bairro>{
	public BairroDAO() {
		
	}


	public Bairro find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Bairro.class, codigo);
	}

	public List<Bairro> consultaPorCidade(long idCidade)  {
		
		return manager.createNamedQuery(Bairro.BAIRRO_POR_CIDADE).setParameter("idCidade", idCidade).getResultList();
	}
}
