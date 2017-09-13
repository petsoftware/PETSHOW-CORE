package br.com.petmooby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VOTACAO_OPCOES")
public class VotacaoOpcoes extends Entidade{

	@Column(name="DESCRICAO")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
