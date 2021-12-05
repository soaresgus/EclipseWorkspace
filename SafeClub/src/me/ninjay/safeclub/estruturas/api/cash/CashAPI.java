package me.ninjay.safeclub.estruturas.api.cash;

import org.bukkit.entity.Player;

import me.ninjay.safeclub.utils.BukkitConfig;




public class CashAPI {

	/**
	 * API de cash pronta para o uso
	 * 
	 * @author Ninja
	 * @version 1.0
	 */

	public static int get(Player p, BukkitConfig config) {
		return config.getInt(p.getName());
	}

	public static void set(Player p, BukkitConfig config, int cash) {
		config.set(p.getName(), cash);
		config.saveConfig();
	}

	public static void add(Player p, BukkitConfig config, int cash) {
        config.set(p.getName(), get(p, config)+cash);
        config.saveConfig();
	}
	
	public static void remove(Player p, BukkitConfig config, int cash) {
		if(cash > get(p, config)) {
			p.sendMessage("§cQuantia maior da qual o jogador possui. Tente um número menor ou igual a "+get(p, config));
			return;
		}
		if(cash <= 0) {
			p.sendMessage("§cQuantia inválida, tente um número maior do que 0.");
			return;
		}
		config.set(p.getName(), get(p, config)-cash);
		config.saveConfig();
		
	}
		
	
	public static boolean has(Player p, BukkitConfig config, int cash) {
		return get(p, config)>=cash;
		
	}
	
}

