package br.com.petshow.dao;

import javax.persistence.Query;

import br.com.petshow.model.Acesso;
import br.com.tafera.enums.EnumRoles;

public class AcessoDAO extends SuperClassDAO<Acesso> {

	public AcessoDAO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Acesso find(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Acesso findAcesso(EnumRoles roles) {
		Query qry = getManager().createNamedQuery(Acesso.FIND_ACESSO).setParameter(Acesso.PARAM_NM_ACESSO, roles.getValue());
		return (Acesso) qry.getSingleResult();
	}

}
