package me.ninjay.kustyoutuber.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustyoutuber.comandos.ComandoYoutuber;
import me.ninjay.kustyoutuber.eventos.EventosTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("template").setExecutor(new ComandoYoutuber());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
	}

}
