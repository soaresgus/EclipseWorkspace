package me.ninjay.ninjatesouros.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjatesouros.comandos.ComandoTesouro;
import me.ninjay.ninjatesouros.eventos.EventosTemplate;
import me.ninjay.utils.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("tesouro").setExecutor(new ComandoTesouro());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
	}

}
