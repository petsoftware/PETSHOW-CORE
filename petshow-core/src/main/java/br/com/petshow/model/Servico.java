package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@NamedQueries({ @NamedQuery(name = Servico.SERVICO_POR_USUARIO, query = "FROM Servico s where usuario.id=:idUsuario and s.flExcluido=false order by s.flAtivo desc" ),
				@NamedQuery(name = Servico.NOME_DISPONIVEL, query = "FROM Servico s where usuario.id=:idUsuario and s.nmServico=:nmServico and s.flExcluido=false" ),
				@NamedQuery(name = Servico.COUNT_SERVICOS_ATIVOS, query = "SELECT COUNT(s) FROM Servico s WHERE usuario = :usuario AND flAtivo = :flAtivo" )
})


@Entity
@Table(name = "SERVICO")
public class Servico extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6591678939817953911L;
	public static final String SERVICO_POR_USUARIO		= "servicoPorUsuario";
	public static final String NOME_DISPONIVEL			= "nmDisponivel";
	public static final String COUNT_SERVICOS_ATIVOS 	= "br.com.petshow.model.Servico.countServicosAtivos";
	
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@Column(name="NM_SERVICO")
	private String nmServico;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VL_SERVICO")
	private double vlServico;
	
	@Column(name="FL_ATIVO")
	private boolean flAtivo;
	
	@Column(name="FL_EXCLUIDO")
	private boolean flExcluido;

	
	public boolean isFlExcluido() {
		return flExcluido;
	}

	public void setFlExcluido(boolean flExcluido) {
		this.flExcluido = flExcluido;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getVlServico() {
		return vlServico;
	}

	public void setVlServico(double valor) {
		this.vlServico = valor;
	}

	public String getNmServico() {
		return nmServico;
	}

	public void setNmServico(String nmServico) {
		this.nmServico = nmServico;
	}
	
	
}
