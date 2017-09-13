package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumFrequenciaTratamento {

	H_3_3(1,"De 3 em 3 horas"),
	H_4_4(2,"De 4 em 4 horas"),
	H_6_6(3,"De 6 em 6 horas"),
	H_8_8(4,"De 8 em 8 horas"),
	H_12_12(5,"De 12 em 12 horas"),
	DIARIA(6,"Diario"),
	D_3_3(7,"De 3 em 3 dias"),
	D_5_5(8,"De 5 em 5 dias"),
	SEMANAL(9,"Semanal"),
	D_10_10(10,"De 10 em 10 dias"),
	D_15_15(11,"De 15 em 15 dias"),
	D_21_21(12,"De 21 em 21 dias"),
	MENSAL(13,"Mensal"),
	ETERNA_DIARIA(50,"Diaria sem termino"),
	ETERNA_SEMANAL(51,"Semanal sem termino"),
	ETERNA_QUINZENAL(52,"Quinzenal sem termino	"),
	ETERNA_MENSAL(53,"Mensal sem termino"),
	ETERNA_TRIMESTRAL(54,"Trimestral sem termino"),
	ETERNA_SEMESTRAL(55,"Semestral sem termino"),
	ETERNA_ANUAL(56,"Anual sem termino");
	
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
	private EnumFrequenciaTratamento(int id, String desc){
		this.id=id;
		this.desc=desc;
		
	}
	public String toString(){
		return this.getDesc();
	}
	

	

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumFrequenciaTratamento e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumFrequenciaTratamento enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumFrequenciaTratamento e : values()) {
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
		for(EnumFrequenciaTratamento e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumFrequenciaTratamento getEnum(int id){
		for(EnumFrequenciaTratamento e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumFrequenciaTratamento getEnum(String descricao){
		for(EnumFrequenciaTratamento e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}
	
	
	}


