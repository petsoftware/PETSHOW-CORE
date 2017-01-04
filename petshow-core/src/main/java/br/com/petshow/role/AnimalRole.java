package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.AnimalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Agendamento;
import br.com.petshow.model.Animal;
import br.com.petshow.model.Anuncio;
import br.com.petshow.util.ValidationUtil;

@Transactional
@Service
public class AnimalRole extends SuperClassRole<Animal> {

	@Autowired
	private AnimalDAO animalDAO;
	
	
	public Animal insert(Animal entidade) throws ExceptionValidation{
	
		return (Animal) this.animalDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.animalDAO.delete(codigo);
	}

	
	public Animal update(Animal entidade) throws ExceptionValidation{
	
		return (Animal) this.animalDAO.update(entidade);
	}

	
	public Animal find(long codigo) throws ExceptionValidation {
	
		return this.animalDAO.find(codigo);
	}

	public List<Animal> consultaPorUsuario(long idUsuario)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.animalDAO.animaisPorDono(idUsuario);
	}
	
	

}
