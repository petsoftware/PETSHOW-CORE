package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.AcessoDAO;
import br.com.petshow.enums.EnumRoles;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Acesso;

@Service
@Transactional
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
	
	public List<Acesso> findAll() {
		return acessoDAO.findAll();
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
	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.SUPPORTS)
	public void load() {
		System.out.println("Carregando as Roles para o Spring Security");
		List<Acesso> list = acessoDAO.findAll();
		if(list != null && list.size() == 0){
			for (EnumRoles role : EnumRoles.values()) {
				acessoDAO.insert(new Acesso(role.getValue()));
			}
		}
	}

}
