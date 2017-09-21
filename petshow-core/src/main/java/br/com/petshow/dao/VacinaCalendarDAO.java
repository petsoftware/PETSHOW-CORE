package br.com.petmooby.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.petmooby.model.VacinaCalender;

public class VacinaCalendarDAO extends SuperClassDAO<VacinaCalender> {

	public VacinaCalendarDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public VacinaCalender find(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<VacinaCalender> findAll() {
		try{
			Query qry = manager.createNamedQuery(VacinaCalender.FIND_ALL);
			return qry.getResultList();
		}catch(NoResultException e){
			return new ArrayList<VacinaCalender>();
		}
	}

}
