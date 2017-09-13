package br.com.petmooby.model;

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

import br.com.petmooby.enums.EnumVacina;

@NamedQueries({ @NamedQuery(name = Vacina.FIND_POR_ANIMAL, query = "FROM Vacina v WHERE v.animal.id = :idAnimal")})


@Entity
@Table(name = "VACINA")
public class Vacina extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5848435645926346376L;

	public static final String FIND_POR_ANIMAL 	= "Vacina.animal"; 
	
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	@Column(name="TIPO_VACINA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumVacina tpVacina ;
	
	@Column(name="DT_VACINA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="FL_APLICADA")
	private boolean flAplicada;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTABELECIMENTO" ,referencedColumnName="ID")
	private Usuario estabelecimento;
	
	@Column(name="DT_PROXIMA",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date previsaoProxima;

	public Date getPrevisaoProxima() {
		return previsaoProxima;
	}

	public void setPrevisaoProxima(Date previsaoProxima) {
		this.previsaoProxima = previsaoProxima;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public EnumVacina getTpVacina() {
		return tpVacina;
	}

	public void setTpVacina(EnumVacina tpVacina) {
		this.tpVacina = tpVacina;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public Usuario getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Usuario estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public boolean isFlAplicada() {
		return flAplicada;
	}

	public void setFlAplicada(boolean flAplicada) {
		this.flAplicada = flAplicada;
	}
	
	

}
