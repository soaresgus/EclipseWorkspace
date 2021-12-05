package me.ninjay.template.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.template.comandos.ComandoTemplate;
import me.ninjay.template.eventos.EventosTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("template").setExecutor(new ComandoTemplate());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
	}

}
