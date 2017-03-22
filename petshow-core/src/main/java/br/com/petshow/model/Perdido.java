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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.util.IDUtil;

@NamedQueries(value={
		@NamedQuery(name=Perdido.QRY_COUNT,query="SELECT COUNT("+IDUtil.ID+") FROM Perdido")
})
	

@Entity
@Table(name = "PERDIDO")
public class Perdido extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8218671348791628832L;

	public static final String QRY_COUNT = "Pedido.qryCount";
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@Column(name = "DESC_ACONTECIMENTO",nullable=false)
	private String descAcontecimento;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_PERDIDO" )
	@Column(length=10485760)
	private List<String> fotos;// no maximo 3
	
	@Column(name = "DT_PERDIDO_ACHADO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPerdidoAchado;
	
	
	@ManyToOne
	@JoinColumn(name = IDUtil.ID_CIDADE ,referencedColumnName=IDUtil.ID)
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = IDUtil.ID_ESTADO ,referencedColumnName=IDUtil.ID)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = IDUtil.ID_BAIRRO ,referencedColumnName=IDUtil.ID)
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

	@Column(name = "DESC_RACA",nullable=true)
	private String raca;
	
	
	@Column(name = "FL_ACONTECIMENTO",nullable=false)
	private String flAcontecimento;
	
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTipoAnimal tpAnimal;
	
	

	public EnumTipoAnimal getTpAnimal() {
		return tpAnimal;
	}

	public void setTpAnimal(EnumTipoAnimal tpAnimal) {
		this.tpAnimal = tpAnimal;
	}

	public String getDescAcontecimento() {
		return descAcontecimento;
	}

	public String getFlAcontecimento() {
		return flAcontecimento;
	}

	public void setFlAcontecimento(String flAcontecimento) {
		this.flAcontecimento = flAcontecimento;
	}

	public void setDescAcontecimento(String descAcontecimento) {
		this.descAcontecimento = descAcontecimento;
	}

	
	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Date getDtPerdidoAchado() {
		return dtPerdidoAchado;
	}

	public void setDtPerdidoAchado(Date dtPerdidoAchado) {
		this.dtPerdidoAchado = dtPerdidoAchado;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@JsonIgnore
	public String getFoto() {
		if(fotos.size()>0){
			return fotos.get(0);
		}else{
		 return null;
		}
	}
	
	
}
