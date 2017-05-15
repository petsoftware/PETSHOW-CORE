package br.com.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.petshow.util.IDUtil;

@NamedQueries({ 
	@NamedQuery(name = Notificacao.IDX_POR_USUARIO, query = "FROM Notificacao n WHERE n.usuarioDestinatario.id = :idUsuario  and flExcluida =false order by dtNotificacao desc")
   
})


@Entity
@Table(name = "NOTIFICACAO",indexes = { @Index(name = Notificacao.IDX_POR_USUARIO, columnList = "ID_USUARIO_DESTINATARIO,FL_EXCLUIDA") })
public class Notificacao  extends Entidade {

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
	private boolean flEnviada;
	
	@Column(name = "FL_LIDA")
	private boolean flLida;
	
	@Column(name = "FL_EXCLUIDA")
	private boolean flExcluida;
	
	@Column(name = "TP_NOTIFICACAO")
	private String tpNotificacao;
	
	@Column(name = "MSG_NOTIFICACAO")
	private String msgNotificacao;

	
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
	
	
	
	
}
