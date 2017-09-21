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

@NamedQueries({ @NamedQuery(name = Tratamento.FIND_POR_ANIMAL, query = "FROM Tratamento t WHERE t.animal.id = :idAnimal")})



@Entity
@Table(name = "Tratamento")
public class Tratamento extends Entidade{
	
	public static final String FIND_POR_ANIMAL 	= "Tratamento.animal"; 
	
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	@Column(name="FREQUENCIA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumFrequenciaTratamento frequencia ;

	
	@Column(name="NM_TRATAMENTO")
	private String nm_tratamento;
	
	
	@Column(name="DT_INICIO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column(name="DT_TERMINO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	@Column(name="HR_TRATAMENTO",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrTratamento;
  
	public Animal getAnimal() {
		return animal;
	}

	public Date getHrTratamento() {
		return hrTratamento;
	}

	public void setHrTratamento(Date hrTratamento) {
		this.hrTratamento = hrTratamento;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public EnumFrequenciaTratamento getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(EnumFrequenciaTratamento frequencia) {
		this.frequencia = frequencia;
	}

	public String getNm_tratamento() {
		return nm_tratamento;
	}

	public void setNm_tratamento(String nm_tratamento) {
		this.nm_tratamento = nm_tratamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
}
