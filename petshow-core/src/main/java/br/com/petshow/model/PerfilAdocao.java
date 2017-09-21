package br.com.petmooby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.petmooby.enums.EnumFaseVida;
import br.com.petmooby.enums.EnumPorteAnimal;
import br.com.petmooby.enums.EnumSexo;
import br.com.petmooby.enums.EnumTipoAnimal;
/**
 * Para manter a tabela PEFIL_ADOCAO que tem as preferencia de adoção de um usuario.
 * @author Rafael ROcha
 * @since versao 1.0 dia 11/08/2017 as 14:31
 * @version 1.0
 */
@NamedQueries({
	@NamedQuery(name=PerfilAdocao.FIND_BY_USER,query="FROM PerfilAdocao WHERE usuario = :usuario")
})
@Entity
@Table(name="PERFIL_ADOCAO")
public class PerfilAdocao extends Entidade {
	public PerfilAdocao() {
		
	}
	
	public PerfilAdocao(Usuario usuario) {
		this.setUsuario(usuario);
	}
	
	public static final String FIND_BY_USER = "br.com.petshow.model.PerfilAdocao.findByUser";
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395064518878223454L;
	@Column(name="FASE_VIDA",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumFaseVida faseVida;
	@Column(name="TIPO_ANIMAL",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoAnimal tipoAnimal;
	@Column(name="PORTE_ANIMAL",nullable=false, length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumPorteAnimal porteAnimal;
	@Column(name="SEXO")
	@Enumerated(EnumType.ORDINAL)
	private EnumSexo sexo;
	@Column(name="FL_ATIVO")
	private boolean flAtivo = true;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO" ,referencedColumnName="ID")
	private Usuario usuario;

	public EnumFaseVida getFaseVida() {
		return faseVida;
	}

	public void setFaseVida(EnumFaseVida faseVida) {
		this.faseVida = faseVida;
	}

	public EnumTipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(EnumTipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public EnumPorteAnimal getPorteAnimal() {
		return porteAnimal;
	}

	public void setPorteAnimal(EnumPorteAnimal porteAnimal) {
		this.porteAnimal = porteAnimal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}



}
