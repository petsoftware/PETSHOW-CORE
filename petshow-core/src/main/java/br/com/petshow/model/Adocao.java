package br.com.petshow.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.petshow.enums.EnumFaseVida;

@Entity
@Table(name = "ADOCAO")
public class Adocao extends Entidade {
	
	public Adocao() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name = "DT_ADOCAO")
	@Temporal(TemporalType.DATE)
	private Date dataAdocao;
	
	@OneToOne
	@JoinColumn(name = "ID_TUTOR" ,referencedColumnName="ID")
	private Tutor tutor;
	
	@Column(name = "DESC_ADOCAO")
	private String descAdocao;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOTO_ADOCAO" )
	@Column(length=10485760)
	private List<String> fotos;// no maximo 3
	
	
	@Column(name="FASE",nullable=true)
	@Enumerated(EnumType.STRING)
	private EnumFaseVida fase;
	
	@Column(name = "FL_VACINADO")
	private boolean flVacinado;
	
	@Column(name = "FL_VERMIFUGADO")
	private boolean flVermifugado;
	
	@Column(name = "FL_CASTRADO")
	private boolean castrado;
	

	public String getDescAdocao() {
		return descAdocao;
	}

	public void setDescAdocao(String descAdocao) {
		this.descAdocao = descAdocao;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@JsonIgnore
	public String getFoto() {
		if(fotos.size()>0){
			return fotos.get(0);
		}else{
		 return null;
		}
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}


	public EnumFaseVida getFase() {
		return fase;
	}

	public void setFase(EnumFaseVida fase) {
		this.fase = fase;
	}

	public boolean isFlVacinado() {
		return flVacinado;
	}

	public void setFlVacinado(boolean flVacinado) {
		this.flVacinado = flVacinado;
	}

	public boolean isFlVermifugado() {
		return flVermifugado;
	}

	public void setFlVermifugado(boolean flVermifugado) {
		this.flVermifugado = flVermifugado;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	
	
	
}
