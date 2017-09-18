package br.com.petmooby.role;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petmooby.core.jobs.JobCadMunicipiosCeara;
import br.com.petmooby.core.jobs.JobCadMunicipiosPernambuco;
import br.com.petmooby.dao.CidadeDAO;
import br.com.petmooby.enums.EnumUF;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Cidade;
import br.com.petmooby.util.ValidationUtil;



@Service
@Transactional
public class CidadeRole extends SuperClassRole<Cidade> {

	@Autowired
	private CidadeDAO cidadeDAO;
	
	public CidadeRole() {
		System.out.println("TODO Auto-generated constructor stub " );
	}
	
	
	
	public Cidade insert(Cidade entidade) throws ExceptionValidation {
	
		return null;
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		
		 
	}

	
	public Cidade find(long codigo) throws ExceptionValidation {
		
		return this.cidadeDAO.find(codigo);
	}

	
	public Cidade update(Cidade entidade) throws ExceptionValidation {
		
		return null;
		
	}
	
	public List<Cidade> consultaPorEstadoID(long id)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id do estado não foi informada!");
		}
		return this.cidadeDAO.consultaPorEstadoID(id);
	}
	public List<Cidade> consultaPorEstadoUF(String uf)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(uf)){
			throw new ExceptionValidation("A UF não foi informada!");
		}
		return this.cidadeDAO.consultaPorEstadoUF(uf);
	}
	
	public  List<Cidade> findAllByUF(EnumUF enumUF) {
		return this.cidadeDAO.findAllByUF(enumUF);
	}
	
	public void inserirCidadesCEJob() {
		for (String mun : JobCadMunicipiosCeara.getMunicipiosCE()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.CE.getCdIbge()+ municipio[0];
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.CE);
			this.cidadeDAO.insert(cidade);
		}
	}
	
	public void inserirCidadesPEJob() {
		for (String mun : JobCadMunicipiosPernambuco.getMunicipios()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.PE.getCdIbge()+ municipio[0];
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.PE);
			this.cidadeDAO.insert(cidade);
		}
	}
}
