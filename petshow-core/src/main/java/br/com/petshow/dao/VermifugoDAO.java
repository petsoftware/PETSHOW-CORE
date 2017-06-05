package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Vacina;
import br.com.petshow.model.Vermifugo;

@Repository
public class VermifugoDAO extends SuperClassDAO<Vermifugo>{

	@Override
	public Vermifugo find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Vermifugo.class, codigo);
	}
	
	public List<Vermifugo> consultaPorAnimal(long idAnimal)  {
		
		return manager.createNamedQuery(Vermifugo.FIND_POR_ANIMAL).setParameter("idAnimal", idAnimal).getResultList();
	}

}
