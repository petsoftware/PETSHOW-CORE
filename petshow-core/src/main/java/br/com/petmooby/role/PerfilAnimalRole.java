package br.com.petmooby.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.dao.PerfilAnimalDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.PerfilAnimal;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
public class PerfilAnimalRole extends SuperClassRole<PerfilAnimal> {

	@Autowired
	private PerfilAnimalDAO perfilAnimalDAO ;

	public PerfilAnimal insert(PerfilAnimal entidade) throws ExceptionValidation{
		
		return (PerfilAnimal) this.perfilAnimalDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.perfilAnimalDAO.delete(codigo);
	}

	
	public PerfilAnimal update(PerfilAnimal entidade) throws ExceptionValidation{
	
		return (PerfilAnimal) this.perfilAnimalDAO.update(entidade);
	}

	
	public PerfilAnimal find(long codigo) throws ExceptionValidation {
	
		return this.perfilAnimalDAO.find(codigo);
	}
	

}
