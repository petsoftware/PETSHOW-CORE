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

@NamedQueries({@NamedQuery(name = Agendamento.AGENDAMENTO_PENDENTE, query = "FROM Agendamento a inner join a.servico as s where s.id=:idServico and a.dataAgendamento > :dataHJ and s.flExcluido=false"  )})


@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento   extends Entidade{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2226871396519881838L;

	public static final String AGENDAMENTO_PENDENTE="agendamentoPendente";
	
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
