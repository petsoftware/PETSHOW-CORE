package br.com.petshow.dao;

import java.util.List;

import javax.persistence.TypedQuery;
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
import br.com.petshow.model.PerfilAdocao;
import br.com.petshow.model.Usuario;
@Repository
public class PerfilAdocaoDAO extends SuperClassDAO<PerfilAdocao> {

	public PerfilAdocaoDAO() {
		
	}

	@Override
	public PerfilAdocao find(long codigo) {
		return super.find(PerfilAdocao.class, codigo);
	}
	
	public PerfilAdocao findPerfilByUser(Usuario usuario) {
		TypedQuery<PerfilAdocao> qry = manager.createNamedQuery(PerfilAdocao.FIND_BY_USER, PerfilAdocao.class)
				.setParameter("usuario", usuario);
		return qry.getSingleResult();
	}
	
	public List<Adocao> findAdocoesByPerfil(PerfilAdocao perfilAdocao) {
		CriteriaBuilder builder = getManager().getCriteriaBuilder();
		CriteriaQuery<Adocao> criteria = builder.createQuery(Adocao.class);
		Root<Adocao> root = criteria.from(Adocao.class);

		Path<EnumTipoAnimal> pTipoAnimal = root.get("tipo"); 
		Path<EnumSexo> pSexoAnimal 		 = root.get("flSexo"); 
		Path<EnumFaseVida> pFaseVida 	 = root.get("fase"); 
		Path<EnumUF> pUf 				 = root.get("endereco").get("uf"); 
		Path<Cidade> pCidade 			 = root.get("endereco").get("cidade"); 
		
		Predicate predicate = builder.conjunction();
		
		if(perfilAdocao.getTipoAnimal() != null){
			predicate = builder.and(predicate,builder.equal(pTipoAnimal, perfilAdocao.getTipoAnimal()));
		}
		if(perfilAdocao.getSexo() != null){
			predicate = builder.and(predicate,builder.equal(pSexoAnimal, perfilAdocao.getSexo()));
		}
		if(perfilAdocao.getUf() != null){
			predicate = builder.and(predicate,builder.equal(pUf, perfilAdocao.getUf()));
		}
		if(perfilAdocao.getCidade() != null){
			predicate = builder.and(predicate,builder.equal(pCidade, perfilAdocao.getCidade()));
		}
		if(perfilAdocao.getFaseVida() != null){
			predicate = builder.and(predicate,builder.equal(pFaseVida, perfilAdocao.getFaseVida()));
		}
		
		criteria.where(predicate);
		criteria.select(root);
		return getManager().createQuery(criteria).setMaxResults(30).getResultList();
	}
	/**
	 * Tras o numero de animais que estão no perfil de adoção do usuário.
	 * @param idUsuario
	 * @return
	 */
	public long countAdocoesNoPerfil(Usuario idUsuario) {
		return getManager().createNamedQuery(PerfilAdocao.COUNT_BY_USER, Long.class)
				.setParameter("usuario", idUsuario)
				.getSingleResult();
	}

}
