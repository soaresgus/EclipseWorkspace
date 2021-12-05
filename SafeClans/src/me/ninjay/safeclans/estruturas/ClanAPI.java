package me.ninjay.safeclans.estruturas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bukkit.entity.Player;

import me.ninjay.safeclans.main.Main;
import me.ninjay.safeclans.utils.BukkitConfig;

public class ClanAPI {
	
	public static BukkitConfig c = Main.clans;
	public static BukkitConfig pc = Main.playerClans;
	
	public static void criarClan(Player lider, String tag, String nome) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		c.set(tag+".tag", tag);
		c.set(tag+".nome", nome);
		c.set(tag+".membros", 1);
		c.set(tag+".lider", lider.getName());
		c.set(tag+".data", dtf.format(now));
		c.saveConfig();
	}

}
