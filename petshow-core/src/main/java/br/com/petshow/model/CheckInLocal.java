package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHECK_IN_LOCAL")
public class CheckInLocal  extends CheckIn{

	@ManyToOne
	@JoinColumn(name = "ID_LOCAL" ,referencedColumnName="ID")
	private Local local;

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	@OneToMany( orphanRemoval=true)
	@JoinColumn(name = "ID_CHECK_IN_LOCAL" )
	private List<ComCheckInLocal> comentarios;
	
	
}
