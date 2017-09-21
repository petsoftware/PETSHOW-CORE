package br.com.petshow.dao;


import java.util.List;

import br.com.petshow.model.Notificacao;


public class NotificacaoDAO extends SuperClassDAO<Notificacao> {
	@Override
	public Notificacao find(long codigo){
		
		return manager.find(Notificacao.class, codigo);
	}
	
	public List<Notificacao> consultaPorUsuario(long usuarioID)  {

		return manager.createNamedQuery(Notificacao.IDX_POR_USUARIO).setParameter("idUsuario", usuarioID).getResultList();

	}
}
