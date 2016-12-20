package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.AnuncioDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Anuncio;
import br.com.petshow.model.Usuario;
import br.com.petshow.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class AnuncioRole extends SuperClassRole<Anuncio> {

	@Autowired
	private AnuncioDAO anuncioDAO;
	

	public Anuncio insert(Anuncio entidade) throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataInicial())){
			throw new ExceptionValidation("O campo de data inicial do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataVencimento())){
			throw new ExceptionValidation("O campo de data de final do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getFoto())){
			throw new ExceptionValidation("O campo de foto  do anuncio não foi informado!");
		}
		
		if(!ValidationUtil.validarDtIniFin(entidade.getDataInicial(), entidade.getDataVencimento())){
			throw new ExceptionValidation("Data inicial do anuncio deverá ser anterior ou igual a data final!");
		}
		
		return ((Anuncio)anuncioDAO.insert(entidade));
	}


	public void delete(long codigo) throws  ExceptionValidation,ExceptionNotFoundRecord {
		
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		this.anuncioDAO.delete(codigo);
	}

	public Anuncio find(long codigo)  throws  ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return anuncioDAO.find(codigo);
	}


	public Anuncio update(Anuncio entidade)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataInicial())){
			throw new ExceptionValidation("O campo de data inicial do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataVencimento())){
			throw new ExceptionValidation("O campo de data de final do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getFoto())){
			throw new ExceptionValidation("O campo de foto  do anuncio não foi informado!");
		}
		
		if(!ValidationUtil.validarDtIniFin(entidade.getDataInicial(), entidade.getDataVencimento())){
			throw new ExceptionValidation("Data inicial do anuncio deverá ser anterior ou igual a data final!");
		}

		return ((Anuncio)anuncioDAO.update(entidade));
	}
	
	public List<Anuncio> consultaPorUsuario(long idUsuario)  throws  ExceptionValidation{
		return this.anuncioDAO.consultaPorUsuario(idUsuario);
	}
	
}
