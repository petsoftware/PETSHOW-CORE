package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "CHECK_IN_EVENTO")
public class CheckInEvento extends CheckIn{

	
	@ManyToOne
	@JoinColumn(name = "ID_EVENTO" ,referencedColumnName="ID")
	private Evento evento;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	@OneToMany( orphanRemoval=true)
	@JoinColumn(name = "ID_CHECK_IN_EVENTO" )
	private List<ComCheckInEvento> comentarios;
	
	
}

