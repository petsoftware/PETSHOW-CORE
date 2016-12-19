package br.com.petshow.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.UsuarioDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Tutor;
import br.com.petshow.model.Usuario;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class UsuarioRole extends SuperClassRole<Usuario> {

	@Autowired
	private UsuarioDAO usuarioDAO ;

	public Usuario insert(Usuario entidade) throws ExceptionValidation{
		
		return (Usuario) this.usuarioDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.usuarioDAO.delete(codigo);
	}

	
	public Usuario update(Usuario entidade) throws ExceptionValidation{
	
		return (Usuario) this.usuarioDAO.update(entidade);
	}

	
	public Usuario find(long codigo) throws ExceptionValidation {
	
		return this.usuarioDAO.find(codigo);
	}

	public Usuario consultaPorNomeLogin(String nmLogin) {
		return this.usuarioDAO.consultaPorNomeLogin(nmLogin);
	}
	/**
	 * Retorna o Usuario logado
	 * @return
	 */
	public static  Usuario  getUsuarioLogado(){

		return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	
}
