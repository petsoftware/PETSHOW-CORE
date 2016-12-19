package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.VendaDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Usuario;
import br.com.petshow.model.Venda;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class VendaRole extends SuperClassRole<Venda> {

	@Autowired
	private VendaDAO vendaDAO;

	public Venda insert(Venda entidade) throws ExceptionValidation{
		
		return (Venda) this.vendaDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.vendaDAO.delete(codigo);
	}

	
	public Venda update(Venda entidade) throws ExceptionValidation{
	
		return (Venda) this.vendaDAO.update(entidade);
	}

	
	public Venda find(long codigo) throws ExceptionValidation {
	
		return this.vendaDAO.find(codigo);
	}

	
}
