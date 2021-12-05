package me.ninjay.kustproteger.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustproteger.eventos.EventosGeral;
import me.ninjay.kustproteger.utils.BukkitConfig;


public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
	}

}
