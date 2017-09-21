package br.com.petshow.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO_TUTOR")
public class FotoTutor extends Foto {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6749877864088300054L;
	@OneToMany
	@JoinColumn(name = "ID_FOTO_TUTOR") 
	private List<ComFotoTutor> comentarios;
	

	public List<ComFotoTutor> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComFotoTutor> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
	
}
