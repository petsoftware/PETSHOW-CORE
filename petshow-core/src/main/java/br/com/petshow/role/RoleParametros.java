package br.com.petshow.role;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petshow.dao.DAOParametros;
import br.com.petshow.exceptions.ExceptionNotFoundRecord;
import br.com.petshow.model.Parametros;


@Service
public class RoleParametros extends SuperClassRole<Parametros> {
	public static final int KEY_REPO_FILES	 		        = 1;
	public static final int KEY_SITE_BASE_URL 		        = 2;
	//----------------------------------------------------------------------------------------
	//Os parametros serao carregados em memória para evitar inumeros acessos ao bando de dados
	//----------------------------------------------------------------------------------------
	public static String paramRepoFiles		 		    = "";
	public static String paramSiteBaseUrl	 		    = "";
	//----------------------------------------------------------------------------------------
	public static String patterSeparator = Pattern.quote("|");
	public static String defaultSeparator = "|";
	
	public RoleParametros() {
		System.out.println(this.getClass().getName());
	}
	@Autowired
	private DAOParametros daoParametros;
	@Override
	public Parametros insert(Parametros entidade) {
		return daoParametros.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord {
		daoParametros.delete(codigo);
	}

	@Override
	public Parametros update(Parametros entidade) {
		return daoParametros.update(entidade);
	}

	@Override
	public Parametros find(long codigo) {
		return daoParametros.find(codigo);
	}
	
	public Parametros getParametroByChave(int chave) {
		Parametros parametros = this.daoParametros.getParametroByChave(chave);
		if(parametros != null){
			return parametros;
		}else{
			return new Parametros();
		}
	}
	
	/**
	 * 
	 */
	public void loadParametersFromDatabaseToMemory() {
		paramRepoFiles 		= getParametroByChave(KEY_REPO_FILES).getValor();
		paramSiteBaseUrl    = getParametroByChave(KEY_SITE_BASE_URL).getValor();
	}

}
