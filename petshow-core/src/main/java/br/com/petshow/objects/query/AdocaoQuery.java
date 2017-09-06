package br.com.petshow.objects.query;

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;

public class AdocaoQuery {
	
	public AdocaoQuery() {
		
	}
	private long estado 			= 0; 
	private long cidade 			= 0;
	private int limiteRegistros 	= 0;
	private EnumTipoAnimal tpAnimal = EnumTipoAnimal.CACHORRO; 
	private EnumFaseVida fase 		= EnumFaseVida.FILHOTE; 
	private EnumSexo sexo 			= EnumSexo.MACHO;
	public long getEstado() {
		return estado;
	}
	public void setEstado(long estado) {
		this.estado = estado;
	}
	public long getCidade() {
		return cidade;
	}
	public void setCidade(long cidade) {
		this.cidade = cidade;
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
	

}
