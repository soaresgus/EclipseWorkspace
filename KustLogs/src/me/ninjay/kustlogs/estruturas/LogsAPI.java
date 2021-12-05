package me.ninjay.kustlogs.estruturas;


import java.text.SimpleDateFormat;
import java.util.Date;

import me.ninjay.kustlogs.utils.BukkitConfig;

public class LogsAPI {
	
	public static void register(String nick, String registro, BukkitConfig config) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy.HH-mm");  
	    Date date = new Date();  
	    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
	    
		config.set(formatter2.format(date)+"."+nick, config.getInt(formatter2.format(date)+"."+nick)+1);
		config.set(formatter.format(date)+"."+nick+"."+config.getInt(formatter2.format(date)+"."+nick), registro);
		config.saveConfig();
		config.reloadConfig();
	}

}
