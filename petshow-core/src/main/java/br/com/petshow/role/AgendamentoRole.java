package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshow.dao.AgendamentoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Agendamento;

public class AgendamentoRole extends SuperClassRole<Agendamento> {

	@Autowired
	private AgendamentoDAO agendamentoDAO;
	
	
	public Agendamento insert(Agendamento entidade) throws ExceptionValidation{
		// TODO Auto-generated method stub
		return (Agendamento) this.agendamentoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
		// TODO Auto-generated method stub
		 this.agendamentoDAO.delete(codigo);
	}

	@Override
	public Agendamento update(Agendamento entidade) throws ExceptionValidation{
		// TODO Auto-generated method stub
		return (Agendamento) this.agendamentoDAO.update(entidade);
	}

	@Override
	public Agendamento find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return this.agendamentoDAO.find(codigo);
	}

}
