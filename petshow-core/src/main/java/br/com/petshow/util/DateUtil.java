package br.com.petshow.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import br.com.petshow.enums.EnumFrequenciaVermifugacao;

public class DateUtil {

	public static final int DAYS_OF_MONTH=30;
	public static final int DAYS_OF_QUARTER=91;
	public static final int DAYS_OF_HALF=182;
	public static final int DAYS_OF_YEARLY=365;
	public static Date addDays(Date date,int days){
		
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}
	
	 public static String dateTo_ddMMYYYY(Date date){

        return new SimpleDateFormat("dd/MM/yyyy").format(date);
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
	
}
