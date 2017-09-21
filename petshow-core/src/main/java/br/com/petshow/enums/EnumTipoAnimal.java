package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumTipoAnimal {
	
	CACHORRO(0),
	GATO(1),
	PASSARO(2),
	CAVALO(3),
	COBRA(4),
	PEIXE(5),
	LAGARTO(6),
	SUINO(7),
	OUTROS(8);
	
	private int id;
	
	
	EnumTipoAnimal(int i){
		this.id=i;
	}
	
	public int getId() {
		return id;
	}

	

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumTipoAnimal e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumTipoAnimal enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumTipoAnimal e : values()) {
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
		for(EnumTipoAnimal e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumTipoAnimal getEnum(int id){
		for(EnumTipoAnimal e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumTipoAnimal getEnum(String descricao){
		for(EnumTipoAnimal e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}


}
