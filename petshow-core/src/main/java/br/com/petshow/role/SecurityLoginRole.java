package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.commons.security.HandleEncrypt;
import br.com.petshow.dao.SecurityLoginDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.SecurityLogin;

@Service
public class SecurityLoginRole extends SuperClassRole<SecurityLogin> {

	
	@Autowired
	private SecurityLoginDAO dao;
	@Override
	public SecurityLogin insert(SecurityLogin entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		if(entidade==null){
			throw new ExceptionValidation("SecurityLogin tem o sel valor nulo");
		}
		String crypt = HandleEncrypt.encrypt(entidade.getEmail());
		entidade.setKey(crypt);
		entidade.setValidate(false);
		return dao.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityLogin update(SecurityLogin entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityLogin find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

}
