package br.com.tarefa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petmooby.dao.SuperClassDAO;
import br.com.petmooby.model.Animal;
import br.com.petmooby.model.Servico;
import br.com.tarefa.model.Tarefa;

@Repository
public class TarefaDAO extends SuperClassDAO<Tarefa> {

	public TarefaDAO() {
	
	}

	

	public Tarefa find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Tarefa.class, codigo);
	}
	
	
	public List<Tarefa> consultaTarefas()  {

		return manager.createNamedQuery(Tarefa.TODAS).getResultList();
	}
}
