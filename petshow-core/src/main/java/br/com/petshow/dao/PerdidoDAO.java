package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import br.com.petshow.enums.EnumAchadoPerdido;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Cidade;
import br.com.petshow.model.Perdido;
import br.com.petshow.objects.query.PerdidoQuery;
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
	public List<Perdido> consultaPorFiltros(String tpAnimal,EnumAchadoPerdido tpPerdidoAchado,long estado,long cidade,long bairro,int limiteRegistros)  {

	
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
		
		if(!tpPerdidoAchado.equals(null)){
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

		consulta += (where.equals(" where 1=1 ")?"":where)+ " order by DT_CADASTRO desc ";
		Query query = manager.createNativeQuery(consulta, Perdido.class).setMaxResults(limiteRegistros);
		
		for(HashMap<String,Object> item :filtros){
			query.setParameter(item.get("chave").toString(), item.get("valor"));
		}
		
		List<Perdido> retorno = query.getResultList();
				
		return retorno;

	}
	
	public int getCount() {
		Query qry = manager.createNamedQuery(Perdido.QRY_COUNT);
		qry.getSingleResult();
		return 0;
	}
	
	public List<Perdido> consultaPorUsuario(Long id)  {

		return manager.createNamedQuery(Perdido.FIND_POR_USUARIO,Perdido.class).setParameter("id", id).getResultList();

	}
	
	public List<Perdido> getEncontradosPorUsuario(Long id)  {
		return manager.createNamedQuery(Perdido.FIND_ENCONTRADO_POR_USUARIO,Perdido.class)
				.setParameter("id", id)
				.setParameter("flAcontecimento", EnumAchadoPerdido.ACHADO).getResultList();
	}
	/**
	 * Consulta animais achado e perdidos
	 * @author Rafael Rocha
	 * @return
	 */
	public List<Perdido> consultaAnimaisAchadosEPerdidos(PerdidoQuery query)  {
		CriteriaBuilder builder = getManager().getCriteriaBuilder();
		CriteriaQuery<Perdido> criteria = builder.createQuery(Perdido.class);
		Root<Perdido> root = criteria.from(Perdido.class);
		Path<EnumTipoAnimal> pTipoAnimal = root.get("tpAnimal");
		Path<EnumSexo> pSexoAnimal 		 = root.get("flSexo");
		Path<EnumUF> pUf 				 = root.get("endereco").get("uf");
		Path<Cidade> pCidade 			 = root.get("endereco").get("cidade");
		Path<EnumAchadoPerdido> perdido	 = root.get("flAcontecimento");
		Predicate predicate = builder.conjunction();
		predicate = builder.and(predicate,builder.equal(perdido, query.getAchadoPerdido()));
		if(query.getTpAnimal() != null){
			predicate = builder.and(predicate,builder.equal(pTipoAnimal, query.getTpAnimal()));
		}
		if(query.getSexo() != null){
			predicate = builder.and(predicate,builder.equal(pSexoAnimal, query.getSexo()));
		}
		if(query.getUf() != null){
			predicate = builder.and(predicate,builder.equal(pUf, query.getUf()));
		}
		if(query.getCidade() != null){
			predicate = builder.and(predicate,builder.equal(pCidade, query.getCidade()));
		}
	
		criteria.where(predicate);
		criteria.select(root);
		return getManager().createQuery(criteria).setMaxResults(30).getResultList();	

	}
	
}
