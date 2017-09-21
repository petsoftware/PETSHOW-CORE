package br.com.petmooby.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VOTACAO")
public class Votacao  extends Entidade  {
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name = "ID_VOTACAO_OPCOES" ,referencedColumnName="ID")
	private List<VotacaoOpcoes> opcoes;

	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="DT_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Column(name="DT_FINAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<VotacaoOpcoes> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<VotacaoOpcoes> opcoes) {
		this.opcoes = opcoes;
	}
	
	
	
}
