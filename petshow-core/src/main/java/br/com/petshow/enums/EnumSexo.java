package br.com.petshow.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumSexo {
	MACHO(0), 
	FEMEA(1);

	private final int id;
	EnumSexo(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public static List<String> toStringArray(){
		List<String> retorno = new ArrayList<String>();
		for(EnumSexo e : values()) {
			retorno.add(e.toString());
		}
		return retorno;
	}

	public static int getId(EnumSexo enumTp){
		int retorno = 0;
		int contador=0;
		for(EnumSexo e : values()) {
			++contador;
			if(e.toString().equals(enumTp.toString())){
				retorno=contador;
			}
		}
		return retorno;
	}

	public static EnumSexo getEnum(int id){
		for(EnumSexo e : values()) {
			if(e.getId() == id){
				return e;
			}
		}
		return null;

	}

	public static EnumSexo getEnum(String descricao){
		for(EnumSexo e : values()) {
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
	}
}
