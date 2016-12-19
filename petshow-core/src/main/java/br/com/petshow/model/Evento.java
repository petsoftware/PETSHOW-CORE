package br.com.petshow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTO")
public class Evento extends Entidade {

	private static final long serialVersionUID = -7835978623096055142L;

	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_EVENTO" )
	private List<ComEvento> comentarios = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_EVENTO" )
	private List<FotoEvento> fotos = new ArrayList<>();
	
	@Column(name="NM_EVENTO",nullable= false)
	private String nome;
	@Column(name="DESCRICAO",nullable= false)
	private String descricao;
	
	@Column(name="DT_INICIO",nullable= false)
	private Date dataInicio;
	
	@Column(nullable= false, name="DT_TERMINO")
	private Date dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "ID_LOCAL" ,referencedColumnName="ID")
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;

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

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ComEvento> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComEvento> comentarios) {
		this.comentarios = comentarios;
	}

	public List<FotoEvento> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotoEvento> fotos) {
		this.fotos = fotos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
