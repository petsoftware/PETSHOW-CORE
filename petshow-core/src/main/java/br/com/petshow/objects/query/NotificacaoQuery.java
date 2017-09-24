package br.com.petshow.objects.query;

import br.com.petshow.enums.EnumAssuntoNotificacao;
import br.com.petshow.model.Usuario;

public class NotificacaoQuery {

	
	private String mensagem;
	private String telefone;
	private String email;
	private String nome;
	private Usuario remetente;
	private Usuario destinatario;
	private EnumAssuntoNotificacao assunto;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public EnumAssuntoNotificacao getAssunto() {
		return assunto;
	}
	public void setAssunto(EnumAssuntoNotificacao assunto) {
		this.assunto = assunto;
	}
	
	
}
