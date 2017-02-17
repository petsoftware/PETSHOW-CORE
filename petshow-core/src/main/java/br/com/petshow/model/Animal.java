package br.com.petshow.model;

import java.util.Date;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumTipoAnimal;




@Entity
@Table(name = "ANIMAL")
public class Animal extends Entidade {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1753116276167779324L;


	@OneToMany
	@JsonIgnore
	@JoinColumn(name = "ID_ANIMAL" )
	private List<Tutor> tutores;
	
	
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTipoAnimal tipo;
	
	@Column(name="RACA")
	private String raca;
	
	@Column(name="NM_ANIMAL",nullable=false)
	private String nome;
	
	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
			
	@Column(name = "FL_SEXO")
	private String flSexo;

	
	
	@Column(name = "FL_ADOCAO")
	private boolean flAdocao;
	
	
	// private vacinas colocar?
	
	public boolean isFlAdocao() {
		return flAdocao;
	}

	public void setFlAdocao(boolean flAdocao) {
		this.flAdocao = flAdocao;
	}

	public EnumTipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoAnimal tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getFlSexo() {
		return flSexo;
	}

	public void setFlSexo(String flSexo) {
		this.flSexo = flSexo;
	}





}
