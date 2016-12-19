package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ACESSO")
public class Acesso extends Entidade{

	@Column(name = "NM_ACESSO",nullable=false)
	private String nmAcesso;

	public String getNmAcesso() {
		return nmAcesso;
	}

	public void setNmAcesso(String nmAcesso) {
		this.nmAcesso = nmAcesso;
	}
	
	
	
	
}
