package br.com.petshow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;

@Repository
public class AnuncioDAO extends SuperClassDAO<Anuncio> {

	public AnuncioDAO() {
	
	}

	@Override
	public Anuncio find(long codigo)  {
		// TODO Auto-generated method stub
		return manager.find(Anuncio.class, codigo);
	}
	
	
	
	public List<Anuncio> consultaPorUsuario(long idUsuario)  {
		
		
		/*Criteria criteria =super.getManager().unwrap(Session.class).createCriteria(Anuncio.class);
			
		criteria.add(Restrictions.eq("id_usuario", idUsuario));
		
		
		List<Anuncio> list = criteria.list();
		
		return list;*/
		return manager.createNamedQuery(Anuncio.ANUNCIO_POR_USUARIO).setParameter("idUsuario", idUsuario).getResultList();
	}

}
