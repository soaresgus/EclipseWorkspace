package me.ninjay.fashmining.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.fashmining.comandos.ComandoMinerios;
import me.ninjay.fashmining.eventos.EventosMinerios;
import me.ninjay.fashmining.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("minerios").setExecutor(new ComandoMinerios());
		Bukkit.getPluginManager().registerEvents(new EventosMinerios(), this);
		config = new BukkitConfig("minerios", this);
		config.saveConfig();
	}

}
