package br.com.petmooby.role;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.VendaDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Usuario;
import br.com.petmooby.model.Venda;
import br.com.petmooby.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class VendaRole extends SuperClassRole<Venda> {

	@Autowired
	private VendaDAO vendaDAO;

	public Venda insert(Venda entidade) throws ExceptionValidation{
		
		entidade.setDataCadastro(new Date());
		entidade.setDataVencimento(entidade.getDataCadastro());
		
		if(!ValidationUtil.isCampoComValor(entidade.getDescResumida())){
			throw new ExceptionValidation("O campo de nome não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataVencimento())){
			throw new ExceptionValidation("A data de vencimento não foi informada!");
		}
		

		return (Venda) this.vendaDAO.insert(entidade);
	}

	
	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {
		
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		 this.vendaDAO.delete(codigo);
	}

	
	public Venda update(Venda entidade) throws ExceptionValidation{

		if(!ValidationUtil.isCampoComValor(entidade.getId())){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		

		Venda venda = vendaDAO.find(entidade.getId());
		if(venda==null){
			throw new ExceptionValidation("Venda informada não existe!");
		}
		
		
		
		
		if(!ValidationUtil.isDateIquals(venda.getDataCadastro(), entidade.getDataCadastro())){
			throw new ExceptionValidation("Data de cadastro não pode ser alterada!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDescResumida())){
			throw new ExceptionValidation("O campo de nome não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDataVencimento())){
			throw new ExceptionValidation("A data de vencimento não foi informada!");
		}
		return (Venda) this.vendaDAO.update(entidade);
	}

	
	public Venda find(long codigo) throws ExceptionValidation {
	
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.vendaDAO.find(codigo);
	}
	
	public List<Venda> consultaPorUsuario(long id)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.vendaDAO.consultaPorUsuario(id);
	}
	
	public List<Venda> consultaVendasFiltros(String palavraChave,long idCidade,long idEstado,int limiteRegistros)  throws  ExceptionValidation{
		
		return this.vendaDAO.vendas(palavraChave, idCidade, idEstado,limiteRegistros);
	}

	public long numeroDeVendasRegistradasNoSistema(Usuario usuario) {
		return vendaDAO.numeroDeVendasRegistradoNoSistema(usuario);
	}

	
}
