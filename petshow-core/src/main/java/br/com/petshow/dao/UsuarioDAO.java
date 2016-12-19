package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

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
	
	public Usuario consultaPorNomeLogin(String nmLogin)  {
		
		return manager.createNamedQuery(Usuario.FIND_POR_NOME_LOGIN, Usuario.class).setParameter("nmLogin", nmLogin).getSingleResult();
	}
	
	
}
