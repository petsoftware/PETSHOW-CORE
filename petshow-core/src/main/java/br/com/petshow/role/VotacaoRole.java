package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.VotacaoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Venda;
import br.com.petshow.model.Votacao;

@Service
public class VotacaoRole extends SuperClassRole<Votacao> {

	@Autowired
	private VotacaoDAO votacaoDAO;

	public Votacao insert(Votacao entidade) throws ExceptionValidation{
		
		return (Votacao) this.votacaoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.votacaoDAO.delete(codigo);
	}

	
	public Votacao update(Votacao entidade) throws ExceptionValidation{
	
		return (Votacao) this.votacaoDAO.update(entidade);
	}

	
	public Votacao find(long codigo) throws ExceptionValidation {
	
		return this.votacaoDAO.find(codigo);
	}
}
