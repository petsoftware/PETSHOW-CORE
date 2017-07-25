package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.PerfilAdocaoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.PerfilAdocao;

@Service
@Transactional
public class PerfilAdocaoRole extends SuperClassRole<PerfilAdocao>{

	@Autowired
	private PerfilAdocaoDAO dao;
	@Override
	public PerfilAdocao insert(PerfilAdocao entidade) throws ExceptionValidation {
		
		return dao.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		dao.delete(codigo);
		
	}

	@Override
	public PerfilAdocao update(PerfilAdocao entidade) throws ExceptionValidation {
		
		return dao.update(entidade);
	}

	@Override
	public PerfilAdocao find(long codigo) throws ExceptionValidation {
		
		return dao.find(codigo);
	}

	
}
