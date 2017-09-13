package br.com.petmooby.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO_CLIENTE")
public class UsuarioCliente extends Entidade{

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE" ,referencedColumnName="ID")
	private Usuario cliente;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTABELECIMENTO" ,referencedColumnName="ID")
	private Usuario estabelecimento;
	
	@Column(name = "DT_CADASTRO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Usuario estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
}
