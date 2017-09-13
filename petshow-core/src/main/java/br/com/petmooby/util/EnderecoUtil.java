package br.com.petmooby.util;

import java.util.ArrayList;


public class EnderecoUtil {

	private static ArrayList<String> estados;
	static{
		estados = new ArrayList<String>(); 
		estados.add("Acre");
		estados.add("Alagoas");
		estados.add("Amapá");
		estados.add("Amazonas");
		estados.add("Bahia");
		estados.add("Ceará");
		estados.add("Distrito Federal");
		estados.add("Espírito Santo");
		estados.add("Goiás");
		estados.add("Maranhão");
		estados.add("Mato Grosso");
		estados.add("Mato Grosso do Sul");
		estados.add("Minas Gerais");
		estados.add("Pará");
		estados.add("Paraíba");
		estados.add("Paraná");
		estados.add("Pernambuco");
		estados.add("Piauí");
		estados.add("Rio de Janeiro");
		estados.add("Rio Grande do Norte");
		estados.add("Rio Grande do Sul");
		estados.add("Rondônia");
		estados.add("Roraima");
		estados.add("Santa Catarina");
		estados.add("São Paulo");
		estados.add("Sergipe");
		estados.add("Tocantins");

	}
	public static ArrayList<String> getEstados() {
		return estados;
	}
	public static void setEstados(ArrayList<String> estados) {
		EnderecoUtil.estados = estados;
	}

	public static String getSigla(String nmEstado){


		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Acre"))){
			return "AC";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Alagoas"))){
			return "AL";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Amapá"))){
			return "AP";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Amazonas"))){
			return "AM";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Bahia"))){
			return "BA";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Ceará"))){
			return "CE";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Distrito Federal"))){
			return "DF";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Espírito Santo"))){
			return "ES";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Goiás"))){
			return "GO";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Maranhão"))){
			return "MA";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Mato Grosso"))){
			return "MT";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Mato Grosso do Sul"))){
			return "MS";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Minas Gerais"))){
			return "MG";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Pará"))){
			return "PA";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Paraíba"))){
			return "PB";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Paraná"))){
			return "PR";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Pernambuco"))){
			return "PE";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Piauí"))){
			return "PI";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Rio de Janeiro"))){
			return "RJ";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Rio Grande do Norte"))){
			return "RN";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Rio Grande do Sul"))){
			return "RS";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Rondônia"))){
			return "RO";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Roraima"))){
			return "RR";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Santa Catarina"))){
			return "SC";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("São Paulo"))){
			return "SP";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Sergipe"))){
			return "SE";
		}

		if(StringUtil.removerAcentos(nmEstado).equalsIgnoreCase(StringUtil.removerAcentos("Tocantins"))){
			return "TO";
		}

		return "";


	}


}
