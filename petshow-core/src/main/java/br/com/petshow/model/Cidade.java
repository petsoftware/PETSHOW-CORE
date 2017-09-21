package br.com.petshow.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petshow.enums.EnumUF;


@NamedQueries({ @NamedQuery(name = Cidade.CIDADE_POR_ESTADO_POR_ID	, query = "FROM Cidade c where estado.id=:id order by c.nome asc" ),
			 	@NamedQuery(name = Cidade.CIDADE_POR_ESTADO_POR_UF	, query = "FROM Cidade c where estado.sigla=:uf order by c.nome asc" ),
			 	@NamedQuery(name = Cidade.FIND_ALL_BY_UF			, query = "FROM Cidade WHERE uf = :uf" )
})
@Entity
@Table(name = "CIDADE")
public class Cidade  extends Entidade {

	private static final long serialVersionUID = -2906194527919052578L;
	public static final String CIDADE_POR_ESTADO_POR_ID = "cidadePorEstadoID";
	public static final String CIDADE_POR_ESTADO_POR_UF = "cidadePorEstadoUF";
	public static final String FIND_ALL_BY_UF		    = "br.com.petshow.model.Cidade.findAllByUF";
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_ESTADO" ,referencedColumnName="ID")
	private Estado estado;
	
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="COD_IBGE")
	private long codIbge = 0;
	
	@Column(name="COD_CIDADE")
	private long codCidade = 0;
	
	@Column(name="UF",length=3)
	@Enumerated(EnumType.STRING)
	private EnumUF uf = EnumUF.CE;
	
	
	@Column(name="NOME")
	private String nome = "";

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public long getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(long codIbge) {
		this.codIbge = codIbge;
	}

	public long getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(long codCidade) {
		this.codCidade = codCidade;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	
}
