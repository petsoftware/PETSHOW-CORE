package br.com.petshow.util;

import java.util.Date;

public class ValidationUtil {
/* 
 * TODAS AS VALIDACOES INDEPENDENTES DO NOME DO METODO DEVERÁ RETORNAR FALSE CASO SEJA INVALIDO E TRUE CASO ESTEJA VALIDADO, PARA EVITAR CONFUSOES
 */ 
	
	
	public static boolean validarDtIniFin(Date dtInicial,Date dtFinal){
		if(dtInicial.getTime()>dtFinal.getTime()){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isCampoComValor(int valor){
		if(valor==0){
			return false;
		}else{
			return true;
		}
	}
	public static boolean isCampoComValor(String valor){
		if(valor== null || valor.trim().equals("")){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isCampoComValor(long valor){
		if(valor==0){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isCampoComValor(Date valor){
		if(valor == null || valor.getTime()==0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
