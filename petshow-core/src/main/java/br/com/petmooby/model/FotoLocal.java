package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO_LOCAL")
public class FotoLocal extends Foto{

	@OneToMany
	@JoinColumn(name = "ID_FOTO_LOCAL") // verificar como colocar isso
	private List<ComFotoLocal> comentarios;


	public List<ComFotoLocal> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComFotoLocal> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
	
}
