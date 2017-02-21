package br.com.petshow.role;

import javax.persistence.EntityManager;

import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;


/**
 * Classe para servir de modelo para os facades que presisao persistir dados
 * @author Rafel Rocha
 * @since version 1.0 Beta
 */

public abstract class SuperClassRole<T>{


	public abstract T insert(T entidade)  throws ExceptionValidation ;
	public abstract void delete(long codigo) throws ExceptionNotFoundRecord,ExceptionValidation  ;
	public abstract T update(T entidade)  throws ExceptionValidation ;
	public abstract T find(long codigo) throws ExceptionValidation  ;
	
	public SuperClassRole() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SuperClassRole(EntityManager manager) {
		
	}
	
	
}
