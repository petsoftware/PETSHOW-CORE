package br.com.petshow.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TUTOR")
public class Tutor extends Entidade {
	
	private static final long serialVersionUID = 3676304632917516440L;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	
	@Column(name = "DONO_ATUAL")
	private boolean donoAtual;


	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_TUTOR")
	private List<FotoTutor> fotos;
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public boolean isDonoAtual() {
		return donoAtual;
	}


	public void setDonoAtual(boolean donoAtual) {
		this.donoAtual = donoAtual;
	}


	public List<FotoTutor> getFotos() {
		return fotos;
	}


	public void setFotos(List<FotoTutor> fotos) {
		this.fotos = fotos;
	}
	
	
}
