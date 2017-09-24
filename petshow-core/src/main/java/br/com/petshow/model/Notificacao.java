package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.petshow.enums.EnumAssuntoNotificacao;
import br.com.petshow.util.DateUtil;
import br.com.petshow.util.IDUtil;

@NamedQueries({ 
	@NamedQuery(name = Notificacao.IDX_POR_USUARIO, query = "FROM Notificacao n WHERE n.usuarioDestinatario.id = :idUsuario  and flExcluida =false order by dtNotificacao desc")
   
})


@Entity
@Table(name = "NOTIFICACAO",indexes = { @Index(name = Notificacao.IDX_POR_USUARIO, columnList = "ID_USUARIO_DESTINATARIO,FL_EXCLUIDA") })
public class Notificacao  extends Entidade {

	private static final long serialVersionUID = 8948303763460801474L;
	public static final String IDX_POR_USUARIO	= "Notificacao_USUARIO";
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_REMETENTE" ,referencedColumnName=IDUtil.ID)
	private Usuario usuarioRemetente;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_DESTINATARIO",referencedColumnName=IDUtil.ID)
	private Usuario usuarioDestinatario;
	
	@Column(name = "DT_NOTIFICACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtNotificacao;
	
	@Column(name = "FL_ENVIADA")
	private boolean flEnviada = false;
	
	@Column(name = "FL_LIDA")
	private boolean flLida = false;
	
	@Column(name = "FL_EXCLUIDA")
	private boolean flExcluida = false;
	
	@Column(name = "FL_RESPONDEU")
	private boolean flRespondeu = false;
	
	@Column(name = "MENSAGEM_RESPONDIDA", length=250)
	private String mensagemRespondida = "";
	
	@Column(name = "RESPOSTA", length=250)
	private String resposta = "";
	
	@Column(name = "TP_NOTIFICACAO")
	private String tpNotificacao;
	
	@Column(name = "MSG_NOTIFICACAO")
	private String msgNotificacao;
	
	@Column(name = "ASSUNTO")
	@Enumerated(EnumType.ORDINAL)
	private EnumAssuntoNotificacao assuntoNotificacao;

	@Column(name = "EMAIL",length=50)
	private String email = "";
	@Column(name = "CONTATO",length=15)
	private String contato = "";
	@Column(name = "NOME",length=15)
	private String nome = "";
	
	@Transient
	private String getTempoDePublicacao = "";
	
	public String getMsgNotificacao() {
		return msgNotificacao;
	}

	public void setMsgNotificacao(String msgNotificacao) {
		this.msgNotificacao = msgNotificacao;
	}

	public Usuario getUsuarioRemetente() {
		return usuarioRemetente;
	}

	public void setUsuarioRemetente(Usuario usuarioRemetente) {
		this.usuarioRemetente = usuarioRemetente;
	}

	public Usuario getUsuarioDestinatario() {
		return usuarioDestinatario;
	}

	public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
		this.usuarioDestinatario = usuarioDestinatario;
	}

	public Date getDtNotificacao() {
		return dtNotificacao;
	}

	public void setDtNotificacao(Date dtNotificacao) {
		this.dtNotificacao = dtNotificacao;
	}

	public boolean isFlEnviada() {
		return flEnviada;
	}

	public void setFlEnviada(boolean flEnviada) {
		this.flEnviada = flEnviada;
	}

	public boolean isFlLida() {
		return flLida;
	}

	public void setFlLida(boolean flLida) {
		this.flLida = flLida;
	}

	public boolean isFlExcluida() {
		return flExcluida;
	}

	public void setFlExcluida(boolean flExcluida) {
		this.flExcluida = flExcluida;
	}

	public String getTpNotificacao() {
		return tpNotificacao;
	}

	public void setTpNotificacao(String tpNotificacao) {
		this.tpNotificacao = tpNotificacao;
	}

	public EnumAssuntoNotificacao getAssuntoNotificacao() {
		return assuntoNotificacao;
	}

	public void setAssuntoNotificacao(EnumAssuntoNotificacao assuntoNotificacao) {
		this.assuntoNotificacao = assuntoNotificacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGetTempoDePublicacao() {
		getTempoDePublicacao = DateUtil.getTempoEntreDatasPorExtenso(dtNotificacao, new Date());
		return getTempoDePublicacao;
	}

	public void setGetTempoDePublicacao(String getTempoDePublicacao) {
		this.getTempoDePublicacao = getTempoDePublicacao;
	}

	public boolean isFlRespondeu() {
		return flRespondeu;
	}

	public void setFlRespondeu(boolean flRespondeu) {
		this.flRespondeu = flRespondeu;
	}

	public String getMensagemRespondida() {
		return mensagemRespondida;
	}

	public void setMensagemRespondida(String mensagemRespondida) {
		this.mensagemRespondida = mensagemRespondida;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
