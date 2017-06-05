package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQueries({ @NamedQuery(name = Vermifugo.FIND_POR_ANIMAL, query = "FROM Vermifugo v WHERE v.animal.id = :idAnimal")})


@Entity
@Table(name = "VERMIFUGO")
public class Vermifugo  extends Entidade{
	
	public static final String FIND_POR_ANIMAL 	= "Vermifugo.animal"; 
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	@Column(name="DT_VERMIFUGO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="FL_REFORCO")
	private boolean reforco;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isReforco() {
		return reforco;
	}

	public void setReforco(boolean reforco) {
		this.reforco = reforco;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
}
