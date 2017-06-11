package br.com.petshow.role;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.NotificacaoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Notificacao;
import br.com.petshow.util.ValidationUtil;

@Service
@Transactional
public class NotificacaoRole extends SuperClassRole<Notificacao> {

	
	@Autowired
	private NotificacaoDAO dao;
	
	@Override
	public Notificacao insert(Notificacao entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return this.dao.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.dao.delete(codigo);
		
	}

	@Override
	public Notificacao update(Notificacao entidade) throws ExceptionValidation {
		return this.dao.update(entidade);
	}

	@Override
	public Notificacao find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.dao.find(codigo);
	}
	
	public List<Notificacao> consultaPorUsuario(long idUsuario)  throws ExceptionValidation{
		return this.dao.consultaPorUsuario(idUsuario);
	}
	
	

}
