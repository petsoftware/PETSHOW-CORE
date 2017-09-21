package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumPorteAnimal {

	PEQUENO(0),
	MEDIO(1),
	GRANDE(2);
	
	private int id;
	
	
	EnumPorteAnimal(int i){
		this.id=i;
	}
	
	public int getId() {
		return id;
	}

	

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumPorteAnimal e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumPorteAnimal enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumPorteAnimal e : values()) {
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
		for(EnumPorteAnimal e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumPorteAnimal getEnum(int id){
		for(EnumPorteAnimal e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumPorteAnimal getEnum(String descricao){
		for(EnumPorteAnimal e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}
}
