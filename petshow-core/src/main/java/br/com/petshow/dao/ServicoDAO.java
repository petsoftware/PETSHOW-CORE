package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Servico;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class ServicoDAO extends SuperClassDAO<Servico> {

	public ServicoDAO() {
	
	}
		@Override
	public Servico find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Servico.class, codigo);
	}

}
