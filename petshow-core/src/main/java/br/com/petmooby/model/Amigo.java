package br.com.petmooby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petmooby.util.IDUtil;



@NamedQueries({ @NamedQuery(name = Amigo.FIND_FRIEND, query = "FROM Amigo a WHERE a.usuario.id = :usuario and a.amigo.id= :amigo")})

@Entity
@Table(name = "AMIGO")
public class Amigo extends Entidade {

	public static final String FIND_FRIEND ="ENTIDADE.AMIGO";

	@ManyToOne
	@JoinColumn(name = IDUtil.ID_USUARIO ,referencedColumnName=IDUtil.ID)
	private Usuario usuario;
	

	@ManyToOne
	@JoinColumn(name = "ID_AMIGO" ,referencedColumnName="ID")
	private Usuario amigo;

	@Column(name="FL_SEGUIR")
	private boolean flSeguir;

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Usuario getAmigo() {
		return amigo;
	}


	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}


	public boolean isFlSeguir() {
		return flSeguir;
	}


	public void setFlSeguir(boolean flSeguir) {
		this.flSeguir = flSeguir;
	}
	
	
}
