package me.ninjay.oneperfil.estruturas;

import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;

public class EventosAPI {
	
	public static Long getWinsMvP(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_mvp");
	}
	public static Long getWinsTcT(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_tct");
	}
	public static Long getWinsCxC(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_cxc");
	}
	public static Long getWinsGlad(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_glad");
	}
	public static Long getTotal(Player p, BukkitConfig config) {
		return getWinsMvP(p, config)+getWinsTcT(p, config)+getWinsCxC(p, config)+getWinsGlad(p, config);
	}
}
