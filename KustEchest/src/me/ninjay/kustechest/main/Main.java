package me.ninjay.kustechest.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustechest.comandos.ComandoEchest;
import me.ninjay.kustechest.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("echest").setExecutor(new ComandoEchest());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
