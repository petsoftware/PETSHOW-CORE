package br.com.petshow.role;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.core.jobs.JobCadMunicipiosCeara;
import br.com.petshow.core.jobs.JobCadMunicipiosMaranhao;
import br.com.petshow.core.jobs.JobCadMunicipiosParaiba;
import br.com.petshow.core.jobs.JobCadMunicipiosPernambuco;
import br.com.petshow.core.jobs.JobCadMunicipiosPiaui;
import br.com.petshow.core.jobs.JobCadMunicipiosSaoPaulo;
import br.com.petshow.dao.CidadeDAO;
import br.com.petshow.enums.EnumUF;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Cidade;
import br.com.petshow.util.ValidationUtil;



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
	
	public void inserirCidadesSPJob() {
		for (String mun : JobCadMunicipiosSaoPaulo.getMunicipios()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.SP.getCdIbge()+ municipio[0];
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.SP);
			this.cidadeDAO.insert(cidade);
		}
	}
	
	public void inserirCidadesMAJob() {
		for (String mun : JobCadMunicipiosMaranhao.getMunicipios()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.MA.getCdIbge()+ municipio[0];
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.MA);
			this.cidadeDAO.insert(cidade);
		}
	}
	
	public void inserirCidadesPIJob() {
		for (String mun : JobCadMunicipiosPiaui.getMunicipios()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.PI.getCdIbge()+ municipio[0];
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.PI);
			this.cidadeDAO.insert(cidade);
		}
	}
	
	public void inserirCidadesPBJob() {
		for (String mun : JobCadMunicipiosParaiba.getMunicipios()) {
			String[] municipio 	= mun.split(Pattern.quote("|"));
			Cidade cidade 		= new Cidade();
			String codCidade 	= ""+EnumUF.PB.getCdIbge()+ municipio[0].trim();
			cidade.setCodCidade(Long.parseLong(codCidade));
			cidade.setEstado(null);
			cidade.setNome(municipio[1].trim());
			cidade.setUf(EnumUF.PB);
			this.cidadeDAO.insert(cidade);
		}
	}
}
