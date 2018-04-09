package br.com.petshow.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Parametros;


@Repository
public class DAOParametros extends SuperClassDAO<Parametros> {

	public DAOParametros() {
	}
	@Override
	public Parametros find(long codigo) {
		return getManager().find(Parametros.class, codigo);
	}

	public Parametros getParametroByChave(int chave) {
		TypedQuery<Parametros> query = getManager().createNamedQuery(Parametros.FIND_BY_CHAVE, Parametros.class);
		query.setParameter("chave", chave);
		try {
			return query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
