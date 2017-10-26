package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.petshow.enums.EnumCategoria;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Cidade;
import br.com.petshow.model.Usuario;
import br.com.petshow.model.Venda;
import br.com.petshow.objects.query.VendasQuery;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class VendaDAO extends SuperClassDAO<Venda> {

	public VendaDAO() {

	}

	@Override
	public Venda find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Venda.class, codigo);
	}

	public List<Venda> consultaPorUsuario(long idUsuario)  {
		return manager.createNamedQuery(Venda.VENDA_POR_USUARIO).setParameter("idUsuario", idUsuario).getResultList();
	}

	public List<Venda> vendas(String palavraChave,long idCidade,long idEstado,int limiteRegistros)  {
		
		String consulta ="select * from venda ";
		ArrayList<HashMap<String,Object>> filtros = new ArrayList<HashMap<String,Object>>(); 
		String where = "where 1=1";
		
		if(!palavraChave.trim().equals("")){
			where+= " and descricao_resumida like :palavraChave ";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "palavraChave");
		 	map.put("valor","%"+palavraChave+"%");
			filtros.add(map);
		}
		
		if(idCidade>0){
			where+= " and id_cidade =:idCidade";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idCidade");
		 	map.put("valor",new Long(idCidade));
			filtros.add(map);
		}
		
		if(idEstado>0){
			where+= " and id_estado =:idEstado";
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("chave", "idEstado");
		 	map.put("valor",new Long(idEstado));
			filtros.add(map);
		}
		consulta += (where.equals("where 1=1")?"":where)+ " order by dt_cadastro desc limit "+limiteRegistros;
		Query query = manager.createNativeQuery(consulta, Venda.class);
		
		
		for(HashMap<String,Object> item :filtros){
			query.setParameter(item.get("chave").toString(), item.get("valor"));
		}
		
		List<Venda> retorno = (List<Venda>) query.getResultList();
		return retorno;
		
	}
	
	public long numeroDeVendasRegistradoNoSistema(Usuario usuario) {
		TypedQuery<Long> qry = manager.createNamedQuery(Venda.COUNT_VENDAS, Long.class)
				.setParameter("usuario", usuario);
		return qry.getSingleResult();
	}
	
	public List<Venda> consultarVendas(VendasQuery query) {
		CriteriaBuilder builder 		 = getManager().getCriteriaBuilder();
		CriteriaQuery<Venda> criteria 	 = builder.createQuery(Venda.class);
		Root<Venda> root 				 = criteria.from(Venda.class);
		Path<EnumCategoria> pCategoria   = root.get("categoria");  
		Path<String> pDescResumida   	 = root.get("descResumida");
		Path<EnumUF> pUf 				 = root.get("endereco").get("uf"); 
		Path<Cidade> pCidade 			 = root.get("endereco").get("cidade");
		
		Predicate predicate 			 = builder.conjunction();
		if(query.getCategoria() != null){
			predicate = builder.and(predicate,builder.equal(pCategoria, query.getCategoria()));
		}
		if(query.getUf() != null){
			predicate = builder.and(predicate,builder.equal(pUf, query.getUf()));
		}
		if(query.getCidade() != null){
			predicate = builder.and(predicate,builder.equal(pCidade, query.getCidade()));
		}
		if(query.getDescResumida() != null && !query.getDescResumida().trim().isEmpty()){
			predicate = builder.and(predicate,builder.like(pDescResumida, query.getDescResumida()));
		}
		
		criteria.where(predicate);
		criteria.select(root);
		return getManager().createQuery(criteria).setMaxResults(30).getResultList();
		
	}

}
