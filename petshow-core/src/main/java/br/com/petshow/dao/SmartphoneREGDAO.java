package br.com.petshow.dao;



import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.petshow.model.SmartphoneREG;
import br.com.petshow.util.IDUtil;

public class SmartphoneREGDAO extends SuperClassDAO<SmartphoneREG>{

	@Override
	public SmartphoneREG find(long codigo) {
		return manager.find(SmartphoneREG.class, codigo);
		
	}
	public SmartphoneREG consultaPorIDFacebook(long idFacebook)  {
		SmartphoneREG smartphoneREG= null;
		try{
			smartphoneREG = manager.createNamedQuery(SmartphoneREG.IDX_POR_FACEBOOK, SmartphoneREG.class).setParameter("idFacebook", idFacebook).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return smartphoneREG; 
	}
	
	public boolean deletePorIDFCM(long idUsuario,String idFCM) {
		String consulta ="delete from SMARTPHONE_REG where "+IDUtil.ID_USUARIO+"="+idUsuario+" and ID_SMARTPHONE_FCM='"+idFCM+"' ";
	
		Query query = manager.createNativeQuery(consulta);
		
		
		int retorno =query.executeUpdate();
		
		
		return retorno>0?true:false;
	}

	public boolean deletePorIDFCM(String idFCM) {
		String consulta ="delete from SMARTPHONE_REG where ID_SMARTPHONE_FCM='"+idFCM+"' ";
	
		Query query = manager.createNativeQuery(consulta);
		
		
		int retorno =query.executeUpdate();
		
		
		return retorno>0?true:false;
	}
}
