package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Adocao;
import br.com.petshow.model.Venda;

@Repository
public class AdocaoDAO extends SuperClassDAO<Adocao> {

	public AdocaoDAO() {
		
	}

	@Override
	public Adocao find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Adocao.class, codigo);
	}

	public List<Adocao> consultaAnimaisAdocao(long estado, long cidade, String tpAnimal, String fase, String sexo, int limiteRegistros) {
		String consulta ="select adocao.* from adocao "
				+ "inner join tutor on    adocao.id_tutor = tutor.id"
				+ "	inner join animal on 	animal.id= tutor.id_animal " ;
		ArrayList<HashMap<String,Object>> filtros = new ArrayList<HashMap<String,Object>>(); 
		String where = " where 1=1 ";
		boolean innerUsuario= false;
/*		select * from adocao
	    inner join tutor on    adocao.id_tutor = tutor.id
	    inner join animal on 	animal.id= tutor.id_animal
	    inner join usuario on usuario.id= tutor.id_usuario*/
		
		
		if(!tpAnimal.trim().equals("null")){
			where+= " and animal.tp_animal=:tpAnimal ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "tpAnimal");
		 	map.put("valor",tpAnimal);
			filtros.add(map);
		}
		if(!fase.trim().equals("null")){
			where+= " and adocao.fase=:fase ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "fase");
		 	map.put("valor",fase);
			filtros.add(map);
		}
		if(!sexo.trim().equals("null")){
			where+= " and animal.fl_sexo=:flSexo ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "flSexo");
		 	map.put("valor",sexo);
			filtros.add(map);
		}
		
		if(cidade>0){
			where+= " and adocao.id_cidade =:idCidade ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idCidade");
		 	map.put("valor",new Long(cidade));
			filtros.add(map);
			innerUsuario=true;
		}
		
		if(estado>0){
			where+= " and adocao.id_estado =:idEstado ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idEstado");
		 	map.put("valor",new Long(estado));
			filtros.add(map);
			//innerUsuario=true;
		}
		
		if(innerUsuario){
			consulta+=" inner join usuario on usuario.id= tutor.id_usuario";
		}
		
		
		consulta += (where.equals(" where 1=1 ")?"":where)+ " order by dt_adocao desc limit "+limiteRegistros;
		Query query = manager.createNativeQuery(consulta, Adocao.class);
		
		
		for(HashMap<String,Object> item :filtros){
			query.setParameter(item.get("chave").toString(), item.get("valor"));
		}
		
		List<Adocao> retorno = (List<Adocao>) query.getResultList();
		
		
		return retorno;
	}

}
