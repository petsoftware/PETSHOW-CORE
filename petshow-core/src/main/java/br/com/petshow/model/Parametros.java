package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petshow.enums.EnumTipoParametro;


@NamedQueries({
	@NamedQuery(name=Parametros.FIND_BY_CHAVE,query="FROM Parametros WHERE chave = :chave")
})

@Entity
@Table(name="PARAMETERS",indexes=@Index(unique=true,columnList="chave"))
public class Parametros extends Entidade {

	public static final String FIND_BY_CHAVE = "br.com.petshow.model.Parametros.findByChave";
	private static final long serialVersionUID = -2970061996454399614L;
	@Column(name="CHAVE",nullable=false)
	private int chave = 0;
	@Column(name="VALOR",nullable=false)
	private String valor = "";
	@Column(name="TIPO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoParametro tipo;
	@Column(name="DESCRICAO",length=120)
	private String descricao = "";
	@Column(name="DETALHE")
	private String detalhe = "";
	
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public EnumTipoParametro getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoParametro tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
	
	
}
