package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.petmooby.model.Tratamento;




public enum EnumFrequenciaVermifugacao {

	MENSAL(1,"Mensal"),
	TRIMESTRAL(2,"Trimestral"),
	SEMESTRAL(3,"Semestral"),
	ANUAL(4,"Anual");


private int id;

private String desc;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
private EnumFrequenciaVermifugacao(int id, String desc){
	this.id=id;
	this.desc=desc;
	
}
public String toString(){
	return this.getDesc();
}




public static List<String> toStringArray(){

	List<String> retorno = new ArrayList<String>();
	for(EnumFrequenciaVermifugacao e : values()) {
		retorno.add(e.toString());
	}
	return retorno;


}
public static int getId(EnumFrequenciaVermifugacao enumTp){

	int retorno = 0;
	int contador=0;
	for(EnumFrequenciaVermifugacao e : values()) {
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
	for(EnumFrequenciaVermifugacao e : values()) {
		++contador;
		if(e.toString().equals(valor)){
			retorno=contador;
		}
	}
	return retorno;


}

public static EnumFrequenciaVermifugacao getEnum(int id){
	for(EnumFrequenciaVermifugacao e : values()) {
		
		if(e.getId() == id){
			return e;
		}
	}
	return null;
	
}
public static EnumFrequenciaVermifugacao getEnum(String descricao){
	for(EnumFrequenciaVermifugacao e : values()) {
		
		if(e.toString().equals(descricao)){
			return e;
		}
	}
	return null;
	
}
}
