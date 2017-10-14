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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumAchadoPerdido;
import br.com.petshow.enums.EnumCor;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.util.DateUtil;
import br.com.petshow.util.IDUtil;

@NamedQueries(value={
		@NamedQuery(name=Perdido.QRY_COUNT					  , query = "SELECT COUNT("+IDUtil.ID+") FROM Perdido WHERE flAtivo = true"),
		@NamedQuery(name = Perdido.FIND_POR_USUARIO			  , query = "FROM Perdido p WHERE p.usuario.id=:id and flAtivo = true order by p.dataCadastro desc"),
		@NamedQuery(name = Perdido.FIND_ENCONTRADO_POR_USUARIO, query = "FROM Perdido p WHERE p.usuario.id=:id AND p.flAtivo = true AND p.flAcontecimento = :flAcontecimento  order by p.dataCadastro desc")
})
	

@Entity
@Table(name = "PERDIDO")
public class Perdido extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8218671348791628832L;

	public static final String QRY_COUNT = "Pedido.qryCount";
	public static final String FIND_POR_USUARIO = "Perdido.porUsuario";
	public static final String FIND_ENCONTRADO_POR_USUARIO = "br.com.petshow.model.Perdido.encontradosPorUsuario";
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	@Column(name = "DESC_ACONTECIMENTO",nullable=false)
	private String descAcontecimento;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_PERDIDO" )
	@Column(length=10485760)
	private List<String> fotos = new ArrayList<>();// no maximo 3
	@Column(name = "DT_PERDIDO_ACHADO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPerdidoAchado;
	@Embedded
	private Endereco endereco = new Endereco();
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
	@OneToOne
	@JoinColumn(name = "ID_RACA",referencedColumnName=IDUtil.ID,nullable=true)
	private Racas raca;
	@Column(name = "DESC_NOME",nullable=true)
	private String nome;
	@Column(name = "FL_ACONTECIMENTO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumAchadoPerdido flAcontecimento;
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tpAnimal;
	@Column(name="TP_COR_PRINCIPAL",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	private EnumCor tpCorPrincipal;
	@Column(name="TP_COR_SEGUNDARIA",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	private EnumCor tpCorSegundaria;
	@Column(name = "DT_RESOLVIDO",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtResolvido;
	@Column(name = "FL_SEXO")
	@Enumerated(EnumType.ORDINAL)
	private EnumSexo flSexo;
	@Column(name = "FL_ENCONTRADO")
	private boolean flEncontrado = false;
	@Column(name = "DT_ENCONTRADO")
	private Date dtEncontrado;
	@Column(name = "FL_ATIVO")
	private boolean flAtivo = true;
	@Column(name="DT_DESATIVACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtDesativacao ;
	
	@Transient
	private String getTempoDePublicacao = "";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnumTipoAnimal getTpAnimal() {
		return tpAnimal;
	}

	public void setTpAnimal(EnumTipoAnimal tpAnimal) {
		this.tpAnimal = tpAnimal;
	}

	public String getDescAcontecimento() {
		return descAcontecimento;
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


	public Racas getRaca() {
		return raca;
	}
	
	

	public Date getDtResolvido() {
		return dtResolvido;
	}

	public void setDtResolvido(Date dtResolvido) {
		this.dtResolvido = dtResolvido;
	}

	public void setRaca(Racas raca) {
		this.raca = raca;
	}

	public Date getDtPerdidoAchado() {
		return dtPerdidoAchado;
	}

	public void setDtPerdidoAchado(Date dtPerdidoAchado) {
		this.dtPerdidoAchado = dtPerdidoAchado;
	}

	public EnumCor getTpCorPrincipal() {
		return tpCorPrincipal;
	}

	public void setTpCorPrincipal(EnumCor tpCorPrincipal) {
		this.tpCorPrincipal = tpCorPrincipal;
	}

	public EnumCor getTpCorSegundaria() {
		return tpCorSegundaria;
	}

	public void setTpCorSegundaria(EnumCor tpCorSegundaria) {
		this.tpCorSegundaria = tpCorSegundaria;
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
	
	public String getGetTempoDePublicacao() {
		if(dataCadastro != null){
			getTempoDePublicacao = DateUtil.getTempoEntreDatasPorExtenso(dataCadastro, new Date());
		}else{
			getTempoDePublicacao = "";
		}
		return getTempoDePublicacao;
	}

	public void setGetTempoDePublicacao(String getTempoDePublicacao) {
		this.getTempoDePublicacao = getTempoDePublicacao;
	}

	public void setFlAcontecimento(EnumAchadoPerdido flAcontecimento) {
		this.flAcontecimento = flAcontecimento;
	}

	public EnumAchadoPerdido getFlAcontecimento() {
		return flAcontecimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EnumSexo getFlSexo() {
		return flSexo;
	}

	public void setFlSexo(EnumSexo flSexo) {
		this.flSexo = flSexo;
	}

	public boolean isFlEncontrado() {
		return flEncontrado;
	}

	public void setFlEncontrado(boolean flEncontrado) {
		this.flEncontrado = flEncontrado;
	}

	public Date getDtEncontrado() {
		return dtEncontrado;
	}

	public void setDtEncontrado(Date dtEncontrado) {
		this.dtEncontrado = dtEncontrado;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public Date getDtDesativacao() {
		return dtDesativacao;
	}

	public void setDtDesativacao(Date dtDesativacao) {
		this.dtDesativacao = dtDesativacao;
	}
	
	@JsonIgnore
	public String isFoiEncontrado(){
		if(this.dtEncontrado != null){
			return "Sim";
		}
		return "Não";
	}
}
