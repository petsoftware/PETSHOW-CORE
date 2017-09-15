package br.com.petmooby.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.petmooby.enums.EnumFlTpEstabelecimento;
import br.com.petmooby.enums.EnumTipoUser;




/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:12
 
@NamedQueries(
		{
			@NamedQuery(name=Usuario.FIND_ALL		,query="FROM Usuario"),
			@NamedQuery(name=Usuario.FIND_BY_CODE	,query="FROM Usuario u WHERE u.codigo = :codigo"),
			@NamedQuery(name=Usuario.FIND_BY_LOGIN	,query="FROM Usuario u WHERE u.email = :email AND u.passWord = :senha"),
			@NamedQuery(name=Usuario.FIND_BY		,query="FROM Usuario u WHERE  u.nome LIKE :nome OR u.email LIKE :email "),
			@NamedQuery(name=Usuario.FIND_BY_EMAIL	,query="FROM Usuario u WHERE u.email = :email")
		}
)

*/


@NamedQueries({ @NamedQuery(name = Usuario.FIND_POR_NOME_LOGIN, query = "FROM Usuario usu WHERE usu.nmLogin = :nmLogin"), 
				@NamedQuery(name = Usuario.FIND_POR_NM_ANIMAL, query = "FROM Usuario usu WHERE usu.nome like '%:nome%' "), 
				@NamedQuery(name = Usuario.IDX_POR_FACEBOOK, query = "FROM Usuario usu WHERE usu.idFacebook = :idFacebook ")/* acrescentar animal*/
			   
})

@Entity
@Table(name="USUARIO",indexes = { @Index(name = Usuario.IDX_POR_FACEBOOK, columnList = "ID_FACEBOOK") })
public class Usuario extends Entidade  implements UserDetails// comentar implementacao
{
	
	private static final long serialVersionUID = 8937600656781400155L;
	public static final String ANONYMOUS_USER = "anonymousUser";
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_POR_NOME_LOGIN 	= "Usuario.porNomeLogin";
	public static final String FIND_POR_NM_ANIMAL 	= "Usuario.porNMouAnimal";
	public static final String IDX_POR_FACEBOOK 	= "UsuarioFacebook"; 
	
	@Column(name = "ID_FACEBOOK" )
	private Long idFacebook;
	
	@Column(name="FL_PRE_CADASTRO")
	private boolean flPreCadastro;
	
	@Column(name="FOTO_PERFIL" , length=10485760)
	private String foto = "";
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="RUA")
	private String rua;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@Column(name="NR_ENDERECO")
	private int nrEndereco;
	
	@Column(name="NR_CEP")
	private int nrCep;
	
	@Column(name="CNPJ_CPF")
	private String cnpjCpf;
	
	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name="TF_USUARIO")
	private int telefone;
	
	@Column(name="DDD_USUARIO")
	private int ddd;
	
	
	@Column(name="TF_USUARIO2")
	private int telefone2;
	
	@Column(name="DDD_USUARIO2")
	private int ddd2;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "ID_USUARIO" )
	private List<Servico> servicos;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "ID_USUARIO" )
	private List<Anuncio> anuncios;
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "ID_USUARIO" )
	private List<Venda> vendas;
	
	@Column(name="EMAIL",nullable=false)
	private String email;
	
	@Column(name="SENHA",nullable=false)
	private String password;

	@Column(name="NM_USUARIO")
	private String nome;
	
	@Column(name="TP_USER")
	private EnumTipoUser tipoUser = EnumTipoUser.MASTER;
	
	
	@Column(name="NM_LOGIN",nullable=false)
	private String nmLogin;
	
//	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Acesso> acessos;
	
	@Column(name="FL_TP_ESTABELECIMENTO",nullable=true,length=20)
	@Enumerated(EnumType.ORDINAL)
	private EnumFlTpEstabelecimento flTpEstabelecimento ;
	@Column(name="URL_FACEBOOK")
	private String URLFacebook;
	@Column(name="FL_VALIDATED",nullable=false)
	private boolean validated = false;
	

	@Column(nullable=false,name="DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCadastro = new Date();
	
	
	public String getURLFacebook() {
		return URLFacebook;
	}

	public void setURLFacebook(String uRLFacebook) {
		URLFacebook = uRLFacebook;
	}


	public boolean isFlPreCadastro() {
		return flPreCadastro;
	}

	public void setFlPreCadastro(boolean flPreCadastro) {
		this.flPreCadastro = flPreCadastro;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public int getDdd2() {
		return ddd2;
	}

	public void setDdd2(int ddd2) {
		this.ddd2 = ddd2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}
	
	public String getPassword() {
		return password;
	}
	@JsonIgnore
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	@JsonIgnore
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	@JsonIgnore
	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public EnumTipoUser getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(EnumTipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public int getNrEndereco() {
		return nrEndereco;
	}
	public void setNrEndereco(int nrEndereco) {
		this.nrEndereco = nrEndereco;
	}
	
	public int getNrCep() {
		return nrCep;
	}
	public void setNrCep(int nrCep) {
		this.nrCep = nrCep;
	}
	
	public String getCnpjCpf() {
		return cnpjCpf;
	}
	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//comentar daqui
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();
		if(acessos != null){
			for (Acesso acesso : acessos) {
				result.add(new SimpleGrantedAuthority(acesso.getNmAcesso()));
			}
		}
		return result;
	} 

	@JsonIgnore
	public String getUsername() {
		return getNmLogin();
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	// ate aqui
//	@JsonIgnore
	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}
	 public Long getIdFacebook() {
	        return this.idFacebook;
	    }

	    public void setIdFacebook(Long idFacebook) {
	        this.idFacebook = idFacebook;
	    }

		public EnumFlTpEstabelecimento getFlTpEstabelecimento() {
			return flTpEstabelecimento;
		}

		public void setFlTpEstabelecimento(EnumFlTpEstabelecimento flTpEstabelecimento) {
			this.flTpEstabelecimento = flTpEstabelecimento;
		}

		public boolean isValidated() {
			return validated;
		}

		public void setValidated(boolean validated) {
			this.validated = validated;
		}

		public Date getDtCadastro() {
			return dtCadastro;
		}

		public void setDtCadastro(Date dtCadastro) {
			this.dtCadastro = dtCadastro;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((acessos == null) ? 0 : acessos.hashCode());
			result = prime * result + ((anuncios == null) ? 0 : anuncios.hashCode());
			result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
			result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
			result = prime * result + ((cnpjCpf == null) ? 0 : cnpjCpf.hashCode());
			result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
			result = prime * result + ddd;
			result = prime * result + ddd2;
			result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((estado == null) ? 0 : estado.hashCode());
			result = prime * result + (flPreCadastro ? 1231 : 1237);
			result = prime * result + ((flTpEstabelecimento == null) ? 0 : flTpEstabelecimento.hashCode());
			result = prime * result + ((foto == null) ? 0 : foto.hashCode());
			result = prime * result + ((idFacebook == null) ? 0 : idFacebook.hashCode());
			result = prime * result + ((nmLogin == null) ? 0 : nmLogin.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + nrCep;
			result = prime * result + nrEndereco;
			result = prime * result + ((pais == null) ? 0 : pais.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
			result = prime * result + ((rua == null) ? 0 : rua.hashCode());
			result = prime * result + ((servicos == null) ? 0 : servicos.hashCode());
			result = prime * result + telefone;
			result = prime * result + telefone2;
			result = prime * result + ((tipoUser == null) ? 0 : tipoUser.hashCode());
			result = prime * result + (validated ? 1231 : 1237);
			result = prime * result + ((vendas == null) ? 0 : vendas.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (acessos == null) {
				if (other.acessos != null)
					return false;
			} else if (!acessos.equals(other.acessos))
				return false;
			if (anuncios == null) {
				if (other.anuncios != null)
					return false;
			} else if (!anuncios.equals(other.anuncios))
				return false;
			if (bairro == null) {
				if (other.bairro != null)
					return false;
			} else if (!bairro.equals(other.bairro))
				return false;
			if (cidade == null) {
				if (other.cidade != null)
					return false;
			} else if (!cidade.equals(other.cidade))
				return false;
			if (cnpjCpf == null) {
				if (other.cnpjCpf != null)
					return false;
			} else if (!cnpjCpf.equals(other.cnpjCpf))
				return false;
			if (complemento == null) {
				if (other.complemento != null)
					return false;
			} else if (!complemento.equals(other.complemento))
				return false;
			if (ddd != other.ddd)
				return false;
			if (ddd2 != other.ddd2)
				return false;
			if (dtCadastro == null) {
				if (other.dtCadastro != null)
					return false;
			} else if (!dtCadastro.equals(other.dtCadastro))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (estado == null) {
				if (other.estado != null)
					return false;
			} else if (!estado.equals(other.estado))
				return false;
			if (flPreCadastro != other.flPreCadastro)
				return false;
			if (flTpEstabelecimento != other.flTpEstabelecimento)
				return false;
			if (foto == null) {
				if (other.foto != null)
					return false;
			} else if (!foto.equals(other.foto))
				return false;
			if (idFacebook == null) {
				if (other.idFacebook != null)
					return false;
			} else if (!idFacebook.equals(other.idFacebook))
				return false;
			if (nmLogin == null) {
				if (other.nmLogin != null)
					return false;
			} else if (!nmLogin.equals(other.nmLogin))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (nrCep != other.nrCep)
				return false;
			if (nrEndereco != other.nrEndereco)
				return false;
			if (pais == null) {
				if (other.pais != null)
					return false;
			} else if (!pais.equals(other.pais))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (razaoSocial == null) {
				if (other.razaoSocial != null)
					return false;
			} else if (!razaoSocial.equals(other.razaoSocial))
				return false;
			if (rua == null) {
				if (other.rua != null)
					return false;
			} else if (!rua.equals(other.rua))
				return false;
			if (servicos == null) {
				if (other.servicos != null)
					return false;
			} else if (!servicos.equals(other.servicos))
				return false;
			if (telefone != other.telefone)
				return false;
			if (telefone2 != other.telefone2)
				return false;
			if (tipoUser != other.tipoUser)
				return false;
			if (validated != other.validated)
				return false;
			if (vendas == null) {
				if (other.vendas != null)
					return false;
			} else if (!vendas.equals(other.vendas))
				return false;
			return true;
		}
		
		

}
