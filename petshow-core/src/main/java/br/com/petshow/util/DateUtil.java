package br.com.petshow.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.petshow.enums.EnumFrequenciaVermifugacao;

public class DateUtil {

	public static final int DAYS_OF_MONTH=30;
	public static final int DAYS_OF_QUARTER=91;
	public static final int DAYS_OF_HALF=182;
	public static final int DAYS_OF_YEARLY=365;

	public static final String  DD_MM_YYYY = "dd/MM/yyyy";
	/**
	 * FORMATO ddMMyyyy
	 */
	public static final String  DDMMYYYY = "ddMMyyyy";
	/**
	 * FORMATO yyyyMMdd
	 */
	public static final String  YYYYMMDD = "yyyyMMdd";
	
	public static Date addDays(Date date,int days){
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}

	 
	 public static int getDaysFrequenciaVermifugo (EnumFrequenciaVermifugacao enumF){
		 if(enumF == EnumFrequenciaVermifugacao.MENSAL){
			 return DAYS_OF_MONTH;
		 }else if(enumF == EnumFrequenciaVermifugacao.TRIMESTRAL){
			 return DAYS_OF_QUARTER;
		 }else if(enumF == EnumFrequenciaVermifugacao.SEMESTRAL){
			 return DAYS_OF_HALF;
		 }else if(enumF == EnumFrequenciaVermifugacao.ANUAL){
			 return DAYS_OF_YEARLY;
		 }
		 return 0;
	 }
	
	public static String dateTo_ddMMYYYY(Date date){
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public static Date addMonths(Date date,int months){
		int days = months*30;
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}

	public static String formatar(Date data, String formatoSaida)
	{
		if(data == null)
			return "";
		Locale locale = new Locale("pt","br");
		SimpleDateFormat dataFormato = new SimpleDateFormat (formatoSaida, locale);   
		String dataFormatada = dataFormato.format(data);
		return dataFormatada;
	}
}
