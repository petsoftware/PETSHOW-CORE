package br.com.petshow.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.petshow.model.Amigo;
import br.com.petshow.model.Usuario;

public class AmigoDAO extends SuperClassDAO<Amigo> {

	@Override
	public Amigo find(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> listaAmigos(long idUsuario)  {
		String consulta ="	"
				+ "select usuario.nm_usuario u_nome, usuario.id u_id, usuario.foto_perfil u_foto,animal.foto_perfil a_foto,animal.tp_animal a_tp from amigo "
					+" inner join usuario on"
						+" usuario.id=amigo.id_amigo"
					+" inner join tutor on "
						+"	tutor.id_usuario=usuario.id "
					+" inner join animal on "
						+"	animal.id=tutor.id_animal"
					+" where "
					+ "   amigo.id_usuario=:idUsuario"
					+" order by usuario.nm_usuario asc ";
		
		Query query = manager.createNativeQuery(consulta);
		
		query.setParameter("idUsuario", idUsuario);
				
		List<Object[]> list = query.getResultList();
		
		return list;

	}
	
	public Amigo findAmigo(long idUsuario,long idAmigo)  {
		Amigo amigo= null;
		try{
			amigo = manager.createNamedQuery(Amigo.FIND_FRIEND, Amigo.class).setParameter("usuario", idUsuario).setParameter("amigo", idAmigo).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return amigo; 
	}
}
