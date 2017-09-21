package br.com.petmooby.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.petmooby.enums.EnumUF;

@Entity
@Table(name = "EVENTO")
public class Evento extends Entidade {

	private static final long serialVersionUID = -7835978623096055142L;

	public Evento() {
	}
	
	@Column(name="BUNNER",length=10485760)
	private String bunner = "";
	
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
	@Temporal(TemporalType.DATE)
	private Date dataInicio = new Date();
	
	@Column(nullable= false, name="DT_TERMINO")
	@Temporal(TemporalType.DATE)
	private Date dataTermino = new Date();
	
	@Column( name="CIDADE",length=50)
	private String cidade ="";
	
	@Column( name="ESTADO")
	@Enumerated(EnumType.ORDINAL)
	private EnumUF uf = EnumUF.CE;
	
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

	public String getBunner() {
		return bunner;
	}

	public void setBunner(String bunner) {
		this.bunner = bunner;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	
}
