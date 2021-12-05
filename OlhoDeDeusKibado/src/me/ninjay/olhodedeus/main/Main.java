package me.ninjay.olhodedeus.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.olhodedeus.comandos.ComandoDarOlho;
import me.ninjay.olhodedeus.eventos.EventosOlho;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("darolho").setExecutor(new ComandoDarOlho());
		Bukkit.getPluginManager().registerEvents(new EventosOlho(), this);
	}

}
