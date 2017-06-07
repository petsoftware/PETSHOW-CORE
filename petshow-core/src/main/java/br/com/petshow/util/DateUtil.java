package br.com.petshow.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


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

	public static Date addMonths(Date date,int months){


		int days = months*30;
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DAY_OF_MONTH,days);
		date = c.getTime();
		return date;
	}

}
