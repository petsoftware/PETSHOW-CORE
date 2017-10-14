package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.core.jobs.JobCadRacas;
import br.com.petshow.dao.RacaDao;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Racas;
import br.com.petshow.util.ValidationUtil;

@Service
public class RacasRole extends SuperClassRole<Racas> {
	public RacasRole() {
		System.out.println("Auto-generated constructor stub RacasRole");
	}
	@Autowired
	private RacaDao racaDao;
	
	public Racas find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.racaDao.find(codigo);
	}

	
	

	public List<Racas> consultaRacas(EnumTipoAnimal tpAnimal)  throws ExceptionValidation {
		return this.racaDao.consultaRacas( tpAnimal);
	}




	@Override
	public Racas insert(Racas entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Racas update(Racas entidade) throws ExceptionValidation {
		return null;
	}
	
	public void inserirRacasDeCachorro() {
		Racas racas = null;
		for (String raca : JobCadRacas.getRacasCachorro()) {
			try{
				racas = new Racas();
				racas.setDescricao(raca.trim());
				racas.setTipoAnimal(EnumTipoAnimal.CACHORRO);
				racaDao.insert(racas);
			}finally{
				racas = null;
			}
			
		}
	}
	
	public void inserirRacasDeGato() {
		Racas racas = null;
		for (String raca : JobCadRacas.getRacasGato()) {
			try{
				racas = new Racas();
				racas.setDescricao(raca.trim());
				racas.setTipoAnimal(EnumTipoAnimal.GATO);
				racaDao.insert(racas);
			}finally{
				racas = null;
			}
			
		}
	}
	
	public void inserirRacasDeCavalo() {
		Racas racas = null;
		for (String raca : JobCadRacas.getRacasDeCavalo()) {
			try{
				racas = new Racas();
				racas.setDescricao(raca.trim());
				racas.setTipoAnimal(EnumTipoAnimal.CAVALO);
				racaDao.insert(racas);
			}finally{
				racas = null;
			}
			
		}
	}
	
	public void inserirRacasDePassaro() {
		Racas racas = null;
		for (String raca : JobCadRacas.getRacasDePassaro()) {
			try{
				racas = new Racas();
				racas.setDescricao(raca.trim());
				racas.setTipoAnimal(EnumTipoAnimal.PASSARO);
				racaDao.insert(racas);
			}finally{
				racas = null;
			}
			
		}
	}

}
