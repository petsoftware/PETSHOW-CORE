package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento   extends Entidade{

	@ManyToOne
	@JoinColumn(name = "ID_TUTOR" ,referencedColumnName="ID")
	private Tutor tutor;
	
	@ManyToOne
	@JoinColumn(name = "ID_SERVICO" ,referencedColumnName="ID")
	private Servico servico;
	
	
	@Column(name="DT_AGENDAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgendamento;


	public Tutor getTutor() {
		return tutor;
	}


	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public Date getDataAgendamento() {
		return dataAgendamento;
	}


	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	
	
	
}
