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

import br.com.petshow.enums.EnumCategoria;
import br.com.petshow.util.DateUtil;


@NamedQueries({ 
	@NamedQuery(name = Venda.VENDA_POR_USUARIO, query = "FROM Venda v where usuario.id=:idUsuario order by v.dataCadastro desc" ),
	@NamedQuery(name = Venda.COUNT_VENDAS, 		query = "SELECT COUNT(v) FROM Venda v WHERE usuario = :usuario" )
})

@Entity
@Table(name = "VENDA")
public class Venda extends Entidade {

	
	/**
	 * 
	 */
	private static final long serialVersionUID 		= -3092300933879378313L;
	public static final String VENDA_POR_USUARIO	= "vendaUsuario";
	public static final String COUNT_VENDAS			= "br.com.petshow.model.Venda.countVendas";

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_VENDA" )
	@Column(length=10485760)
	private List<String> fotos = new ArrayList<String>();// no maximo 3
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@Column(name = "DESCRICAO",nullable=false)
	private String descricao;
	
	@Column(name = "DESCRICAO_RESUMIDA",nullable=false)
	private String descResumida;
		
	@Column(name = "DT_CADASTRO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	@Column(name = "DT_VENCIMENTO",nullable=false)
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVencimento;

	@Column(name = "TF_CELULAR")
	private long telefoneCelular;
	
	@Column(name = "DDD_CELULAR")
	private int dddCelular;

	@Column(name = "TF_RESIDENCIAL")
	private long telefoneResidencial;
	
	@Column(name = "DDD_RESIDENCIAL")
	private int dddResidencial;
	
	@Column(name = "VL_VENDA")
	private double vlVenda;
	@Column(name="CATEGORIA")
	@Enumerated(EnumType.ORDINAL)
	private EnumCategoria categoria;
	@Transient
	private String getTempoDePublicacao = "";
	
	@Embedded
	private Endereco endereco = new Endereco();
	
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public long getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(long telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public int getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(int dddCelular) {
		this.dddCelular = dddCelular;
	}

	public long getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(long telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public int getDddResidencial() {
		return dddResidencial;
	}

	public void setDddResidencial(int dddResidencial) {
		this.dddResidencial = dddResidencial;
	}

	

	public double getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}



	public String getDescResumida() {
		return descResumida;
	}

	public void setDescResumida(String descResumida) {
		this.descResumida = descResumida;
	}
	
	@JsonIgnore
	public String getFoto() {
		if(fotos.size()>0){
			return fotos.get(0);
		}else{
		 return null;
		}
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EnumCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}
	
	public String getGetTempoDePublicacao() {
		System.out.println("getGetTempoDePublicacao Venda:"+this.getClass().getName());
		getTempoDePublicacao = DateUtil.getTempoEntreDatasPorExtenso(dataCadastro, new Date());
		return getTempoDePublicacao;
	}

	public void setGetTempoDePublicacao(String getTempoDePublicacao) {
		this.getTempoDePublicacao = getTempoDePublicacao;
	}
	
}
