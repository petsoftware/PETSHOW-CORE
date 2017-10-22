package br.com.petshow.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoClassificado {
	PRODUTO(0), 
	SERVIÇO(1);

	private final int id;
	EnumTipoClassificado(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public static List<String> toStringArray(){
		List<String> retorno = new ArrayList<String>();
		for(EnumTipoClassificado e : values()) {
			retorno.add(e.toString());
		}
		return retorno;
	}

	public static int getId(EnumTipoClassificado enumTp){
		int retorno = 0;
		int contador=0;
		for(EnumTipoClassificado e : values()) {
			++contador;
			if(e.toString().equals(enumTp.toString())){
				retorno=contador;
			}
		}
		return retorno;
	}

	public static EnumTipoClassificado getEnum(int id){
		for(EnumTipoClassificado e : values()) {
			if(e.getId() == id){
				return e;
			}
		}
		return null;

	}

	public static EnumTipoClassificado getEnum(String descricao){
		for(EnumTipoClassificado e : values()) {
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
	}
}
