package br.com.petshow.objects;

import br.com.petshow.model.Entidade;

public class EnviarMensagem extends Entidade{
	
	private static final long serialVersionUID = 6813390589402694867L;
	private String nome    ;
	private String email  ;
	private String contato ;
	private String mensagem;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

}