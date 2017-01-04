package br.com.petshow.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.codehaus.jackson.annotate.JsonProperty;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
//import org.springframework.security.core.userdetails.UserDetails;

import br.com.petshow.enums.EnumTipoUser;
//import br.com.springsecurity.model.Role;



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
				@NamedQuery(name = Usuario.FIND_POR_NM_ANIMAL, query = "FROM Usuario usu WHERE usu.nome like '%:nome%' ")/* acrescentar animal*/
			   
})

@Entity
@Table(name="USUARIO")
public class Usuario extends Entidade  implements UserDetails{
	
	private static final long serialVersionUID = 8937600656781400155L;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_POR_NOME_LOGIN 	= "Usuario.porNomeLogin";
	public static final String FIND_POR_NM_ANIMAL 	= "Usuario.porNMouAnimal";
	
	@Column(name="FL_PRE_CADASTRO")
	private boolean flPreCadastro;
	
	@Column(name="FOTO_PERFIL" , length=10485760)
	private String foto;
	
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
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Acesso> acessos;
	
	
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tipoUser == null) ? 0 : tipoUser.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tipoUser != other.tipoUser)
			return false;
		return true;
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

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();
		for (Acesso acesso : acessos) {
			result.add(new SimpleGrantedAuthority(acesso.getNmAcesso()));
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
	@JsonIgnore
	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

}
