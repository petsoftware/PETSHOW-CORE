package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A data de adocao é " + getDataAdocao();
	}
	
	
	
}
