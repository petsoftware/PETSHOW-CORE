package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CEP")
public class CEP  extends Entidade{

	@Column(name="NR_CEP")
	private String nrCEP;
	
	@Column(name="NM_LOGRADOURO")
	private String nmLogradouro;
	
	@Column(name="TP_LOGRADOURO")
	private String tpLogradouro;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_ESTADO" ,referencedColumnName="ID")
	private Estado estado;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CIDADE" ,referencedColumnName="ID")
	private Cidade cidade;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_BAIRRO1" ,referencedColumnName="ID")
	private Bairro bairro1;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_BAIRRO2" ,referencedColumnName="ID")
	private Bairro bairro2;


	public String getNrCEP() {
		return nrCEP;
	}


	public void setNrCEP(String nrCEP) {
		this.nrCEP = nrCEP;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public String getNmLogradouro() {
		return nmLogradouro;
	}


	public void setNmLogradouro(String nmLogradouro) {
		this.nmLogradouro = nmLogradouro;
	}


	public String getTpLogradouro() {
		return tpLogradouro;
	}


	public void setTpLogradouro(String tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}


	public Bairro getBairro1() {
		return bairro1;
	}


	public void setBairro1(Bairro bairro1) {
		this.bairro1 = bairro1;
	}


	public Bairro getBairro2() {
		return bairro2;
	}


	public void setBairro2(Bairro bairro2) {
		this.bairro2 = bairro2;
	}


	
	
	
	
	
}
