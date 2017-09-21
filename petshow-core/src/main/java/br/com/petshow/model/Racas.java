package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petshow.enums.EnumTipoAnimal;


@NamedQueries({ @NamedQuery(name = Racas.CONSULTA_TODAS, query = "FROM Racas r where r.tipoAnimal=:tipoAnimal order by r.descricao ASC" )})
															

@Entity
@Table(name = "RACAS")
public class Racas extends Entidade{
	
	public static final String CONSULTA_TODAS="racas.consultaTodas";
	
	
	@Column(name="TIPO_ANIMAL")
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tipoAnimal;

	@Column(name="DESC_RACA")
	private String descricao;
	

	
	public EnumTipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}
	public void setTipoAnimal(EnumTipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
