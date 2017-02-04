package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.UsuarioDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Tutor;
import br.com.petshow.model.Usuario;
import br.com.petshow.model.Venda;
import br.com.petshow.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class UsuarioRole extends SuperClassRole<Usuario> {

	@Autowired
	private UsuarioDAO usuarioDAO ;

	public Usuario insertPreCadastro(Usuario entidade) throws ExceptionValidation{
		
		

		if(!ValidationUtil.isCampoComValor(entidade.getNome())){
			throw new ExceptionValidation("O campo de nome não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getPassword())){
			throw new ExceptionValidation("O campo de senha não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getEmail())){
			throw new ExceptionValidation("O campo de e-mail não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getCnpjCpf())){
			throw new ExceptionValidation("O campo de CNPJ não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getNmLogin())){
			throw new ExceptionValidation("O campo de nome de login não foi informado!");
		}
	

		List<Usuario> usuarios=consultaPorNmLogin(entidade.getNmLogin());
		if(usuarios !=null && usuarios.size()>0){
			throw new ExceptionValidation("Nome de usuário já existe favor informar um diferente!");
		}
		

		return (Usuario) this.usuarioDAO.insert(entidade);
	}
	
	public Usuario insert(Usuario entidade) throws ExceptionValidation{
		
		return (Usuario) this.usuarioDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.usuarioDAO.delete(codigo);
	}

	
	public Usuario update(Usuario entidade) throws ExceptionValidation{
		Usuario existente =null;
		if(entidade.getFoto() == null || entidade.getFoto().trim().equals("")){
			existente =  find(entidade.getId());
			
			if(existente.getFoto() == null || existente.getFoto().trim().equals("")){
				throw new ExceptionValidation("O campo de foto do perfil não foi informado!");
			}else{
				entidade.setFoto(existente.getFoto());
			}
		}
		// verificar como irá ficar o tipo de usuario
		
		return (Usuario) this.usuarioDAO.update(entidade);
	}

	
	public Usuario find(long codigo) throws ExceptionValidation {
	
		return this.usuarioDAO.find(codigo);
	}

	public Usuario consultaPorNomeLogin(String nmLogin) {
		return this.usuarioDAO.consultaPorNomeLogin(nmLogin);
	}
	
	public List<Usuario> consultaPorNomeOuAnimal(String nome)  throws ExceptionValidation{
		return this.usuarioDAO.consultaPorNomeOuAnimal(nome);
	}
	/**
	 * Retorna o Usuario logado
	 * @return
	 */
	public static  Usuario  getUsuarioLogado(){
		
		try{
			return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Usuario>  consultaPorNmLogin(String nmLogin)  throws ExceptionValidation{
		return this.usuarioDAO.consultaPorNmLogin(nmLogin);
	}

	public List<Usuario> listaClientes(long id)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.usuarioDAO.listaClientes(id);
	}
	public List<Usuario> listaClientesAutoComplete(long id,String parteNome)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.usuarioDAO.listaClientesAutoComplete(id,parteNome);
	}
}
