package br.com.petmooby.dao;


import java.util.Date;
import java.util.List;

import br.com.petmooby.enums.EnumTipoAnimal;
import br.com.petmooby.model.Cidade;
import br.com.petmooby.model.Racas;

public class RacaDao extends SuperClassDAO<Racas>{

	@Override
	public Racas find(long codigo) {
		return manager.find(Racas.class, codigo);
	}

	public List<Racas> consultaRacas(EnumTipoAnimal tipoAnimal)  {
		return manager.createNamedQuery( Racas.CONSULTA_TODAS).setParameter("tipoAnimal", tipoAnimal).getResultList();
	}
}
