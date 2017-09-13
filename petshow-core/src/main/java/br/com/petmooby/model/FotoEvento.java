package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO_EVENTO")
public class FotoEvento extends Foto {

	@OneToMany
	@JoinColumn(name = "ID_FOTO_EVENTO")
	private List<ComFotoEvento> comentarios;
	
	
	public List<ComFotoEvento> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComFotoEvento> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
}
