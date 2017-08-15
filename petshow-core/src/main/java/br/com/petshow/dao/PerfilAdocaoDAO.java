package br.com.petshow.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.PerfilAdocao;
import br.com.petshow.model.Usuario;
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
