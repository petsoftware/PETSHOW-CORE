package br.com.petshow.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FOTO_TUTOR")
public class FotoTutor extends Foto {

	
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
