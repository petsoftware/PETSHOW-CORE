package br.com.petshow.test.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class tttttt {
	
	public static void main(String[] args) {
		Date d1 = new Date(1504905321531L);
		
		Date d2 = new Date(1504906422918L);
		System.out.println(d2.getTime());
		long seconds = (d2.getTime()-d1.getTime())/1000;
		System.out.println("Segundos entre duas datas: " + seconds);
		calculateTime(seconds);
	}
	
	public static void calculateTime(long seconds) {
	    int day = (int) TimeUnit.SECONDS.toDays(seconds);
	    long hours = TimeUnit.SECONDS.toHours(seconds) -
	                 TimeUnit.DAYS.toHours(day);
	    long minute = TimeUnit.SECONDS.toMinutes(seconds) - 
	                  TimeUnit.DAYS.toMinutes(day) -
	                  TimeUnit.HOURS.toMinutes(hours);
	    long second = TimeUnit.SECONDS.toSeconds(seconds) -
	                  TimeUnit.DAYS.toSeconds(day) -
	                  TimeUnit.HOURS.toSeconds(hours) - 
	                  TimeUnit.MINUTES.toSeconds(minute);
	    System.out.println("Day " + day + " Hour " + hours + " Minute " + minute + " Seconds " + second);
	}

}
