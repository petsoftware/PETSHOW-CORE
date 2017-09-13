package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHECK_IN_PETSHOP")
public class CheckInPetshop extends CheckIn {
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario petshop;

	public Usuario getPetshop() {
		return petshop;
	}

	public void setPetshop(Usuario petshop) {
		this.petshop = petshop;
	}
	
	@OneToMany( orphanRemoval=true)
	@JoinColumn(name = "ID_CHECK_IN_PETSHOP" )
	private List<ComCheckInPetshop> comentarios;
	
	
	
}
