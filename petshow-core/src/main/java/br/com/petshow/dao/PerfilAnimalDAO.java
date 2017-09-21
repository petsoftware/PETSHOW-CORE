package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.PerfilAnimal;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class PerfilAnimalDAO extends SuperClassDAO<PerfilAnimal> {

	public PerfilAnimalDAO() {
	
	}
	
	@Override
	public PerfilAnimal find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(PerfilAnimal.class, codigo);
	}

}
