package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshow.dao.TratamentoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Tratamento;
import br.com.petshow.util.ValidationUtil;

public class TratamentoRole  extends SuperClassRole<Tratamento> {

	@Autowired
	private TratamentoDAO tratamentoDAO;
	@Override
	public Tratamento insert(Tratamento entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return (Tratamento) this.tratamentoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.tratamentoDAO.delete(codigo);
		
	}

	@Override
	public Tratamento update(Tratamento entidade) throws ExceptionValidation {
		return (Tratamento) this.tratamentoDAO.update(entidade);
	}

	@Override
	public Tratamento find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.tratamentoDAO.find(codigo);
	}


	public List<Tratamento> consultaPorAnimal(Long id)  throws ExceptionValidation {
	
	if(!ValidationUtil.isCampoComValor(id)){
		throw new ExceptionValidation("O id não foi informado!");
	}
	return this.tratamentoDAO.consultaPorAnimal(id);
}
}

