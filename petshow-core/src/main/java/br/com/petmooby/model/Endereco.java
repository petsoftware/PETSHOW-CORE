package br.com.petmooby.model;

import br.com.petmooby.enums.EnumUF;

public class Endereco {
	
	private EnumUF uf = null;
	private Cidade cidade = null;
	private String bairro = "";
	private String numero = "";
	public EnumUF getUf() {
		return uf;
	}
	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
