package br.com.petmooby.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petmooby.model.Servico;
import br.com.petmooby.model.Usuario;
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
		return manager.createNamedQuery(Servico.SERVICO_POR_USUARIO,Servico.class).setParameter("idUsuario", idUsuario).getResultList();
	}
	public List<Servico> consultaPorNome(long idUsuario,String nmServico)  {
		return manager.createNamedQuery(Servico.NOME_DISPONIVEL,Servico.class).setParameter("idUsuario", idUsuario).setParameter("nmServico", nmServico).getResultList();
	}
	
	/**
	 * Obter o numero de Servicos cadastrados e ativos do usuario
	 * @param usuario
	 * @return
	 */
	public long numeroDeServicosAtivos(Usuario usuario) {
		return manager.createNamedQuery(Servico.COUNT_SERVICOS_ATIVOS, Long.class)
				.setParameter("usuario", usuario)
				.setParameter("flAtivo", true)
				.getSingleResult();
	}
	
}
