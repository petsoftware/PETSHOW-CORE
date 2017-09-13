package br.com.petmooby.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.PerfilAdocao;
import br.com.petmooby.model.Usuario;
@Repository
public class PerfilAdocaoDAO extends SuperClassDAO<PerfilAdocao> {

	public PerfilAdocaoDAO() {
		
	}

	@Override
	public PerfilAdocao find(long codigo) {
		return super.find(PerfilAdocao.class, codigo);
	}
	
	public PerfilAdocao findPerfilByUser(Usuario usuario) {
		TypedQuery<PerfilAdocao> qry = manager.createNamedQuery(PerfilAdocao.FIND_BY_USER, PerfilAdocao.class)
				.setParameter("usuario", usuario);
		return qry.getSingleResult();
	}

}
