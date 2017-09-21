package br.com.petmooby.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Desaparecidos;

@Repository
public class DesaparecidosDAO extends SuperClassDAO<Desaparecidos> {

	public DesaparecidosDAO() {
		
	}
	
	@Override
	public Desaparecidos find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Desaparecidos.class, codigo);
	}
	
	public List<Desaparecidos> findAll() {
		return manager.createNamedQuery(Desaparecidos.FIND_ALL).getResultList();
	}

}
