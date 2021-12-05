package me.ninjay.kustwatchdog.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustwatchdog.comandos.ComandoAutoClick;
import me.ninjay.kustwatchdog.comandos.ComandoKillAura;
import me.ninjay.kustwatchdog.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("killaura").setExecutor(new ComandoKillAura());
		getCommand("autoclick").setExecutor(new ComandoAutoClick());
		Bukkit.getPluginManager().registerEvents(new ComandoKillAura(), this);
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
