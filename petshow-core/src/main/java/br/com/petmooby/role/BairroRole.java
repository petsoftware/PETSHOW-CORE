package br.com.petmooby.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.BairroDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Bairro;
import br.com.petmooby.util.ValidationUtil;



@Service
@Transactional
public class BairroRole extends SuperClassRole<Bairro> {

	@Autowired
	private BairroDAO bairroDAO;
	
	public BairroRole() {
		
	}
	
	
	
	public Bairro insert(Bairro entidade) throws ExceptionValidation {
	
		return null;
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		
		 
	}

	
	public Bairro find(long codigo) throws ExceptionValidation {
		
		return this.bairroDAO.find(codigo);
	}

	
	public Bairro update(Bairro entidade) throws ExceptionValidation {
		
		return null;
		
	}
	
	public List<Bairro> consultaPorCidade(long idCidade)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idCidade)){
			throw new ExceptionValidation("Codigo da cidade não foi informada!");
		}
		return this.bairroDAO.consultaPorCidade(idCidade);
	}
	
}
