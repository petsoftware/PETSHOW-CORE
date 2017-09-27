package br.com.petshow.util.mail;

import br.com.petshow.constants.EmailConstants;

public class Sender {

	private ISender iSender;
	
	public Sender() {
		// TODO Auto-generated constructor stub
		iSender = new SenderMail();
		iSender.setPassword("rafa1>rafa2");
		iSender.setUserName(EmailConstants.senderContato);
		iSender.setHostEmail("mail.barcadero.com.br");
		iSender.setSmtpPort(587);
	}
	
	public void send(String content, String subject, String from, String to) throws MailException{
		iSender.sendEmail(content, subject, from, to);
	}

}
