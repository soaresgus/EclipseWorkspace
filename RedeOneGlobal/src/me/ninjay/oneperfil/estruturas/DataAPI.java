package me.ninjay.oneperfil.estruturas;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.oneperfil.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class DataAPI {

	public static String getData(Player p, BukkitConfig config) {
		return config.getString("Data");
	}
	public static void setData(Player p, BukkitConfig config) {
		LocalDateTime now = LocalDateTime.now(); 
		config.set("Data", now.getDayOfMonth()+"/"+now.getMonth().getValue()+"/"+now.getYear());
		config.saveConfig();
	}
	public static void setUltimoLogin(Player p, BukkitConfig config) {
		LocalDateTime now = LocalDateTime.now();
		config.set(p.getName()+"_ultimologin", now.getDayOfMonth()+"/"+now.getMonth().getValue()+"/"+now.getYear()+" | "+now.getHour()+":"+now.getMinute()+":"+now.getSecond());
	    config.saveConfig();
	}
	public static String getUltimoLogin(Player p, BukkitConfig config) {
		return config.getString(p.getName()+"_ultimologin");
	}
	public static void setTempoOnline(Player p, BukkitConfig config) {
	    new BukkitRunnable() {
			Long i = (long) DataAPI.getTempoOnline(p, config);
			@Override
			public void run() {
				i++;
				config.set(p.getName()+"_tempon", i);
				config.saveConfig();
			}
			
		}.runTaskTimer(Main.getPlugin(Main.class), 72000, 72000);
	}
	public static Long getTempoOnline(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_tempon");
	}
	
}
