package br.com.petshow.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumFaseVida;

@Entity
@Table(name = "ADOCAO")
public class Adocao extends Entidade {
	
	
	
	@Column(name = "DT_ADOCAO")
	@Temporal(TemporalType.DATE)
	private Date dataAdocao;
	
	@OneToOne
	@JoinColumn(name = "ID_TUTOR" ,referencedColumnName="ID")
	private Tutor tutor;
	
	@Column(name = "DESC_ADOCAO")
	private String descAdocao;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_ADOCAO" )
	@Column(length=10485760)
	private List<String> fotos;// no maximo 3
	
	
	@Column(name="FASE",nullable=true)
	@Enumerated(EnumType.STRING)
	private EnumFaseVida fase;
	
	@Column(name = "FL_VACINADO")
	private boolean flVacinado;
	
	@Column(name = "FL_VERMIFUGADO")
	private boolean flVermifugado;
	
	@Column(name = "FL_CASTRADO")
	private boolean castrado;
	
	@ManyToOne
	@JoinColumn(name = "ID_CIDADE" ,referencedColumnName="ID")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO" ,referencedColumnName="ID")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "ID_BAIRRO" ,referencedColumnName="ID")
	private Bairro bairro;

	
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
	private Date dataCadastro;
	
	

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



	public Tutor getTutor() {
		return tutor;
	}



	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}



	public String getDescAdocao() {
		return descAdocao;
	}



	public void setDescAdocao(String descAdocao) {
		this.descAdocao = descAdocao;
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



	public Cidade getCidade() {
		return cidade;
	}



	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public Bairro getBairro() {
		return bairro;
	}



	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
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

	
	
	
}
