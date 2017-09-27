package br.com.petshow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumPorteAnimal;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.util.DateUtil;
import br.com.petshow.util.IDUtil;




@NamedQueries({ @NamedQuery(name = Adocao.FIND_POR_USUARIO, query = "FROM Adocao a WHERE a.usuario.id = :id order by a.dataAdocao desc")})


@Entity
@Table(name = "ADOCAO")
public class Adocao extends Entidade {

	/**
	 * 
	 */
	public static final String FIND_POR_USUARIO = "Adocao.porUsuario";
	private static final long serialVersionUID 	= -2535670503647345911L;

	@Column(name = "DT_ADOCAO")
	@Temporal(TemporalType.DATE)
	private Date dataAdocao ;
	
	
	@ManyToOne
	@JoinColumn(name = IDUtil.ID_USUARIO ,referencedColumnName=IDUtil.ID)
	private Usuario usuario;

	@Column(name = "DESC_ADOCAO")
	private String descAdocao = "";
	
	@Column(name = "TITULO")
	private String titulo = "";
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_ADOCAO" )
	@Column(length=10485760)
	private List<String> fotos = new ArrayList<String>();// no maximo 3
	
	@Column(name="FASE",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	private EnumFaseVida fase = EnumFaseVida.FILHOTE;
	
	@Column(name = "FL_VACINADO")
	private boolean flVacinado = false;
	
	@Column(name = "FL_VERMIFUGADO")
	private boolean flVermifugado = false;
	
	@Column(name = "FL_CASTRADO")
	private boolean castrado = false;
	
	@Column(name = "TF_CELULAR",nullable=true)
	private Long telefoneCelular;
	
	@Column(name = "DDD_CELULAR",nullable=true)
	private Integer dddCelular;

	@Column(name = "TF_RESIDENCIAL",nullable=true)
	private Long telefoneResidencial;
	
	@Column(name = "DDD_RESIDENCIAL",nullable=true)
	private Integer dddResidencial;
	
	@Column(name = "DT_CADASTRO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tipo = EnumTipoAnimal.CACHORRO;
	
	@Column(name="RACA")
	private String raca;
	
	
	@Column(name = "FL_SEXO")
	@Enumerated(EnumType.ORDINAL)
	private EnumSexo flSexo = EnumSexo.MACHO;
	
	
	@Column(name="TP_PORTE",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	private EnumPorteAnimal porteAnimal;
	@Transient
	private String getTempoDePublicacao = "";

	@Embedded
	private Endereco endereco = new Endereco();
	
	@JsonIgnore
	public String getFoto() {
		if(fotos.size()>0){
			return fotos.get(0);
		}else{
		 return null;
		}
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public String getDescAdocao() {
		return descAdocao;
	}

	public void setDescAdocao(String descAdocao) {
		this.descAdocao = descAdocao;
	}



	public EnumPorteAnimal getPorteAnimal() {
		return porteAnimal;
	}

	public void setPorteAnimal(EnumPorteAnimal porteAnimal) {
		this.porteAnimal = porteAnimal;
	}



	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}



	public EnumFaseVida getFase() {
		return fase;
	}

	public void setFase(EnumFaseVida fase) {
		this.fase = fase;
	}



	public boolean isFlVacinado() {
		return flVacinado;
	}

	public void setFlVacinado(boolean flVacinado) {
		this.flVacinado = flVacinado;
	}



	public boolean isFlVermifugado() {
		return flVermifugado;
	}

	public void setFlVermifugado(boolean flVermifugado) {
		this.flVermifugado = flVermifugado;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}

	public Long getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Long telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}



	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}



	public Long getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(Long telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public Integer getDddResidencial() {
		return dddResidencial;
	}

	public void setDddResidencial(Integer dddResidencial) {
		this.dddResidencial = dddResidencial;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EnumTipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoAnimal tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public EnumSexo getFlSexo() {
		return flSexo;
	}

	public void setFlSexo(EnumSexo flSexo) {
		this.flSexo = flSexo;
	}

	public String getGetTempoDePublicacao() {
		getTempoDePublicacao = DateUtil.getTempoEntreDatasPorExtenso(dataCadastro, new Date());
		return getTempoDePublicacao;
	}

	public void setGetTempoDePublicacao(String getTempoDePublicacao) {
		this.getTempoDePublicacao = getTempoDePublicacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
