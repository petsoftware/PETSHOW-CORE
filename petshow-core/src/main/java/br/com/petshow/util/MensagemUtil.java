package br.com.petshow.util;

import br.com.petshow.enums.EnumSexo;
import br.com.petshow.model.Animal;

public class MensagemUtil {

	public static String getVogalSexo(EnumSexo sexo){
		if(sexo.equals(EnumSexo.MACHO)){
			return "o";
		}else if (sexo.equals(EnumSexo.FEMEA)){
			return "a";
		}
		return "";
	}
	public static String getVogalSexo(Animal animal){
		return  getVogalSexo(animal.getFlSexo());
	}
}

