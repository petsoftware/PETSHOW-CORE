package br.com.petshow.role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.VendaDAO;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Usuario;
import br.com.petshow.model.Venda;
import br.com.petshow.objects.query.VendasQuery;
import br.com.petshow.util.FileUtil;
import br.com.petshow.util.ValidationUtil;
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
		List<String>listFotosTmp = entidade.getFotos();
		entidade.setFotos(null);
		entidade = this.vendaDAO.insert(entidade);
		List<String>listOfPaths = new ArrayList<>();
		for (String foto : listFotosTmp) {
			String path = FileUtil.saveCertificateOnFileSystem(entidade, foto);
			listOfPaths.add(path);
		}
		entidade.setFotos(listOfPaths);
		entidade = update(entidade);
		return entidade;
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
		Venda venda = this.vendaDAO.find(codigo);
		//setUrlPhoto(venda);
		return venda;
	}
	
	public List<Venda> consultaPorUsuario(long id)  throws  ExceptionValidation{
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O código não foi informado!");
		}
		List<Venda> vendas = this.vendaDAO.consultaPorUsuario(id);
		//extractVendasWithURL(vendas);
		return vendas;
	}


//	private void extractVendasWithURL(List<Venda> vendas) {
//		for (Venda venda : vendas) {
//			setUrlPhoto(venda);
//		}
//	}
//
//
//	private void setUrlPhoto(Venda venda) {
//		List<String> fotos = venda.getFotos();
//		List<String> photosToShow = new ArrayList<>();
//		for (String foto : fotos) {
//			foto = RoleParametros.paramSiteBaseUrl+foto;
//			photosToShow.add(foto);
//		}
//		venda.setFotos(photosToShow);
//	}
	
	public List<Venda> consultaVendasFiltros(String palavraChave,long idCidade,long idEstado,int limiteRegistros)  throws  ExceptionValidation{
		
		return this.vendaDAO.vendas(palavraChave, idCidade, idEstado,limiteRegistros);
	}

	public long numeroDeVendasRegistradasNoSistema(Usuario usuario) {
		return vendaDAO.numeroDeVendasRegistradoNoSistema(usuario);
	}
	
	public List<Venda> consultarVendas(VendasQuery query) {
		List<Venda> consultarVendas = vendaDAO.consultarVendas(query);
		//extractVendasWithURL(consultarVendas);
		return consultarVendas;
	}

	
	
}
