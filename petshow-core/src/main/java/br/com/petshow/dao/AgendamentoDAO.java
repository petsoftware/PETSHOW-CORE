package br.com.petshow.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Agendamento;
@Repository
public class AgendamentoDAO extends SuperClassDAO<Agendamento> {

	@Override
	public Agendamento find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Agendamento.class, codigo);
	}
	public List<Agendamento> getAgendamentosPendentes(long idServico,Date dtHoje)  {

		return manager.createNamedQuery(Agendamento.AGENDAMENTO_PENDENTE).setParameter("idServico", idServico).setParameter("dataHJ", dtHoje).getResultList();
	}
}
