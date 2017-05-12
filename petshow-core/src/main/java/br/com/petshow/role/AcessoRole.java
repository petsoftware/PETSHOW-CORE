package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AcessoDAO;
import br.com.petshow.enums.EnumRoles;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Acesso;

@Service
public class AcessoRole extends SuperClassRole<Acesso> {

	@Autowired
	private AcessoDAO acessoDAO;
	
	@Override
	public Acesso insert(Acesso entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return acessoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		// TODO Auto-generated method stub
		acessoDAO.delete(codigo);
	}

	@Override
	public Acesso update(Acesso entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return acessoDAO.update(entidade);
	}

	@Override
	public Acesso find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Acesso findAcesso(EnumRoles roles) {
		return acessoDAO.findAcesso(roles);
	}

	public AcessoDAO getAcessoDAO() {
		return acessoDAO;
	}

	public void setAcessoDAO(AcessoDAO acessoDAO) {
		this.acessoDAO = acessoDAO;
	}

}
