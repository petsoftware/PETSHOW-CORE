package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Adocao;
import br.com.petshow.model.Perdido;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class PerdidoDAO extends SuperClassDAO<Perdido> {

	public PerdidoDAO() {

	}

	
	public Perdido find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Perdido.class, codigo);
	}
	public List<Perdido> consultaPorFiltros(String tpAnimal,String tpPerdidoAchado,long estado,long cidade,long bairro,int limiteRegistros)  {

	
		String consulta ="select perdido.* from perdido ";
			
		ArrayList<HashMap<String,Object>> filtros = new ArrayList<HashMap<String,Object>>(); 
		String where = " where 1=1 ";
		
		if(!tpAnimal.trim().equals("null")){
			where+= " and tp_animal=:tpAnimal ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "tpAnimal");
		 	map.put("valor",tpAnimal);
			filtros.add(map);
		}
		
		if(!tpPerdidoAchado.trim().equals("null")){
			where+= " and FL_ACONTECIMENTO=:flAcontecimento ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "flAcontecimento");
		 	map.put("valor",tpPerdidoAchado);
			filtros.add(map);
		}
		
		
		if(cidade>0){
			where+= " and id_cidade =:idCidade ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idCidade");
		 	map.put("valor",new Long(cidade));
			filtros.add(map);
		
		}
		
		if(estado>0){
			where+= " and id_estado =:idEstado ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idEstado");
		 	map.put("valor",new Long(estado));
			filtros.add(map);
			//innerUsuario=true;
		}
		
		if(bairro>0){
			where+= " and id_estado =:idEstado ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idEstado");
		 	map.put("valor",new Long(estado));
			filtros.add(map);
			//innerUsuario=true;
		}
		
		
		
		consulta += (where.equals(" where 1=1 ")?"":where)+ " order by DT_CADASTRO desc limit "+limiteRegistros;
		Query query = manager.createNativeQuery(consulta, Perdido.class);
		
		
		for(HashMap<String,Object> item :filtros){
			query.setParameter(item.get("chave").toString(), item.get("valor"));
		}
		
		List<Perdido> retorno = (List<Perdido>) query.getResultList();
		
		
		return retorno;

	}
	
	public int getCount() {
		Query qry = manager.createNamedQuery(Perdido.QRY_COUNT);
		qry.getSingleResult();
		return 0;
	}
	
	public List<Perdido> consultaPorUsuario(Long id)  {

		return manager.createNamedQuery(Perdido.FIND_POR_USUARIO).setParameter("id", id).getResultList();

	}
	
}
