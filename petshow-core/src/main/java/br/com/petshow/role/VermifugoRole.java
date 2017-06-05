package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.petshow.dao.VermifugoDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;

import br.com.petshow.model.Vermifugo;
import br.com.petshow.util.ValidationUtil;

@Service
public class VermifugoRole extends SuperClassRole<Vermifugo> {
	
	@Autowired
	private VermifugoDAO vermifugoDAO;

	@Override
	public Vermifugo insert(Vermifugo entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return (Vermifugo) this.vermifugoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.vermifugoDAO.delete(codigo);
		
	}

	@Override
	public Vermifugo update(Vermifugo entidade) throws ExceptionValidation {
		return (Vermifugo) this.vermifugoDAO.update(entidade);
	}

	@Override
	public Vermifugo find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.vermifugoDAO.find(codigo);
	}
	
	public List<Vermifugo> consultaPorAnimal(Long id)  throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.vermifugoDAO.consultaPorAnimal(id);
	}

}