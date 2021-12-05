package me.ninjay.oneperfil.estruturas;

import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;

public final class BlocosAPI {

	public static Long getBlocos(Player p, BukkitConfig config) {
		return config.getLong(p.getName());
	}
	public static void setBlocos(Player p, BukkitConfig config, Double blocos) {
		config.set(p.getName(), blocos);
		config.saveConfig();
	}
	public static void addBlocos(Player p, BukkitConfig config, Long blocos) {
		config.set(p.getName(), config.getLong(p.getName())+blocos);
		config.saveConfig();
	}
	public static void removeBlocos(Player p, BukkitConfig config, Long blocos) {
		config.set(p.getName(), config.getLong(p.getName())-blocos);
		config.saveConfig();
	}
	
}
