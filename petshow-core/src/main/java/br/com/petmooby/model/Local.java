package br.com.petmooby.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOCAL")
public class Local extends Entidade{
	
	
	@OneToMany
	@JoinColumn(name = "ID_LOCAL" )
	private List<ComLocal> comentarios;
	
	@OneToMany
	@JoinColumn(name = "ID_LOCAL" )
	private List<FotoLocal> fotos;
	
	// private endereco como vai ficar o endereco
	@Column(name="TF_LOCAL")
	private long telefone;
    
	@Column(name="DDD_TEL")
	private int ddd;
    
	@Column(name="NM_LOCAL",nullable= false)
    private String nome;

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
    
	
	
	
}
