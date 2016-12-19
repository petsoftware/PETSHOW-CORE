package br.com.petshow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
public abstract class Entidade implements Serializable {
	
	//private static final long serialVersionUID = -4937210358058008264L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8535860641291662663L;

	public Entidade() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Entidade(Usuario usuario) {
		// TODO Auto-generated constructor stub
		if(usuario != null){
			this.setUsuario(usuario);
		}
		
	}
*/	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private long id;
	/*
	-------------------------------------------------------------------------------------------------
	Por padrão, quando aplicamos o tipo java.util.Date ou java.util.Calendar, tanto a data
	quanto a hora serão armazenadas no banco de dados. Para mudar esse comportamento, devemos
	aplicar a anotação @Temporal escolhendo uma das três opções abaixo:
	TemporalType.DATE: Armazena apenas a data (dia, mês e ano).
	TemporalType.TIME: Armazena apenas o horário (hora, minuto e segundo).
	TemporalType.TIMESTAMP (Padrão): Armazena a data e o horário.
	------------------------------------------------------------------------------------------------- 
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtCadastro = new Date();
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrCadastro = new Date();
	 */
	/* pra que isso???
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="usuario",referencedColumnName="codigo")
	private Usuario usuario;
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		//result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		//result = prime * result + ((hrCadastro == null) ? 0 : hrCadastro.hashCode());
		//result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		if (id != other.id)
			return false;
		/*if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (hrCadastro == null) {
			if (other.hrCadastro != null)
				return false;
		} else if (!hrCadastro.equals(other.hrCadastro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;*/
		return true;
	}
	
	
}
