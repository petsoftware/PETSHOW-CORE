package br.com.petshow.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer;
import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Usuario;

@Repository
public class AnuncioDAO extends SuperClassDAO<Anuncio> {

	public AnuncioDAO() {
	
	}

	@Override
	public Anuncio find(long codigo)  {
		return manager.find(Anuncio.class, codigo);
	}
	
	public List<Anuncio> consultaPorUsuario(long idUsuario)  {
		return manager.createNamedQuery(Anuncio.ANUNCIO_POR_USUARIO).setParameter("idUsuario", idUsuario).getResultList();
	}
	
	public long countAnunciosAtivos(Usuario usuario) {
		TypedQuery<Long> qry = manager.createNamedQuery(Anuncio.COUNT_ANUNCIO_USUARIO,Long.class)
				.setParameter("usuario", usuario)
				.setParameter("ativo", true);
		return qry.getSingleResult();
	}

}
