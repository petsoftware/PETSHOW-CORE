package br.com.petshow.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO_ANIMAL")
public class FotoAnimal extends Foto {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8841780443460468220L;
	@OneToMany
	@JoinColumn(name = "ANIMAL") 
	private List<ComFotoAnimal> comentarios;
	
	
}
