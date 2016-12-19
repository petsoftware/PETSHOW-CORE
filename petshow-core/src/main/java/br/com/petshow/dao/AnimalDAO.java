package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Animal;
@Repository
public class AnimalDAO extends SuperClassDAO<Animal> {

	public AnimalDAO() {
	
	}

	

	public Animal find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Animal.class, codigo);
	}
	

}
