package br.com.petshow.role;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.constants.EmailConstants;
import br.com.petshow.dao.NotificacaoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Notificacao;
import br.com.petshow.model.SecurityLogin;
import br.com.petshow.model.Usuario;
import br.com.petshow.runnable.ThreadSendMail;
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
	
	public void sendEmailParaAnonimo(Usuario usuario, Notificacao notificacao) {
		Thread runEmail = new Thread(new ThreadSendMail(notificacao.getEmail(),EmailConstants.senderContato, getEmailContetAnonimo(notificacao),notificacao.getUsuarioDestinatario().getNome() + " respondeu."));
		runEmail.start();
	}
	

	public void sendEmailParaUsuarioCadastrado(Usuario usuario, Notificacao notificacao) {
		Thread runEmail = new Thread(new ThreadSendMail(notificacao.getUsuarioDestinatario().getEmail(),EmailConstants.senderContato, getEmailContetUsuarioCadastrado(notificacao),notificacao.getUsuarioDestinatario().getNome() + " respondeu."));
		runEmail.start();
	}
	
	public void avisarPorEmailUmaNotificacao(Notificacao notificacao) {
		Thread runEmail = new Thread(new ThreadSendMail(notificacao.getUsuarioDestinatario().getEmail(),
				EmailConstants.senderContato, 
				getEmailContetAviso(notificacao),
				"Você recebeu uma mensagem"));
		runEmail.start();
	}

	private String getEmailContetAviso(Notificacao notificacao) {
		StringBuilder content = new StringBuilder("");
		if(notificacao != null){
			content.append("Olá ").append(notificacao.getUsuarioDestinatario().getNome());
			content.append("\n").append("\n").append("\n").append("\n");
			content.append("Parece que alguém vio o seu anúncio").append("\n").append("\n");
			content.append("Mensagem:").append(notificacao.getMsgNotificacao()).append("\n").append("\n");
			content.append("\n").append("\n").append("\n");
			content.append("Muito obrigado por usar a plataforma").append("\n").append("\n");
			content.append("E quem mandou essa mensagem foi " + notificacao.getNome());
		}else{
			content.append("Ops!! Nos desculpe mas houve um erro grave: Não existe notificação pra ser enviada.");
		}
		return content.toString();
	}

	private String getEmailContetAnonimo(Notificacao notificacao) {
		StringBuilder content = new StringBuilder("");
		if(notificacao != null){
			content.append("Olá ").append(notificacao.getNome());
			content.append("\n").append("\n").append("\n").append("\n");
			content.append("Você recebeu uma mensagem").append("\n").append("\n");
			content.append("Mensagem:").append(notificacao.getMsgNotificacao()).append("\n").append("\n");
			content.append("\n").append("\n").append("\n");
			content.append("Muito obrigado por sua ajuda ").append(notificacao.getNome());
		}else{
			content.append("Ops!! Nos desculpe mas houve um erro grave: Não existe notificação pra ser enviada.");
		}
		return content.toString();
	}
	
	private String getEmailContetUsuarioCadastrado(Notificacao notificacaoDeResposta) {
		StringBuilder content = new StringBuilder("");
		if(notificacaoDeResposta != null){
			content.append("Olá ").append(notificacaoDeResposta.getUsuarioDestinatario().getNome());
			content.append("\n").append("\n").append("\n").append("\n");
			content.append("Você recebeu uma mensagem em resposata!").append("\n").append("\n");
			content.append("Você disse: ").append(notificacaoDeResposta.getMensagemRespondida()).append("\n").append("\n");
			content.append("E ").append(notificacaoDeResposta.getUsuarioDestinatario().getNome()).append(" respondeu:");
			content.append(notificacaoDeResposta.getResposta());
			content.append("\n").append("\n").append("\n");
			content.append("Muito obrigado por sua ajuda ").append(notificacaoDeResposta.getUsuarioDestinatario().getNome());
		}else{
			content.append("Ops!! Nos desculpe mas houve um erro grave: Não existe notificação pra ser enviada.");
		}
		return content.toString();
	}
	

	

}
