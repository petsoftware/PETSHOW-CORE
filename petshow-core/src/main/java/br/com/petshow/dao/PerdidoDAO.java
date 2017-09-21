package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
	/**
	 * @author Rafael Rocha
	 * @return
	 */
	public List<Perdido> consultaAnimaisPerdidos(PerdidoQuery query)  {
		CriteriaBuilder builder = getManager().getCriteriaBuilder();
		CriteriaQuery<Perdido> criteria = builder.createQuery(Perdido.class);
		Root<Perdido> root = criteria.from(Perdido.class);
		ParameterExpression<EnumTipoAnimal> pTipoAnimal = builder.parameter(EnumTipoAnimal.class,"tipo");
		ParameterExpression<EnumSexo> pSexoAnimal 		= builder.parameter(EnumSexo.class		,"sexo");
		ParameterExpression<EnumUF> pUf 				= builder.parameter(EnumUF.class		,"uf");
		ParameterExpression<Cidade> pCidade 			= builder.parameter(Cidade.class		,"cidade");
		//Building the select
		criteria.select(root).where(
				builder.and(
						builder.equal(root.get("tpAnimal")	, pTipoAnimal),
						builder.equal(root.get("flSexo"), pSexoAnimal),
						builder.equal(root.get("endereco").get("uf"), pUf),
						builder.equal(root.get("endereco").get("cidade"), pCidade)
				)
		);
		
		TypedQuery<Perdido> qry = getManager().createQuery(criteria).setMaxResults(query.getLimiteRegistros())
				.setParameter("tipo"  , query.getTpAnimal())
				.setParameter("sexo"  , query.getSexo())
				.setParameter("uf"	  , query.getUf())
				.setParameter("cidade", query.getCidade());
		return qry.getResultList();
	
	}
	
}
