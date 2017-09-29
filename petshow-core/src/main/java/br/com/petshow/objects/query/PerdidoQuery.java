package br.com.petshow.objects.query;

import br.com.petshow.enums.EnumAchadoPerdido;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Cidade;

public class PerdidoQuery {
	
	public PerdidoQuery() {
		
	}
	
	private int limiteRegistros 	= 0;
	private EnumTipoAnimal tpAnimal ; 
	private EnumSexo sexo 			;
	private EnumUF	uf 				= EnumUF.CE;
	private Cidade cidade			;
	private EnumAchadoPerdido achadoPerdido;
	
	public int getLimiteRegistros() {
		return limiteRegistros;
	}
	public void setLimiteRegistros(int limiteRegistros) {
		this.limiteRegistros = limiteRegistros;
	}
	public EnumTipoAnimal getTpAnimal() {
		return tpAnimal;
	}
	public void setTpAnimal(EnumTipoAnimal tpAnimal) {
		this.tpAnimal = tpAnimal;
	}
	
	public EnumSexo getSexo() {
		return sexo;
	}
	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}
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
	public EnumAchadoPerdido getAchadoPerdido() {
		return achadoPerdido;
	}
	public void setAchadoPerdido(EnumAchadoPerdido achadoPerdido) {
		this.achadoPerdido = achadoPerdido;
	} 
	

}
