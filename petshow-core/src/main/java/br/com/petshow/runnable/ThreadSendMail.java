package br.com.petshow.runnable;

import br.com.petshow.util.mail.MailException;
import br.com.petshow.util.mail.Sender;

public class ThreadSendMail implements Runnable {

	private final String destiny;
	private final String from;
	private final String content;
	private final String subject;
	public ThreadSendMail(String destiny,String from,String content,String subject) {
		// TODO Auto-generated constructor stub
		this.destiny 	= destiny;
		this.from 		= from 	 ;
		this.content	= content;
		this.subject	= subject;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendEmail();
	}
	
	public void sendEmail() {
		Sender sender = new Sender();
		try {
			sender.send(content, subject, from, destiny);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			System.err.println("erro ao enviar email para : " + destiny);
			System.err.println("Erro: " + e.getMessage());
			
		}
	}
	
	

}
