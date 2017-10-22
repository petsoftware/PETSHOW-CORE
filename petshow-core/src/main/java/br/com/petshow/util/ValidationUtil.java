package br.com.petshow.util;

import java.security.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
/* 
 * 
 * TODAS AS VALIDACOES INDEPENDENTES DO NOME DO METODO DEVERÁ RETORNAR FALSE CASO SEJA INVALIDO E TRUE CASO ESTEJA VALIDADO, PARA EVITAR CONFUSOES
 */
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	
	
	public static boolean validarDtIniFin(Date dtInicial,Date dtFinal){
		if(dtInicial.getTime()>dtFinal.getTime()){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isCampoComValor(Object valor){
		if(valor==null){
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
	
	public static boolean isDateIquals(Date data1,Timestamp data2){
		return isDateIquals(data1.getTime(), data2.getTimestamp().getTime());
	}

	public static boolean isDateIquals(Date data1,Date data2){
		return isDateIquals(data1.getTime(), data2.getTime());
	}

	public static boolean isDateIquals(Timestamp data1,Timestamp data2){
		return isDateIquals(data1.getTimestamp().getTime(), data2.getTimestamp().getTime());
	}

	public static boolean isDateIquals(Timestamp data1,Date data2){
		return isDateIquals(data1.getTimestamp().getTime(), data2.getTime());
	}
	
	public static boolean isDateIquals(long mili1,long mili2){
		if(mili1 != mili2){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isEmailValid(String email){
		
		Matcher  matcher = pattern.matcher(email);
	    
	    return matcher.matches();
	}
	
}
