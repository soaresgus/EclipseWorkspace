package me.ninjay.ninjakitpvp.estruturas;

import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.main.Main;
import me.ninjay.ninjakitpvp.utils.BukkitConfig;

public class LocationsAPI {
	
	public static void setLocation(Player p, String nome) {
		Main.locations.set(nome, p.getLocation());
		Main.locations.saveConfig();
		Main.locations.reloadConfig();
		p.sendMessage("§aLocal §6"+nome+" §afoi setado com sucesso !");
	}
	
	public static void tpLocation(Player p, String nome) {
		p.teleport(Main.locations.getLocation(nome));
	}
	
	public static BukkitConfig getConfig() {
		return Main.locations;
	}

}
