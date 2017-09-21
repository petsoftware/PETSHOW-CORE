package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petshow.enums.EnumUF;


@NamedQueries({ @NamedQuery(name = Estado.ALL, query = "FROM Estado e order by e.nome asc" )})
@Entity
@Table(name = "ESTADO")
public class Estado   extends Entidade{

	private static final long serialVersionUID = -4980228199205072923L;

	public static final String ALL = "todosEstados";
	
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SIGLA")
	private String sigla;
	
	@Column(name="UF")
	@Enumerated(EnumType.ORDINAL)
	private EnumUF uf = EnumUF.CE;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	
	
}
