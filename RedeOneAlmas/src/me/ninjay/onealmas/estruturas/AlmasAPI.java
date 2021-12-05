package me.ninjay.onealmas.estruturas;

import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;

public class AlmasAPI {
	
	public static void setAlmas(Player p, BukkitConfig config, Long quantia) {
		config.set(p.getName(), quantia);
		config.saveConfig();
	}
	public static Long getAlmas(Player p, BukkitConfig config) {
		return config.getLong(p.getName());
	}
	public static void addAlmas(Player p, BukkitConfig config, Long quantia) {
		config.set(p.getName(), getAlmas(p, config)+quantia);
		config.saveConfig();
	}
	public static void removeAlmas(Player p, BukkitConfig config, Long quantia) {
		config.set(p.getName(), getAlmas(p, config)-quantia);
		config.saveConfig();
	}

}
