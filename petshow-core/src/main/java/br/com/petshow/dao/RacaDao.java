package br.com.petshow.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.model.Racas;

@Repository
public class RacaDao extends SuperClassDAO<Racas>{

	public RacaDao() {
	}
	@Override
	public Racas find(long codigo) {
		return manager.find(Racas.class, codigo);
	}

	public List<Racas> consultaRacas(EnumTipoAnimal tipoAnimal)  {
		return manager.createNamedQuery( Racas.CONSULTA_TODAS).setParameter("tipoAnimal", tipoAnimal).getResultList();
	}
}
