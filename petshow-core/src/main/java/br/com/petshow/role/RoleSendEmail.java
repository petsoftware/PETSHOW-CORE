package br.com.petshow.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.constants.EmailConstants;
import br.com.petshow.objects.EnviarMensagem;
import br.com.petshow.runnable.ThreadSendMail;

@Transactional
@Service
public class RoleSendEmail {

	public void enviar(EnviarMensagem enviarMensagem) {
		Thread runEmail = new Thread(new ThreadSendMail(EmailConstants.senderContato,
				EmailConstants.senderContato, 
				enviarMensagem.getMensagem(),
				"Contato pelo site PETMOOBY"));
		runEmail.start();
	}
}
