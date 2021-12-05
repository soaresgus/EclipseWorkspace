package me.ninjay.factags.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.factags.eventos.EventosGerais;

public class Main extends JavaPlugin{
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Bukkit.getPluginManager().registerEvents(new EventosGerais(), this);
	}

	public static Main getInstance() {
		return instance;
	}
}
