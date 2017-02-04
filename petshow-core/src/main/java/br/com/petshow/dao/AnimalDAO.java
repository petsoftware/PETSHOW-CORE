package br.com.petshow.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.petshow.model.Animal;
import br.com.petshow.model.Venda;
@Repository
public class AnimalDAO extends SuperClassDAO<Animal> {

	public AnimalDAO() {
	
	}

	

	public Animal find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Animal.class, codigo);
	}
	
	public  List<Animal> animaisPorDono(long idUsuario){
		
		String consulta="select animal.* from animal"
				+ " inner join tutor on"
				+ "		animal.id= tutor.id_animal"
				+ " where tutor.id_usuario=:usuarioID";
		Query query = manager.createNativeQuery(consulta, Animal.class);
		
		query.setParameter("usuarioID",idUsuario);
		
		
		List<Animal> retorno = (List<Animal>) query.getResultList();
		
		return retorno;
	
	}
	

}
