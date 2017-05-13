package br.com.petshow.util;

import br.com.barcadero.commons.security.HandleEncrypt;
import br.com.petshow.model.SecurityLogin;
import br.com.petshow.model.Usuario;

/**
 * Classe para validar e gerar o chave(Key)
 * @author Rafael Rocha
 * @since version 1.0 - 12/05/2017
 */
public class KeyNewUserValidateUtil {
	
	public static final String KEY_SEPARATOR = "#%=";
	/**
	 * Validar a chave
	 * @param user
	 * @param securityLogin
	 * @param key
	 * @return
	 */
	public static boolean validate(Usuario user, SecurityLogin securityLogin, String key) {
		String email  = "";
		String userId = "";
		String id	  = "";
		String[] components = getKeyParts(key);
		if(components != null && components.length == 3 ){
			email = components[0];
			userId= components[1];
			id    = components[2];
			if(email.compareTo(user.getEmail().trim()) != 0){
				System.err.println("E-mail doesn't confer. Validate failed");
				System.err.println("EmailKey >> "+email+"|Email base>> "+user.getEmail().trim());
				return false;
			}else if(userId.compareTo(""+user.getId()) != 0){
				System.err.println("User ID doesn't confer. Validate failed");
				System.err.println("IDUserKey >> "+userId+"|ID User base>> "+user.getId());
				return false;
			}else if(id.compareTo(""+securityLogin.getId()) != 0){
				System.err.println("ID doesn't confer. Validate failed");
				System.err.println("ID  >> "+id+"|ID base>> "+securityLogin.getId());
				return false;
			}
			
		}else{
			return false;
		}
		return true;
	}
	
	public static String genarateKeyValue (SecurityLogin securityLogin ) {
		String cryptKey = HandleEncrypt.encrypt(securityLogin.getEmail()
				.concat(KEY_SEPARATOR)
				.concat(""+securityLogin.getUserId())
				.concat(KEY_SEPARATOR)
				.concat(""+securityLogin.getId()));
		return cryptKey;
	}
	/**
	 * 
	 * @param key
	 * @return String[] onde posicao [0] = email, [1] = user id e [2]
	 */
	public static String[] getKeyParts(String key) {
		String keyDecrypted = HandleEncrypt.decrypt(key);
		return keyDecrypted.split(KEY_SEPARATOR);
	}
	

}
