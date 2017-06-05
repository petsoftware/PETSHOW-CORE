package br.com.petshow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Bairro;
import br.com.petshow.model.Tratamento;


@Repository
public class TratamentoDAO  extends SuperClassDAO<Tratamento>{
	@Override
	public Tratamento find(long codigo) {
		// TODO Auto-generated method stub
		return manager.find(Tratamento.class, codigo);
	}
	
public List<Tratamento> consultaPorAnimal(long idAnimal)  {
		
		return manager.createNamedQuery(Tratamento.FIND_POR_ANIMAL).setParameter("idAnimal", idAnimal).getResultList();
	}
}


