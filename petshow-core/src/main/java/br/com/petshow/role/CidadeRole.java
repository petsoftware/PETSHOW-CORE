package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.CidadeDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Cidade;
import br.com.petshow.util.ValidationUtil;



@Service
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
	
	public List<Cidade> consultaPorEstado(String uf)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(uf)){
			throw new ExceptionValidation("A UF não foi informada!");
		}
		return this.cidadeDAO.consultaPorEstado(uf);
	}
	
}
