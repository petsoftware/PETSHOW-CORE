package br.com.petmooby.role;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmooby.dao.AgendamentoDAO;
import br.com.petmooby.dao.ServicoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Servico;
import br.com.petmooby.model.Usuario;
import br.com.petmooby.util.ValidationUtil;
/**
 * 
 * @author antoniorafael
 *
 */
@Service
public class ServicoRole extends SuperClassRole<Servico> {

	@Autowired
	private ServicoDAO servicoDAO;

	@Autowired
	private AgendamentoDAO agendamentoDAO;


	public Servico insert(Servico entidade) throws ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(entidade.getNmServico())){
			throw new ExceptionValidation("O campo de nome do serviço não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição do servico não foi informado!");
		}

		if(consultaPorNome(entidade.getUsuario().getId(),entidade.getNmServico()).size()>0 ){
			throw new ExceptionValidation("Já existe um serviço com o nome informado!");
		}
		return (Servico) this.servicoDAO.insert(entidade);
	}


	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord {


		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		if(this.agendamentoDAO.getAgendamentosPendentes(codigo,new Date()).size()>0){
			throw new ExceptionValidation("Serviço não pode ser excluido pois existem agendamentos pendentes!");
		}
		Servico servico = find(codigo);
		servico.setFlExcluido(true);
		update(servico);
	}


	public Servico update(Servico entidade) throws ExceptionValidation{

		if(!ValidationUtil.isCampoComValor(entidade.getNmServico())){
			throw new ExceptionValidation("O campo de nome do serviço não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getDescricao())){
			throw new ExceptionValidation("O campo de descrição do servico não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getId())){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return (Servico) this.servicoDAO.update(entidade);
	}


	public Servico find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.servicoDAO.find(codigo);
	}

	public List<Servico> consultaPorUsuario(long idUsuario)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		return this.servicoDAO.consultaPorUsuario(idUsuario);
	}

	public List<Servico>  consultaPorNome(long idUsuario,String nmServico)    throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(nmServico)){
			throw new ExceptionValidation("O nome do serviço não foi informado!");
		}
		return this.servicoDAO.consultaPorNome(idUsuario, nmServico);
	}

	public long numeroDeServicosAtivos(Usuario usuario) {
		return this.servicoDAO.numeroDeServicosAtivos(usuario);
	}

}
