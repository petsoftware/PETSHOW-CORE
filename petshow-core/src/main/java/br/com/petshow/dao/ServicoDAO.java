package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Servico;
/**
 * 
 * @author antoniorafael
 *
 */
@Repository
public class ServicoDAO extends SuperClassDAO<Servico> {

	public ServicoDAO() {

	}

	public Servico find(long codigo){

		return manager.find(Servico.class, codigo);
	}

	public List<Servico> consultaPorUsuario(long idUsuario)  {

		return manager.createNamedQuery(Servico.SERVICO_POR_USUARIO).setParameter("idUsuario", idUsuario).getResultList();
	}
	public List<Servico> consultaPorNome(long idUsuario,String nmServico)  {

		return manager.createNamedQuery(Servico.NOME_DISPONIVEL).setParameter("idUsuario", idUsuario).setParameter("nmServico", nmServico).getResultList();
	}
}
