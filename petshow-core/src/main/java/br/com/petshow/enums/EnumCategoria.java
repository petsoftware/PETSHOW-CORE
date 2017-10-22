package br.com.petshow.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumCategoria {

	ACESSORIOS_ADESTRAMENTO(10,"Acessórios para Adestramento e Comportamento",EnumTipoClassificado.PRODUTO),
	ACESSORIOS_ALIMENTACAO(3,"Acessórios para alimentação",EnumTipoClassificado.PRODUTO),
	ANTIPULGA(1,"Antipulgas e Anticarrapatos",EnumTipoClassificado.PRODUTO),
	OSSOS(2,"Ossinhos e Petiscos",EnumTipoClassificado.PRODUTO),
	BRINQUEDO(6,"Brinquedos",EnumTipoClassificado.PRODUTO),
	CAIXAS_TRANSPORTE(9,"Caixas e Bolsas de transporte",EnumTipoClassificado.PRODUTO),
	CAMINHA_CASINHA(7,"Caminha e casinha",EnumTipoClassificado.PRODUTO),
	COLEIRAS(8,"Coleiras, Guias e Peitorais",EnumTipoClassificado.PRODUTO),
	HIGIENE_BELEZA(5,"Higiene e Beleza",EnumTipoClassificado.PRODUTO),
	RACOES(13,"Rações",EnumTipoClassificado.PRODUTO),
	ROUPAS_ACESSORIOS(11,"Roupas e Acessórios",EnumTipoClassificado.PRODUTO),
	SAUDE_REMEDIO(4,"Saúde e Rémedios",EnumTipoClassificado.PRODUTO),
	OUTROS_PRODUTO(12,"Outros",EnumTipoClassificado.PRODUTO),
	ADESTRAMENTO(15,"Adestramento",EnumTipoClassificado.SERVIÇO),
	EXAMES(14,"Exames e Consultas",EnumTipoClassificado.SERVIÇO),
	WALKER(17,"Dog Walker",EnumTipoClassificado.SERVIÇO),
	HOSPEDAGEM_DOMICILIO(18,"Hospedagem em Domicílio",EnumTipoClassificado.SERVIÇO),
	HOTEL(16,"Hotel",EnumTipoClassificado.SERVIÇO),
	OUTROS_CLASSIFICADO(18,"Outros",EnumTipoClassificado.SERVIÇO);
	
	
	
	private int id;
	
	private String descricao;
	
	private EnumTipoClassificado tpClassificado;

	private EnumCategoria(int id, String descricao, EnumTipoClassificado tpClassificado) {
		this.id = id;
		this.descricao = descricao;
		this.tpClassificado = tpClassificado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumTipoClassificado getTpClassificado() {
		return tpClassificado;
	}

	public void setTpClassificado(EnumTipoClassificado tpClassificado) {
		this.tpClassificado = tpClassificado;
	}
	
	
	private List<EnumCategoria> getListEnum(EnumTipoClassificado tpClassificado){
		
		EnumCategoria[] all = EnumCategoria.values();
		
		List<EnumCategoria> retorno = new ArrayList<EnumCategoria>();
		
		for(EnumCategoria en:all){
			if(en.getTpClassificado() == tpClassificado){
				retorno.add(en);
			}
		}
		
		return retorno;
	}

	public static List<String> toStringArray(){

		List<String> retorno = new ArrayList<String>();
		for(EnumCategoria e : values()) {
			retorno.add(e.toString());
		}
		return retorno;


	}
	public static int getId(EnumCategoria enumTp){

		int retorno = 0;
		int contador=0;
		for(EnumCategoria e : values()) {
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
		for(EnumCategoria e : values()) {
			++contador;
			if(e.toString().equals(valor)){
				retorno=contador;
			}
		}
		return retorno;


	}
	
	public static EnumCategoria getEnum(int id){
		for(EnumCategoria e : values()) {
			
			if(e.getId() == id){
				return e;
			}
		}
		return null;
		
	}
	public static EnumCategoria getEnum(String descricao){
		for(EnumCategoria e : values()) {
			
			if(e.toString().equals(descricao)){
				return e;
			}
		}
		return null;
		
	}
	
}
