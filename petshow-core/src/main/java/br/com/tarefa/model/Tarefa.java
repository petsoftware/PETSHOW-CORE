package br.com.tarefa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumPrioridade;
import br.com.petshow.model.Entidade;
import br.com.petshow.model.Servico;
import br.com.tafera.enums.EnumDesenvolvedor;
import br.com.tafera.enums.EnumStatus;
import br.com.tafera.enums.EnumTipo;


@NamedQueries({ @NamedQuery(name = Tarefa.TODAS, query = "FROM Tarefa t order by t.dataCriacao desc" )})



@Entity
@Table(name = "TAREFA")
public class Tarefa extends Entidade {
	
	public static final String TODAS="todasTarefas";
	
	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "TAREFA_OBSERVACAO" )
	@Column(length=6000)
	private List<String> observacao;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "ANEXO_TAREFA" )
	@Column(length=10485760)
	private List<String> anexo;
	
	
	@Column(name="NM_CRIADOR",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumDesenvolvedor criador;
	
	@Column(name="DESENV_ALOCADO",nullable=true)
	@Enumerated(EnumType.STRING)
	private EnumDesenvolvedor desenvAlocado;
	
	@Column(name="TIPO",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTipo tipo;
	
	
	@Column(name="PRIORIDADE",nullable=true)
	@Enumerated(EnumType.STRING)
	private EnumPrioridade prioridade;
	
	@Column(name="STATUS",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	
	@Column(name="DESC_TAREFA",nullable=false,length=6000)
	private String descTarefa;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_TAREFA" )
	@Column(length=10485760)
	private List<String> fotos = new ArrayList<String>();
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	

	

	public EnumDesenvolvedor getDesenvAlocado() {
		return desenvAlocado;
	}

	public void setDesenvAlocado(EnumDesenvolvedor desenvAlocado) {
		this.desenvAlocado = desenvAlocado;
	}

	public List<String> getObservacao() {
		return observacao;
	}

	public void setObservacao(List<String> observacao) {
		this.observacao = observacao;
	}

	public List<String> getAnexo() {
		return anexo;
	}

	public void setAnexo(List<String> anexo) {
		this.anexo = anexo;
	}

	public String getDescTarefa() {
		return descTarefa;
	}

	public void setDescTarefa(String descTarefa) {
		this.descTarefa = descTarefa;
	}

	public EnumDesenvolvedor getCriador() {
		return criador;
	}

	public void setCriador(EnumDesenvolvedor criador) {
		this.criador = criador;
	}

	public EnumTipo getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipo tipo) {
		this.tipo = tipo;
	}

	public EnumPrioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(EnumPrioridade prioridade) {
		this.prioridade = prioridade;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	
		

	
	
}
