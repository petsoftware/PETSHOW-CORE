package br.com.petshow.dao;

import org.springframework.stereotype.Repository;

import br.com.petshow.model.Foto;
@Repository
public class FotoDAO extends SuperClassDAO<Foto> {

	public FotoDAO() {
	
	}
	
	@Override
	public Foto find(long codigo){
		// TODO Auto-generated method stub
		return null;
	}

}
