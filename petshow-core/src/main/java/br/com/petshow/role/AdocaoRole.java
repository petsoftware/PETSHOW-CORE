package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AdocaoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Adocao;

@Service
public class AdocaoRole extends SuperClassRole<Adocao> {

	@Autowired
	private AdocaoDAO adocaoDAO;
	
	public AdocaoRole() {
		System.out.println("TODO Auto-generated constructor stub " );
	}
	
	/*@Autowired
	public AdocaoRole(AdocaoDAO adocaoDAO) {
		System.out.println("TODO Auto-generated constructor stub >>>>>>>>>>>");
	}*/
	
	
	public Adocao insert(Adocao entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return this.adocaoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		
		 this.adocaoDAO.delete(codigo);
	}

	
	public Adocao find(long codigo) throws ExceptionValidation {
		
		return this.adocaoDAO.find(codigo);
	}

	
	public Adocao update(Adocao entidade) throws ExceptionValidation {
		
		return this.adocaoDAO.update(entidade);
		
	}
	
}
