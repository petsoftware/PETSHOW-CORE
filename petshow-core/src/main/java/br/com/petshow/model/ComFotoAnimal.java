package br.com.petshow.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COM_FOTO_ANIMAL")
public class ComFotoAnimal  extends Comentario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259645439185649356L;

	@ManyToOne
	@JoinColumn(name = "USUARIO_COMENTOU" ,referencedColumnName="ID")
	private Usuario usuarioComentou;
	
	@ManyToOne
	@JoinColumn(name = "ANIMAL" ,referencedColumnName="ID")
	private Animal animal;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Usuario getUsuarioComentou() {
		return usuarioComentou;
	}

	public void setUsuarioComentou(Usuario usuarioComentou) {
		this.usuarioComentou = usuarioComentou;
	}
	
	
	
}
