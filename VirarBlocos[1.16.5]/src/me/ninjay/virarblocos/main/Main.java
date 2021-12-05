package me.ninjay.virarblocos.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.virarblocos.comandos.ComandoDarItens;
import me.ninjay.virarblocos.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		getCommand("daritens").setExecutor(new ComandoDarItens());
	}
	

}
