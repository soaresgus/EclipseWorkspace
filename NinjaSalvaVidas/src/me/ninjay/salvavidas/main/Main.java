package me.ninjay.salvavidas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.salvavidas.comandos.ComandoGive;
import me.ninjay.salvavidas.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("givesv").setExecutor(new ComandoGive());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
