package me.ninjay.safecash.estruturas;


import org.bukkit.OfflinePlayer;

import me.ninjay.safecash.utils.BukkitConfig;


public class CashAPI {

	/**
	 * API de cash pronta para o uso
	 * 
	 * @author Ninja
	 * @version 1.0
	 */

	public static int get(OfflinePlayer p, BukkitConfig config) {
		return config.getInt(p.getName());
	}

	public static void set(OfflinePlayer p, BukkitConfig config, int cash) {
		config.set(p.getName(), cash);
		config.saveConfig();
	}

	public static void add(OfflinePlayer p, BukkitConfig config, int cash) {
        config.set(p.getName(), get(p, config)+cash);
        config.saveConfig();
	}
	
	public static void remove(OfflinePlayer p, BukkitConfig config, int cash) {
		if(cash > get(p, config)) {
			return;
		}
		if(cash <= 0) {
			return;
		}
		config.set(p.getName(), get(p, config)-cash);
		config.saveConfig();
		
	}
	
	public static boolean has(OfflinePlayer p, BukkitConfig config, int cash) {
		return get(p, config)>=cash;
		
	}
	
}

