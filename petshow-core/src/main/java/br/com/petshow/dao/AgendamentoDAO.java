package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Agendamento;
@Repository
public class AgendamentoDAO extends SuperClassDAO<Agendamento> {

	@Override
	public Agendamento find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Agendamento.class, codigo);
	}

}
