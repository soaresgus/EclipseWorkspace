package me.ninjay.picaretayoutuber.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.picaretayoutuber.comandos.ComandoDarPicareta;
import me.ninjay.picaretayoutuber.estruturas.ItensAPI;
import me.ninjay.picaretayoutuber.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("darpicareta").setExecutor(new ComandoDarPicareta());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new ItensAPI(), this);
		
		ItensAPI api = new ItensAPI();
		
		api.customRecipe();
	}
	
}
