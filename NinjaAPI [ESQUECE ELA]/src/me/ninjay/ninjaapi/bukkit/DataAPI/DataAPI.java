package me.ninjay.ninjaapi.bukkit.DataAPI;

import java.time.LocalDateTime;

public class DataAPI {
	/**
	 * API de data pronta para o uso
	 * 
	 * @author Ninja
	 * @version 1.0
	 */
	public static LocalDateTime now = LocalDateTime.now(); 
	
	public static int getDia() { 
		return now.getDayOfMonth();
	}
	
	public static int getMes() {
		return now.getMonthValue();
	}
	
	public static int getAno() {
		return now.getYear();
	}
	
	public static int getHora() {
		return now.getHour();
	}
	
	public static int getMinuto() {
		return now.getMinute();
	}
	
	public static int getSegundo() {
		return now.getSecond();
	}
	
	public static String getCompostoDMA() {
		return getDia()+"/"+getMes()+"/"+getAno();
	}
	
	public static String getCompostoHMS() {
		return getHora()+":"+getMinuto()+":"+getSegundo();
	}

}
