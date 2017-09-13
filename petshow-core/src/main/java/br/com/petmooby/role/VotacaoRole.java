package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.VotacaoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Venda;
import br.com.petmooby.model.Votacao;

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
