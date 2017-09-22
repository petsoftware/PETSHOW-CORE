package br.com.petshow.enums;

public enum EnumAssuntoNotificacao {
	
	PERDIDO("Informações de um perdido"),
	ADOCAO("Informações de uma adoção"),
	SERVICO("Informações de um Serviço");

	private final String descAssunto;
	EnumAssuntoNotificacao(String descAssunto){
		this.descAssunto = descAssunto;
	}
	public String getDescAssunto() {
		return descAssunto;
	}
	
}
