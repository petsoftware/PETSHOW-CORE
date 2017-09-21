package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.AnimalDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Animal;
import br.com.petshow.model.Tutor;
import br.com.petshow.util.ValidationUtil;

@Transactional
@Service
public class AnimalRole extends SuperClassRole<Animal> {

	@Autowired
	private AnimalDAO animalDAO;
	@Autowired
	private TutorRole tutorRole;
	
	public Animal insert(Animal animal) throws ExceptionValidation{
		validarAnimal(animal);
		return (Animal) this.animalDAO.insert(animal);
	}
	
	public Animal insert(Animal animal,Tutor tutor) throws ExceptionValidation{
		validarAnimal(animal);
		tutor.setAnimal(animal);
		tutorRole.insert(tutor);
		return insert(animal);
	}

	private void validarAnimal(Animal entidade) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(entidade.getNome())){
			throw new ExceptionValidation("O nome não foi informado!","nome");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getFlSexo())){
			throw new ExceptionValidation("O SEXO do animal não foi informado!","flSexo");
		}
		if(entidade.getTipo()==null){
			throw new ExceptionValidation("O tipo do animal não foi informado!","tipo");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataNascimento())){
			throw new ExceptionValidation("A data de nascimento não foi informada!","dataNascimento");
		}
	}


	@Override
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O id não foi informado!","id");
		}
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
