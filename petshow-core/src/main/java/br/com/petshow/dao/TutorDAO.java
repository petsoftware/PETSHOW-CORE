package br.com.petshow.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Tutor;
import br.com.petshow.model.Usuario;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class TutorDAO extends SuperClassDAO<Tutor> {

	public TutorDAO() {
		 
	}
	
		@Override
	public Tutor find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Tutor.class, codigo);
	}
		
	public Tutor findByUser(Usuario usuario) {
		TypedQuery<Tutor> qry = getManager().createNamedQuery(Tutor.FIND_BY_USER, Tutor.class).setParameter("usuario", usuario);
		return qry.getSingleResult();
	}

}
