package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import br.com.petshow.enums.EnumFrequenciaVermifugacao;
import br.com.petshow.enums.EnumTipoAnimal;




@Entity
@Table(name = "ANIMAL")
@DynamicUpdate
public class Animal extends Entidade {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1753116276167779324L;

	@Column(name="FOTO_PERFIL" , length=10485760)
	private String fotoPerfil;

//	@OneToMany
//	@JsonIgnore
//	@JoinColumn(name = "ID_ANIMAL" )
//	private List<Tutor> tutores;
	@Transient
	private Tutor tutor;
	
	@Column(name="TP_ANIMAL",nullable=false)
	@Enumerated(EnumType.ORDINAL)
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
	
	@Column(name = "TEM_REFORCO",nullable=true)
	private Boolean temReforco;
	
	
	@Column(name="TP_FREQUENCIA_VERMIFUGO",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	private EnumFrequenciaVermifugacao frequenciaVermifugacao;
	
	
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

	public Boolean isTemReforco() {
		return temReforco;
	}

	public void setTemReforco(Boolean temReforco) {
		this.temReforco = temReforco;
	}

	public EnumFrequenciaVermifugacao getFrequenciaVermifugacao() {
		return frequenciaVermifugacao;
	}

	public void setFrequenciaVermifugacao(EnumFrequenciaVermifugacao frequenciaVermifugacao) {
		this.frequenciaVermifugacao = frequenciaVermifugacao;
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

//	public List<Tutor> getTutores() {
//		return tutores;
//	}
//
//	public void setTutores(List<Tutor> tutores) {
//		this.tutores = tutores;
//	}

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

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}


}
