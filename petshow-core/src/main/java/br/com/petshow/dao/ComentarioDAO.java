package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Comentario;
/**
 * 
 * @author antoniorafael
 * @since versão 1.0 - dia 23/11/2016 as 09:40
 * Obs: Não implementar esta classe, somente para herança
 */
@Repository
public class ComentarioDAO extends SuperClassDAO<Comentario> {

	public ComentarioDAO() {
		
	}
	

	@Override
	public Comentario find(long codigo){
		// TODO Auto-generated method stub
		return null;
	}

}
