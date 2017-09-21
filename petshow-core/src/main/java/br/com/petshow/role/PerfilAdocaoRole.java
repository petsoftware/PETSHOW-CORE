package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.PerfilAdocaoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.PerfilAdocao;
import br.com.petmooby.model.Usuario;

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
	
	public PerfilAdocao findPerfilByUser(Usuario usuario) {
		return dao.findPerfilByUser(usuario);
	}

	
}
