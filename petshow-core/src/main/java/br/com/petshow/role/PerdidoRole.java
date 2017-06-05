package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.PerdidoDAO;
import br.com.petshow.dao.TutorDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Adocao;
import br.com.petshow.model.Perdido;
import br.com.petshow.model.Servico;
import br.com.petshow.model.Tutor;
import br.com.petshow.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class PerdidoRole extends SuperClassRole<Perdido> {
	@Autowired
	private PerdidoDAO perdidoDAO;


	public Perdido insert(Perdido entidade) throws ExceptionValidation{
		
		return (Perdido) this.perdidoDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
	
		 this.perdidoDAO.delete(codigo);
	}

	
	public Perdido update(Perdido entidade) throws ExceptionValidation{
	
		return (Perdido) this.perdidoDAO.update(entidade);
	}

	
	public Perdido find(long codigo) throws ExceptionValidation {
	
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.perdidoDAO.find(codigo);
	}

	public List<Perdido> consultaPorFiltros(String tpAnimal,String tpPerdidoAchado,long estado,long cidade,long bairro, int limiteRegistros)   throws ExceptionValidation {
		return this.perdidoDAO.consultaPorFiltros(tpAnimal, tpPerdidoAchado, estado, cidade, bairro,limiteRegistros);
	}
	
	public List<Perdido> consultaPorUsuario(Long id)  throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.perdidoDAO.consultaPorUsuario(id);
	}
}
