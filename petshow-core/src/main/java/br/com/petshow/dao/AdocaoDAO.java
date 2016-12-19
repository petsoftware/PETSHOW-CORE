package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Adocao;

@Repository
public class AdocaoDAO extends SuperClassDAO<Adocao> {

	public AdocaoDAO() {
		
	}

	@Override
	public Adocao find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Adocao.class, codigo);
	}

}
