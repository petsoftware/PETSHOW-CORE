package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.SmartphoneREGDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.SmartphoneREG;
import br.com.petmooby.util.ValidationUtil;
@Transactional(propagation=Propagation.REQUIRED)
public class SmartphoneREGRole  extends SuperClassRole<SmartphoneREG> {

	@Autowired
	private SmartphoneREGDAO smartphoneREGDAO;
	
	@Override
	public SmartphoneREG insert(SmartphoneREG entidade) throws ExceptionValidation {
		return this.smartphoneREGDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.smartphoneREGDAO.delete(codigo);
		
	}

	@Override
	public SmartphoneREG update(SmartphoneREG entidade) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(entidade.getId())){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.smartphoneREGDAO.update(entidade);
	}

	@Override
	public SmartphoneREG find(long codigo) throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.smartphoneREGDAO.find(codigo);
		
	}
	public boolean deletePorIDFCM(long idUsuario,String idFCM) throws ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O codigo do usuario não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(idFCM)){
			throw new ExceptionValidation("O codigo do FCM não foi informado!");
		}
		return this.smartphoneREGDAO.deletePorIDFCM(idUsuario, idFCM);
	
	}
	
	public boolean deletePorIDFCM(String idFCM) throws ExceptionValidation{

		if(!ValidationUtil.isCampoComValor(idFCM)){
			throw new ExceptionValidation("O codigo do FCM não foi informado!");
		}
		return this.smartphoneREGDAO.deletePorIDFCM(idFCM);
	
	}
	public SmartphoneREG findFacebook(long codigo) throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo do facebook não foi informado!");
		}
		return this.smartphoneREGDAO.consultaPorIDFacebook(codigo);
		
	}

}
