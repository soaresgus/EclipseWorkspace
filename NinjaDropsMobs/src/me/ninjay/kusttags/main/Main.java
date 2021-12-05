package me.ninjay.kusttags.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kusttags.comandos.ComandoTemplate;
import me.ninjay.kusttags.eventos.EventosTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("template").setExecutor(new ComandoTemplate());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
	}

}
