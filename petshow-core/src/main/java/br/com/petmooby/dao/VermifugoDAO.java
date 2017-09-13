package br.com.petmooby.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Amigo;
import br.com.petmooby.model.Vacina;
import br.com.petmooby.model.Vermifugo;

@Repository
public class VermifugoDAO extends SuperClassDAO<Vermifugo>{

	@Override
	public Vermifugo find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Vermifugo.class, codigo);
	}
	
	public Vermifugo consultaPorAnimal(long idAnimal)  {
		Vermifugo ver= null;
		try{
			ver =(Vermifugo) manager.createNamedQuery(Vermifugo.FIND_POR_ANIMAL).setParameter("idAnimal", idAnimal).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return ver;
	}

}
