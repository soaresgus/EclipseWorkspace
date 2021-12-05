package me.ninjay.oneperfil.estruturas;

import java.text.DecimalFormat;

import org.bukkit.entity.Player;

import me.ninjay.ninjaapi.utils.Mine;
import net.eduard.api.lib.BukkitConfig;

public class StatsAPI {
	
	public static Long getKills(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_kills");
	}
	public static Long getMortes(Player p, BukkitConfig config) {
		return config.getLong(p.getName()+"_mortes");
	}
	public static void setMortes(Player p, BukkitConfig config, Long quanto) {
		config.set(p.getName()+"_mortes", quanto);
		config.saveConfig();
	}
	public static void setKills(Player p, BukkitConfig config, Long quanto) {
		config.set(p.getName()+"_kills", quanto);
		config.saveConfig();
	}
	public static Double getKdr(Player p, BukkitConfig config) {
		DecimalFormat df = new DecimalFormat("#.##"); 
		return Mine.toDouble(df.format(Mine.toDouble(getKills(p, config)) / Mine.toDouble(getMortes(p, config))));
	}

}
