package me.ninjay.safeclans.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safeclans.comandos.ComandoClan;
import me.ninjay.safeclans.eventos.EventosTemplate;
import me.ninjay.safeclans.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig playerClans;
	public static BukkitConfig clans;
	
	@Override
	public void onEnable() {
		getCommand("template").setExecutor(new ComandoClan());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		
		playerClans = new BukkitConfig("playerClans.yml", this);
		playerClans.saveConfig();
		
		clans = new BukkitConfig("Clans.yml", this);
		clans.saveConfig();
	}

}
