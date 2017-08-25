package br.com.petshow.model;

public class Estatistica extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8252446706298869062L;
	private long numeroDeAdocoes  = 0;
	private long numeroDeServicos = 0;
	private long numeroDeVendas   = 0;
	private long numeroDeAnuncios = 0;
	
	public long getNumeroDeAdocoes() {
		return numeroDeAdocoes;
	}
	public void setNumeroDeAdocoes(long numeroDeAdocoes) {
		this.numeroDeAdocoes = numeroDeAdocoes;
	}
	public long getNumeroDeServicos() {
		return numeroDeServicos;
	}
	public long getNumeroDeAnuncios() {
		return numeroDeAnuncios;
	}
	public void setNumeroDeAnuncios(long numeroDeAnuncios) {
		this.numeroDeAnuncios = numeroDeAnuncios;
	}
	public void setNumeroDeServicos(long numeroDeServicos) {
		this.numeroDeServicos = numeroDeServicos;
	}
	public long getNumeroDeVendas() {
		return numeroDeVendas;
	}
	public void setNumeroDeVendas(long numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}
	
	
}
