package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.ServicoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.PerfilAnimal;
import br.com.petshow.model.Servico;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ServicoRole extends SuperClassRole<Servico> {

	@Autowired
	private ServicoDAO servicoDAO;

	public Servico insert(Servico entidade) throws ExceptionValidation{
		
		return (Servico) this.servicoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.servicoDAO.delete(codigo);
	}

	
	public Servico update(Servico entidade) throws ExceptionValidation{
	
		return (Servico) this.servicoDAO.update(entidade);
	}

	
	public Servico find(long codigo) throws ExceptionValidation {
	
		return this.servicoDAO.find(codigo);
	}

}
