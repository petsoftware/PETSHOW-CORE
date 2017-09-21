package br.com.petshow.dao;


import java.util.Date;
import java.util.List;

import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.model.Cidade;
import br.com.petshow.model.Racas;

public class RacaDao extends SuperClassDAO<Racas>{

	@Override
	public Racas find(long codigo) {
		return manager.find(Racas.class, codigo);
	}

	public List<Racas> consultaRacas(EnumTipoAnimal tipoAnimal)  {
		return manager.createNamedQuery( Racas.CONSULTA_TODAS).setParameter("tipoAnimal", tipoAnimal).getResultList();
	}
}
