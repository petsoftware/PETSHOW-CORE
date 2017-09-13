package br.com.petmooby.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({ @NamedQuery(name = Cidade.CIDADE_POR_ESTADO_POR_ID, query = "FROM Cidade c where estado.id=:id order by c.nome asc" ),
			 @NamedQuery(name = Cidade.CIDADE_POR_ESTADO_POR_UF, query = "FROM Cidade c where estado.sigla=:uf order by c.nome asc" )})
@Entity
@Table(name = "CIDADE")
public class Cidade  extends Entidade {

	public static final String CIDADE_POR_ESTADO_POR_ID="cidadePorEstadoID";
	public static final String CIDADE_POR_ESTADO_POR_UF="cidadePorEstadoUF";
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_ESTADO" ,referencedColumnName="ID")
	private Estado estado;
	
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
