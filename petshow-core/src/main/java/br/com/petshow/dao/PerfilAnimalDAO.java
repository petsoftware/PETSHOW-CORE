package br.com.petmooby.dao;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.PerfilAnimal;
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
