package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumFlAtivo {

	ATIVO(0),
	INATIVO(1);
	
	private final int id;
	private EnumFlAtivo(int id) {
		this.id = id;
	}
	
	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumFlAtivo e : values()) {
			retorno.add(e.toString());
		}
		return retorno;
	}
	public static int getId(EnumFlAtivo enumTp){
		int retorno = 0;
		int contador=0;
		for(EnumFlAtivo e : values()) {
			++contador;
			if(e.toString().equals(enumTp.toString())){
				retorno=contador;
			}
		}
		return retorno;
	}
	
	public static int getId(String valor){
		int retorno = 0;
		int contador=0;
		for(EnumFlAtivo e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;
	}
	
	public static EnumFlAtivo getEnum(int id){
		for(EnumFlAtivo e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumFlAtivo getEnum(String descricao){
		for(EnumFlAtivo e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}

	public int getId() {
		return id;
	}
}
