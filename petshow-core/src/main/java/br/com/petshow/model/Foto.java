package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Foto extends Entidade{

	@Column(name="FOTO",nullable=false,length=10485760)
	private String foto;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="DT_INCLUSAO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	
	
}
