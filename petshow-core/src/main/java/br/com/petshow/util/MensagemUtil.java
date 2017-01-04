package br.com.petshow.util;

import br.com.petshow.model.Animal;

public class MensagemUtil {

	public static String getVogalSexo(String sexo){
		if(sexo.equalsIgnoreCase("M")){
			return "o";
		}else if (sexo.equalsIgnoreCase("M")){
			return "a";
		}
		return "";
	}
	public static String getVogalSexo(Animal animal){
		return  getVogalSexo(animal.getFlSexo());
	}
}

