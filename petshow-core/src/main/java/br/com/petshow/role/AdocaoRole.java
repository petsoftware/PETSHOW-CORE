package br.com.petshow.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshow.dao.AdocaoDAO;
import br.com.petshow.enums.EnumFaseVida;
import br.com.petshow.enums.EnumSexo;
import br.com.petshow.enums.EnumTipoAnimal;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.exceptions.ExceptionValidation;
import br.com.petshow.model.Adocao;
import br.com.petshow.model.Usuario;
import br.com.petshow.objects.query.AdocaoQuery;
import br.com.petshow.util.ValidationUtil;

@Service
@Transactional
public class AdocaoRole extends SuperClassRole<Adocao> {

	@Autowired
	private AdocaoDAO adocaoDAO;
	
	public AdocaoRole() {
		System.out.println("TODO Auto-generated constructor stub " );
	}
	
	public Adocao insert(Adocao entidade) throws ExceptionValidation {
		return this.adocaoDAO.insert(entidade);
	}

	public void delete(long codigo) throws ExceptionValidation,ExceptionNotFoundRecord  {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		 this.adocaoDAO.delete(codigo);
	}

	
	public Adocao find(long codigo) throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(codigo)){
			throw new ExceptionValidation("O codigo não foi informado!");
		}
		return this.adocaoDAO.find(codigo);
	}

	
	public Adocao update(Adocao entidade) throws ExceptionValidation {
		return this.adocaoDAO.update(entidade);
		
	}

	public List<Adocao> consultaAnimaisAdocao(long estado, long cidade, String tpAnimal, String fase, String sexo,int limiteRegistros)  throws ExceptionValidation {
		return this.adocaoDAO.consultaAnimaisAdocao(estado,  cidade,  tpAnimal,  fase, sexo, limiteRegistros);
	}
	
	public List<Adocao> consultaPorUsuario(Long id)  throws ExceptionValidation {
		if(!ValidationUtil.isCampoComValor(id)){
			throw new ExceptionValidation("O id não foi informado!");
		}
		return this.adocaoDAO.consultaPorUsuario(id);
	}
	
	public int numeroDeAdocoesDoUsuario(Usuario usuario) {
		return 0;
	}
	
	public List<Adocao> consultarAnimaisDisponíveisParaAdocao(AdocaoQuery query) {
		return adocaoDAO.consultarAnimaisDisponíveisParaAdocao(query);
	}
	
}
