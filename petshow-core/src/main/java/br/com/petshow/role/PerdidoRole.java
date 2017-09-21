package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.PerdidoDAO;
import br.com.petshow.enums.EnumAchadoPerdido;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Perdido;
import br.com.petshow.objects.query.PerdidoQuery;
import br.com.petshow.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
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

	public List<Perdido> consultaPorFiltros(String tpAnimal,EnumAchadoPerdido tpPerdidoAchado,long estado,long cidade,long bairro, int limiteRegistros)   throws ExceptionValidation {
		return this.perdidoDAO.consultaPorFiltros(tpAnimal, tpPerdidoAchado, estado, cidade, bairro,limiteRegistros);
	}
	
	public List<Perdido> consultaPorUsuario(Long id)  throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.perdidoDAO.consultaPorUsuario(id);
	}
	
	/**
	 * @author Rafael Rocha
	 * @return
	 */
	public List<Perdido> consultaAnimaisPerdidos(PerdidoQuery query)  {
		return this.perdidoDAO.consultaAnimaisPerdidos(query);
	}
}
