package me.ninjay.onevender.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onevender.comandos.ComandoVender;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("vender").setExecutor(new ComandoVender());
		Bukkit.getPluginManager().registerEvents(new ComandoVender(), this);
	}

}
