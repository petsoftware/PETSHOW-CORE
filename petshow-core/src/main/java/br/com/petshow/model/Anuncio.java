package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/* entidade que contem os anuncios cobrados para os usuarios(promoçoes do petshop ou algo do tipo)*/


// ver querie dps
@NamedQueries({ @NamedQuery(name = Anuncio.ANUNCIO_POR_USUARIO, query = "FROM Anuncio a where usuario.id=:idUsuario order by a.dataCadastro desc" )})

@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)									
@Entity
@Table(name = "ANUNCIO")
public class Anuncio extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890385286046957564L;

	public static final String ANUNCIO_POR_USUARIO="usuariosAnuncios";
	
	//@JsonIgnore
	//@ElementCollection
	//@CollectionTable(name = "FOTO_ANUNCIO")
	@Column(name="FOTO_ANUNCIO" , length=10485760)
	private String foto;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
		
	@Column(name = "DT_CADASTRO",nullable=false,columnDefinition = "timestamp without time zone ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name = "DT_INICIAL",nullable=false,columnDefinition = "timestamp without time zone ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;
	
	@Column(name = "DT_VENCIMENTO",nullable=false,columnDefinition = "timestamp without time zone ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVencimento;

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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	

	
	

}
