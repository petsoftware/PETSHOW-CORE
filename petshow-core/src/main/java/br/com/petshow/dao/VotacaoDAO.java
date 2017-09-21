package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Votacao;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class VotacaoDAO extends SuperClassDAO<Votacao> {

	@Override
	public Votacao find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Votacao.class, codigo);
	}

}
