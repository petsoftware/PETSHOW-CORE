package br.com.tarefa.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AnimalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Animal;
import br.com.petshow.model.Servico;
import br.com.petshow.role.SuperClassRole;
import br.com.petshow.util.ValidationUtil;
import br.com.tafera.enums.EnumStatus;
import br.com.tarefa.dao.TarefaDAO;
import br.com.tarefa.model.Tarefa;

@Service
public class TarefaRole  extends SuperClassRole<Tarefa> {

			@Autowired
			private TarefaDAO tarefaDAO;
			
			
			public Tarefa insert(Tarefa entidade) throws ExceptionValidation{
			
				entidade.setStatus(EnumStatus.ABERTA);
				return (Tarefa) this.tarefaDAO.insert(entidade);
			}

			@Override
			public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
			
				 this.tarefaDAO.delete(codigo);
			}

			
			public Tarefa update(Tarefa entidade) throws ExceptionValidation{
			
				return (Tarefa) this.tarefaDAO.update(entidade);
			}

			
			public Tarefa find(long codigo) throws ExceptionValidation {
			
				return this.tarefaDAO.find(codigo);
			}
			
			public Tarefa alterarStatus(Tarefa entidade) throws ExceptionValidation {
				Tarefa tarefa = find(entidade.getId());
				
				if(entidade.getObservacao()==null){
					entidade.setObservacao(new ArrayList<String>());
				}
				entidade.getObservacao().add("Status da tarefa alterado de "+tarefa.getStatus().toString()+" para "+entidade.getStatus().toString());
								
				
				return (Tarefa) this.tarefaDAO.update(entidade);
			}
			
			public List<Tarefa> consultaTarefas()  throws  ExceptionValidation{
			
				return this.tarefaDAO.consultaTarefas();
			}
		
			
}
