package br.com.petshow.objects.query;

import br.com.petshow.enums.EnumCategoria;
import br.com.petshow.enums.EnumTipoClassificado;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.model.Cidade;

public class VendasQuery {
	
	private EnumUF	uf 	 ;
	private Cidade cidade;
	private EnumCategoria categoria;
	private EnumTipoClassificado enumTipoClassificado;
	private String descResumida;
	
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
	public EnumCategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}
	public EnumTipoClassificado getEnumTipoClassificado() {
		return enumTipoClassificado;
	}
	public void setEnumTipoClassificado(EnumTipoClassificado enumTipoClassificado) {
		this.enumTipoClassificado = enumTipoClassificado;
	}
	public String getDescResumida() {
		return descResumida;
	}
	public void setDescResumida(String descResumida) {
		this.descResumida = descResumida;
	}

}
