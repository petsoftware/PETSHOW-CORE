package br.com.petmooby.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petmooby.dao.AmigoDAO;
import br.com.petmooby.exceptions.ExceptionNotFoundRecord;
import br.com.petmooby.exceptions.ExceptionValidation;
import br.com.petmooby.model.Amigo;
import br.com.petmooby.model.Usuario;
import br.com.petmooby.util.ValidationUtil;

public class AmigoRole  extends SuperClassRole<Amigo> {

	@Autowired
	private AmigoDAO amigoDAO;
	
	
	@Override
	public Amigo insert(Amigo entidade) throws ExceptionValidation {

		if(!ValidationUtil.isCampoComValor(entidade.getAmigo())){
			throw new ExceptionValidation("O amigo não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(entidade.getUsuario())){
			throw new ExceptionValidation("O usuario não foi informado!");
		}
		
		return (Amigo) this.amigoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo) throws ExceptionNotFoundRecord, ExceptionValidation {
		this.amigoDAO.delete(codigo);
		
	}

	@Override
	public Amigo update(Amigo entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo find(long codigo) throws ExceptionValidation {
		return this.amigoDAO.find(codigo);
	}

	
	public HashMap<String,Object> getAmigos(long idUsuario)  throws ExceptionValidation {
		
		List<Object[]> lista=this.amigoDAO.listaAmigos(idUsuario);
					
		HashMap<String,Object> retorno  = new HashMap<String,Object>();
		
		ArrayList<HashMap<String,Object>> retornoListaAmigo = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String,Object> amigo =null;
		long ultimoAmigo=0;
		for(Object [] linha:lista){
								
			if(ultimoAmigo!= Long.parseLong(linha[1].toString())){
				if(ultimoAmigo !=0){
					retornoListaAmigo.add(amigo);
				}
						
				ultimoAmigo= Long.parseLong(linha[1].toString());
				amigo = new HashMap<String,Object>();
				amigo.put("uNome", linha[0].toString());
				amigo.put("uID", linha[1].toString());
				amigo.put("uFoto", linha[2].toString());
				amigo.put("animais", new ArrayList<HashMap<String,String>>());
				
			}
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("aFoto", linha[3].toString());
			map.put("aTp", linha[4].toString());
			((ArrayList<HashMap<String,String>>)amigo.get("animais")).add(map);
			
		}
		
		if(amigo!=null){
			retornoListaAmigo.add(amigo);
		}
		
		
		retorno.put("listaAmigo",retornoListaAmigo);
		
		
		
		
		return retorno;
		
		
		
		
		
		
	}
	
	public Amigo findAmigo(long idUsuario,long idAmigo) throws ExceptionValidation {
		
		if(!ValidationUtil.isCampoComValor(idUsuario)){
			throw new ExceptionValidation("O id do usuario não foi informado!");
		}
		if(!ValidationUtil.isCampoComValor(idAmigo)){
			throw new ExceptionValidation("O id do amigo não foi informado!");
		}
		
		return this.amigoDAO.findAmigo(idUsuario, idAmigo);
	}
}
