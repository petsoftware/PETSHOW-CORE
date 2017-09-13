package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.CidadeDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Anuncio;
import br.com.petmooby.model.Cidade;
import br.com.petmooby.util.ValidationUtil;



@Service
@Transactional
public class CidadeRole extends SuperClassRole<Cidade> {

	@Autowired
	private CidadeDAO cidadeDAO;
	
	public CidadeRole() {
		System.out.println("TODO Auto-generated constructor stub " );
	}
	
	
	
	public Cidade insert(Cidade entidade) throws ExceptionValidation {
	
		return null;
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		
		 
	}

	
	public Cidade find(long codigo) throws ExceptionValidation {
		
		return this.cidadeDAO.find(codigo);
	}

	
	public Cidade update(Cidade entidade) throws ExceptionValidation {
		
		return null;
		
	}
	
	public List<Cidade> consultaPorEstadoID(long id)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id do estado não foi informada!");
		}
		return this.cidadeDAO.consultaPorEstadoID(id);
	}
	public List<Cidade> consultaPorEstadoUF(String uf)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(uf)){
			throw new ExceptionValidation("A UF não foi informada!");
		}
		return this.cidadeDAO.consultaPorEstadoUF(uf);
	}
	
}
