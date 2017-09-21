package br.com.petmooby.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Evento;

@Repository
public class EventoDAO extends SuperClassDAO<Evento> {

	public EventoDAO() {
		//System.out.println("TODO Auto-generated constructor stub " + EventoDAO.class.getName());
	}
	
	
	@Override
	public Evento find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Evento.class, codigo);
	}
	
	public List<Evento> findAll() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> qry = builder.createQuery(Evento.class);
		qry = qry.select(qry.from(Evento.class));
		TypedQuery<Evento> tpQry = manager.createQuery(qry);
		return tpQry.getResultList();
	}

}
