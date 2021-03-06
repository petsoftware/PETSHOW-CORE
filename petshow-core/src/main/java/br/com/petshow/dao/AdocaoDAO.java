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

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Adocao;
import br.com.petshow.model.Cidade;
import br.com.petshow.objects.query.AdocaoQuery;

@Repository
public class AdocaoDAO extends SuperClassDAO<Adocao> {

	public AdocaoDAO() {
		
	}

	@Override
	public Adocao find(long codigo) {
		return manager.find(Adocao.class, codigo);
	}

	public List<Adocao> consultaAnimaisAdocao(long estado, long cidade, String tpAnimal, String fase, String sexo, int limiteRegistros) {
		String consulta ="select adocao.* from adocao "
				+ "inner join tutor on    adocao.id_tutor = tutor.id"
				+ "	inner join animal on 	animal.id= tutor.id_animal " ;
		ArrayList<HashMap<String,Object>> filtros = new ArrayList<HashMap<String,Object>>(); 
		String where = " where 1=1 ";
		boolean innerUsuario= false;
		
		
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
		List<Adocao> retorno =  query.getResultList();
		return retorno;
	}

	public List<Adocao> consultaPorUsuario(Long id)  {
		return manager.createNamedQuery(Adocao.FIND_POR_USUARIO,Adocao.class).setParameter("id", id).getResultList();
	}
	/**
	 * R
	 * @param estado
	 * @param cidade
	 * @param tpAnimal
	 * @param fase
	 * @param sexo
	 * @param limiteRegistros
	 * @return lista com as adoções disponiveis
	 * @author Rafael ROcha
	 */
	public List<Adocao> consultarAnimaisDisponíveisParaAdocao(AdocaoQuery query) {
		CriteriaBuilder builder = getManager().getCriteriaBuilder();
		CriteriaQuery<Adocao> criteria = builder.createQuery(Adocao.class);
		Root<Adocao> root = criteria.from(Adocao.class);

		Path<EnumTipoAnimal> pTipoAnimal = root.get("tipo"); 
		Path<EnumSexo> pSexoAnimal 		 = root.get("flSexo"); 
		Path<EnumFaseVida> pFaseVida 	 = root.get("fase"); 
		Path<EnumUF> pUf 				 = root.get("endereco").get("uf"); 
		Path<Cidade> pCidade 			 = root.get("endereco").get("cidade"); 
		
		Predicate predicate = builder.conjunction();
		
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
		if(query.getFase() != null){
			predicate = builder.and(predicate,builder.equal(pFaseVida, query.getFase()));
		}
		
		criteria.where(predicate);
		criteria.select(root);
		return getManager().createQuery(criteria).setMaxResults(30).getResultList();
		
	}

}
