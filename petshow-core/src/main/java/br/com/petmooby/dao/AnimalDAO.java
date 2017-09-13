package br.com.petmooby.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Animal;
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
