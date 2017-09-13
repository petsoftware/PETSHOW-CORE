package br.com.petmooby.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Vacina;

@Repository
public class VacinaDAO extends SuperClassDAO<Vacina>{

	@Override
	public Vacina find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Vacina.class, codigo);
	}
	
	public List<Vacina> consultaPorAnimal(long idAnimal)  {
		
		return manager.createNamedQuery(Vacina.FIND_POR_ANIMAL).setParameter("idAnimal", idAnimal).getResultList();
	}

}
