package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumPorteAnimal;
import br.com.petshow.enums.EnumTipoAnimal;

public class PerfilAdocao extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395064518878223454L;
	@Column(name="",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumFaseVida faseVida;
	@Column(name="",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tipoAnimal;
	@Column(name="",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumPorteAnimal porteAnimal;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE" ,referencedColumnName="ID")
	private Usuario cliente;

	public EnumFaseVida getFaseVida() {
		return faseVida;
	}

	public void setFaseVida(EnumFaseVida faseVida) {
		this.faseVida = faseVida;
	}

	public EnumTipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(EnumTipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public EnumPorteAnimal getPorteAnimal() {
		return porteAnimal;
	}

	public void setPorteAnimal(EnumPorteAnimal porteAnimal) {
		this.porteAnimal = porteAnimal;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((faseVida == null) ? 0 : faseVida.hashCode());
		result = prime * result + ((porteAnimal == null) ? 0 : porteAnimal.hashCode());
		result = prime * result + ((tipoAnimal == null) ? 0 : tipoAnimal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilAdocao other = (PerfilAdocao) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (faseVida != other.faseVida)
			return false;
		if (porteAnimal != other.porteAnimal)
			return false;
		if (tipoAnimal != other.tipoAnimal)
			return false;
		return true;
	}
	
	

}
