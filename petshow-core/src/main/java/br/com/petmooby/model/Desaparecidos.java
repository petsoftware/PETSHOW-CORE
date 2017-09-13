package br.com.petmooby.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name=Desaparecidos.FIND_ALL,query="FROM Desaparecidos")
})
@Entity
@Table(name = "DESAPARECIDOS")
public class Desaparecidos extends Entidade {
	
	public static final String FIND_ALL = "Desaparecidos.findAll";
	/**
	 * 
	 */
	private static final long serialVersionUID = 4262678660918397040L;
	@Column(name="NOME", nullable=false, length=60)
	private String nome = "";
	@Column(name="NM_DONO", nullable=false, length=60)
	private String nmDono = "";
	@Column(name="DT_DESAPARECIMENTO", nullable=false, length=60)
	private Date dtDesaparecimento = new Date();
	@Column(name="BREVE_DESCRICAO", nullable=false, length=120)
	private String breveDescicao = "";
	@Column(name="CONTATO", nullable=false, length=20)
	private String contato = "";
	@Column(name="FOTO" , length=10485760)
	private String foto = "";
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBreveDescicao() {
		return breveDescicao;
	}
	public void setBreveDescicao(String breveDescicao) {
		this.breveDescicao = breveDescicao;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getNmDono() {
		return nmDono;
	}
	public void setNmDono(String nmDono) {
		this.nmDono = nmDono;
	}
	public void setDtDesaparecimento(Date dtDesaparecimento) {
		this.dtDesaparecimento = dtDesaparecimento;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getDtDesaparecimento() {
		return dtDesaparecimento;
	}
	
}
