package br.com.petmooby.enums;

import java.util.ArrayList;
import java.util.List;

/*	
 * 
 */

public enum EnumVacina {
		
	CPOLIVALENTE(1,"Polivalente V8/V10 1º DOSE",EnumTipoAnimal.CACHORRO,2),
	CPOLIVALENTE_R1(2,"Polivalente V8/V10 2º DOSE",EnumTipoAnimal.CACHORRO,3),
	CPOLIVALENTE_R2(3,"Polivalente V8/V10 3º DOSE",EnumTipoAnimal.CACHORRO,4),
	CPOLIVALENTE_ANUAL(4,"Polivalente Anual",EnumTipoAnimal.CACHORRO,4),
	CANTIRRABICA(5,"Antirrábica  1º DOSE",EnumTipoAnimal.CACHORRO,6),
	CANTIRRABICA_ANUAL(6,"Antirrábica Anual",EnumTipoAnimal.CACHORRO,6),
	CGRIPE_CANINA(7,"GRIPE  1º DOSE",EnumTipoAnimal.CACHORRO,8),
	CGRIPE_CANINA_R1(8,"GRIPE  2º DOSE",EnumTipoAnimal.CACHORRO,9),
	CGRIPE_CANINA_ANUAL(9,"GRIPE ANUAL",EnumTipoAnimal.CACHORRO,9),
	CGIARDIASE(10,"GIARDIA  1º DOSE",EnumTipoAnimal.CACHORRO,11),
	CGIARDIASE_R1(11,"GIARDIA 2º DOSE",EnumTipoAnimal.CACHORRO,12),
	CGIARDIASE_ANUAL(12,"GIARDIA ANUAL ",EnumTipoAnimal.CACHORRO,12),
	CLEISHMANIOSE(13,"CALAZAR 1º DOSE",EnumTipoAnimal.CACHORRO,14),
	CLEISHMANIOSE_R1(14,"CALAZAR 2º DOSE",EnumTipoAnimal.CACHORRO,15),
	CLEISHMANIOSE_R2(15,"CALAZAR 3º DOSE",EnumTipoAnimal.CACHORRO,16),
	CLEISHMANIOSE_ANUAL(16,"CALAZAR ANUAL",EnumTipoAnimal.CACHORRO,16);
	
	
	private int id;
	
	private String nome;
	
	private EnumTipoAnimal tp;
	
	private Integer idProxima;
	
	

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	
	public EnumTipoAnimal getTp() {
		return tp;
	}
	
	
	
	public Integer getIdProxima() {
		return idProxima;
	}

	private EnumVacina(int id, String nome, EnumTipoAnimal tp,Integer idProxima) {
		this.id = id;
		this.nome = nome;
		this.tp = tp;
		this.idProxima=idProxima;
	}
	
	public String toString(){
		return this.getNome();
	}

	private List<EnumVacina> getListEnum(EnumTipoAnimal tp){
		
		EnumVacina[] all = EnumVacina.values();
		
		List<EnumVacina> retorno = new ArrayList<EnumVacina>();
		
		for(EnumVacina en:all){
			if(en.getTp() == tp){
				retorno.add(en);
			}
		}
		
		return retorno;
	}

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumVacina e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumVacina enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumVacina e : values()) {
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
		for(EnumVacina e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumVacina getEnum(int id){
		for(EnumVacina e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumVacina getEnum(String descricao){
		for(EnumVacina e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}
	
	
	
}
