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

import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.enums.EnumVacina;
import br.com.petshow.enums.EnumVacinaDose;

@NamedQueries({
	@NamedQuery(name=VacinaCalender.FIND_ALL,query="FROM VacinaCalender")
})
@Entity
@Table(name="VACINA_CALENDAR")
public class VacinaCalender extends Entidade {
	
	public static final String FIND_ALL = "VacinaCalender.findAll";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7568662960490580365L;
	//CPOLIVALENTE(1,"Polivalente V8/V10 1º DOSE",EnumTipoAnimal.CACHORRO,2),
	@Column(name="VACINA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumVacina vacina;
	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tpAnimal;
	@Column(name="PROXIMA",nullable=false)
	private int proxima;
	@Column(name="FL_APLICADA",nullable=false)
	private boolean aplicada;
	@Column(name="DT_APLICACAO",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dtAplicacao;
	@Column(name="DT_PROVAVEL",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtProvavel;
	@Column(name="DOSE",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumVacinaDose dose = EnumVacinaDose.PRIMEIRA;
	@ManyToOne
	@JoinColumn(name = "ID_ANIMAL" ,referencedColumnName="ID")
	private Animal animal;
	
	public EnumVacina getVacina() {
		return vacina;
	}
	public void setVacina(EnumVacina vacina) {
		this.vacina = vacina;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public EnumTipoAnimal getTpAnimal() {
		return tpAnimal;
	}
	public void setTpAnimal(EnumTipoAnimal tpAnimal) {
		this.tpAnimal = tpAnimal;
	}
	
	public boolean isAplicada() {
		return aplicada;
	}
	public void setAplicada(boolean aplicada) {
		this.aplicada = aplicada;
	}
	public Date getDtAplicacao() {
		return dtAplicacao;
	}
	public void setDtAplicacao(Date dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
	public Date getDtProvavel() {
		return dtProvavel;
	}
	public void setDtProvavel(Date dtProvavel) {
		this.dtProvavel = dtProvavel;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public EnumVacinaDose getDose() {
		return dose;
	}
	public void setDose(EnumVacinaDose dose) {
		this.dose = dose;
	}
	public int getProxima() {
		return proxima;
	}
	public void setProxima(int proxima) {
		this.proxima = proxima;
	}
	
	

}
