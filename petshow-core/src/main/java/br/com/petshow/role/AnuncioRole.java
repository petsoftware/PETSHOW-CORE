package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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
		
		// No futuro deverá passar diretamente o codigo da foto
		
		Anuncio verFoto = this.find(entidade.getId());
		
		entidade.setFoto(verFoto.getFoto());
		
		
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataInicial())){
			throw new ExceptionValidation("O campo de data inicial do anuncio não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataVencimento())){
			throw new ExceptionValidation("O campo de data de final do anuncio não foi informado!");
		}
		
		
		if(!ValidationUtil.validarDtIniFin(entidade.getDataInicial(), entidade.getDataVencimento())){
			throw new ExceptionValidation("Data inicial do anuncio deverá ser anterior ou igual a data final!");
		}

		return ((Anuncio)anuncioDAO.update(entidade));
	}
	
	public List<Anuncio> consultaPorUsuario(long idUsuario)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.anuncioDAO.consultaPorUsuario(idUsuario);
	}
	
	public long numeroDeAnunciosFeitos(Usuario usuario){
		return this.anuncioDAO.countAnunciosAtivos(usuario);
	}
	
}
