package br.com.petshow.objects.query;

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Cidade;

public class AdocaoQuery {
	
	public AdocaoQuery() {
		
	}
	private long estado 			= 0; 
	private int limiteRegistros 	= 0;
	private EnumTipoAnimal tpAnimal = null; 
	private EnumFaseVida fase 		= null; 
	private EnumSexo sexo 			= null;
	private EnumUF	uf 				= EnumUF.CE;
	
	private Cidade cidade			;
	public long getEstado() {
		return estado;
	}
	public void setEstado(long estado) {
		this.estado = estado;
	}
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
	public EnumFaseVida getFase() {
		return fase;
	}
	public void setFase(EnumFaseVida fase) {
		this.fase = fase;
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
	

}
