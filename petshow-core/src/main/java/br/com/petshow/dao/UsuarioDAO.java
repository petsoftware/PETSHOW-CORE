package br.com.petshow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Usuario;

/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class UsuarioDAO extends SuperClassDAO<Usuario> {

	public UsuarioDAO() {
	
	}
	

	@Override
	public Usuario find(long codigo) {
		
		return manager.find(Usuario.class, codigo);
	}
	// metodo usado somente para fazer o login favor não alterar
	public Usuario consultaPorNomeLogin(String nmLogin)  {
		
		return manager.createNamedQuery(Usuario.FIND_POR_NOME_LOGIN, Usuario.class).setParameter("nmLogin", nmLogin).getSingleResult();
	}
	public List<Usuario> consultaPorNomeOuAnimal(String nome)  {
		
		return manager.createNamedQuery(Usuario.FIND_POR_NOME_LOGIN).setParameter("nome", nome).getResultList();
		
	}
	
	public List<Usuario>  consultaPorNmLogin(String nmLogin)  {
		Criteria criteria =super.getManager().unwrap(Session.class).createCriteria(Usuario.class);
		
		criteria.add(Restrictions.eq("nmLogin", nmLogin));
		
		
		List<Usuario> list = criteria.list();
		
		return list;
		
	}
	
}
