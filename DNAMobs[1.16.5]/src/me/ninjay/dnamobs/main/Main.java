package me.ninjay.dnamobs.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.dnamobs.comandos.ComandoDarItens;
import me.ninjay.dnamobs.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
