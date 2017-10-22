package br.com.petshow.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumCor {
	
	AMARELO(0,"Amarelo"),
	BEGE(1,"Bege"),
	BRANCO(2,"Branco"),
	CARAMELO(3,"Caramelo"),
	CINZA(4,"Cinza"),
	CREME(5,"Creme"),
	MARRON(6,"Marron"),
	PRETO(7,"Preto");
	
	
	private int id;
	private String desc;
	
	
	EnumCor(int i,String desc){
		this.id=i;
		this.desc=desc;
	}
	
	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	public String toString(){
		return this.getDesc();
	}

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumCor e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumCor enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumCor e : values()) {
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
		for(EnumCor e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumCor getEnum(int id){
		for(EnumCor e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumCor getEnum(String descricao){
		for(EnumCor e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}

}
