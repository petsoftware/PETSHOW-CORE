package br.com.petshow.util;

public class WriteConsoleUtil {
	
	
	public static boolean isDebug = true;
	
	public static void write(String write) {
	
		if(isDebug){
			System.out.println(write);
		}
		
	}

}
