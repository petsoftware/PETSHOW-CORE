package br.com.petmooby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.petmooby.util.IDUtil;


@NamedQueries({  
	@NamedQuery(name = SmartphoneREG.IDX_POR_FACEBOOK, query = "FROM SmartphoneREG s WHERE s.usuario.idFacebook = :idFacebook ")
   
})

@Entity
@Table(name = "SMARTPHONE_REG",indexes = { @Index(name = SmartphoneREG.IDX_POR_FACEBOOK, columnList = IDUtil.ID_USUARIO) })
public class SmartphoneREG  extends Entidade {

	public static final String IDX_POR_FACEBOOK 	= "SmartphoneREG_Facebook";
	
	@OneToOne
	@JoinColumn(name = IDUtil.ID_USUARIO  ,referencedColumnName=IDUtil.ID)
	private Usuario usuario;
	
	@Column(name="ID_SMARTPHONE_FCM")
	private String idSmartPhoneFCM;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getIdSmartPhoneFCM() {
		return idSmartPhoneFCM;
	}

	public void setIdSmartPhoneFCM(String idSmartPhoneFCM) {
		this.idSmartPhoneFCM = idSmartPhoneFCM;
	}
	
	
	

}
