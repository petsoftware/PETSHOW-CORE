package br.com.petshow.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
	
	public  List<Animal> animaisPorDono(long idUsuario){
		SQLQuery query =super.getManager().unwrap(Session.class).createSQLQuery("select * from animal "	).addEntity(Animal.class) ;
				
			/*	pENDENCIA
				SQLQuery query =super.getManager().unwrap(Session.class).createSQLQuery("select {a.*} ,{t.*} from animal a"
						+ "	inner join tutor t on "
								+"t.id_animal=a.id"
						+	"where t.id_usuario=1"
						).addEntity("a",Animal.class).addJoin("t","a.tutores"); ;
						*/
		return query.list();
		
	}
	

}
