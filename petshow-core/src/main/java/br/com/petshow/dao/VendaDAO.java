package br.com.petshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Venda;
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

	public List<Venda> vendas(String palavraChave,long idCidade,long idEstado)  {
		
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
		consulta += (where.equals("where 1=1")?"":where)+ " order by dt_cadastro desc";
		Query query = manager.createNativeQuery(consulta, Venda.class);
		
		
		for(HashMap<String,Object> item :filtros){
			query.setParameter(item.get("chave").toString(), item.get("valor"));
		}
		
		List<Venda> retorno = (List<Venda>) query.getResultList();
		
		
		return retorno;
		
//
//		Criteria criteria =super.getManager().unwrap(Session.class).createCriteria(Venda.class);
//		
//		if(palavraChave!=null && !palavraChave.trim().equals("")){
//			criteria.add(Restrictions.like("descResumida", "%"+palavraChave+"%"));
//		}
//		if(idCidade>0){
//			criteria.add(Restrictions.eq("id_cidade", idCidade));
//		}
//		if(idEstado>0){
//			criteria.add(Restrictions.eq("id_estado", idEstado));
//		}
//		
//		
//		
//		List<Venda> list = criteria.list();
//		
//		return list;
		//return manager.createNamedQuery(Venda.VENDA_POR_FILTRO).setParameter("palavraChave", "%"+palavraChave+"%").setParameter("idCidade", idCidade).setParameter("idEstado", idEstado).getResultList();
		//return manager.createNamedQuery(Venda.VENDA_POR_FILTRO).setParameter("palavrahave", palavraChave).setParameter("idCidade", idCidade).getResultList();
	}

}
