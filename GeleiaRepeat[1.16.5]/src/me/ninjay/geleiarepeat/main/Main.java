package me.ninjay.geleiarepeat.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.geleiarepeat.comandos.ComandoCentro;
import me.ninjay.geleiarepeat.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("centro").setExecutor(new ComandoCentro());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		saveDefaultConfig();
	}

}
