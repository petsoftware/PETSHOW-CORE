package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.petshow.enums.EnumFrequenciaTratamento;
import br.com.petshow.enums.EnumFrequenciaVermifugacao;


@NamedQueries({ @NamedQuery(name = Vermifugo.FIND_POR_ANIMAL, query = "FROM Vermifugo v WHERE v.animal.id = :idAnimal")})


@Entity
@Table(name = "VERMIFUGO")
public class Vermifugo  extends Entidade{
	
	public static final String FIND_POR_ANIMAL 	= "Vermifugo.animal"; 
	
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	@Column(name="DT_VERMIFUGO_DOSE_1",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date DtVermifugoDose1;
	
	@Column(name="FL_REFORCO")
	private boolean reforco;
	
	@Column(name="DT_VERMIFUGO_DOSE_REFORCO")
	@Temporal(TemporalType.DATE)
	private Date DtVermifugoDoseReforco;
	
	@Column(name="DT_VERMIFUGO_DOSE_1_ANT")
	@Temporal(TemporalType.DATE)
	private Date DtVermifugoDose1Ant;
	
	@Column(name="DT_VERMIFUGO_DOSE_REFORCO_ANT")
	@Temporal(TemporalType.DATE)
	private Date DtVermifugoDoseReforcoAnt;
	
	
	@Column(name="FREQUENCIA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumFrequenciaVermifugacao frequencia ;
	
	@Column(name="FL_TOMOU_1")
	private boolean isTomou1;
	
	@Column(name="FL_TOMOU_REFORCO")
	private boolean isTomouReforco;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getDtVermifugoDose1() {
		return DtVermifugoDose1;
	}

	public void setDtVermifugoDose1(Date dtVermifugoDose1) {
		DtVermifugoDose1 = dtVermifugoDose1;
	}

	public boolean isReforco() {
		return reforco;
	}

	public void setReforco(boolean reforco) {
		this.reforco = reforco;
	}

	public Date getDtVermifugoDoseReforco() {
		return DtVermifugoDoseReforco;
	}

	public void setDtVermifugoDoseReforco(Date dtVermifugoDoseReforco) {
		DtVermifugoDoseReforco = dtVermifugoDoseReforco;
	}

	public Date getDtVermifugoDose1Ant() {
		return DtVermifugoDose1Ant;
	}

	public void setDtVermifugoDose1Ant(Date dtVermifugoDose1Ant) {
		DtVermifugoDose1Ant = dtVermifugoDose1Ant;
	}

	public Date getDtVermifugoDoseReforcoAnt() {
		return DtVermifugoDoseReforcoAnt;
	}

	public void setDtVermifugoDoseReforcoAnt(Date dtVermifugoDoseReforcoAnt) {
		DtVermifugoDoseReforcoAnt = dtVermifugoDoseReforcoAnt;
	}

	public EnumFrequenciaVermifugacao getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(EnumFrequenciaVermifugacao frequencia) {
		this.frequencia = frequencia;
	}

	public boolean isTomou1() {
		return isTomou1;
	}

	public void setTomou1(boolean isTomou1) {
		this.isTomou1 = isTomou1;
	}

	public boolean isTomouReforco() {
		return isTomouReforco;
	}

	public void setTomouReforco(boolean isTomouReforco) {
		this.isTomouReforco = isTomouReforco;
	}

	public static String getFindPorAnimal() {
		return FIND_POR_ANIMAL;
	}
	
	
	
	
	
	
	
	
}
