package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = Bairro.BAIRRO_POR_CIDADE, query = "FROM Bairro b where cidade.id=:idCidade order by b.nome asc" )})
@Entity
@Table(name = "BAIRRO")
public class Bairro   extends Entidade{

	public static final String BAIRRO_POR_CIDADE="bairroPorCidade";
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CIDADE" ,referencedColumnName="ID")
	private Cidade cidade;
	
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
