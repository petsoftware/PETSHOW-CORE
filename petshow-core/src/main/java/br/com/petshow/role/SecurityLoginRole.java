package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.SecurityLoginDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.SecurityLogin;
import br.com.petshow.util.KeyNewUserValidateUtil;

@Service
@Transactional
public class SecurityLoginRole extends SuperClassRole<SecurityLogin> {

	
	@Autowired
	private SecurityLoginDAO dao;
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public SecurityLogin insert(SecurityLogin entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		if(entidade==null){
			throw new ExceptionValidation("SecurityLogin tem o seu valor nulo");
		}
		String cryptKey = KeyNewUserValidateUtil.genarateKeyValue(entidade);
		entidade.setKey(cryptKey);
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
