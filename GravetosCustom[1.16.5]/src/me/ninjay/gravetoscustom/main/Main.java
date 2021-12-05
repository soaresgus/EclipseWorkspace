package me.ninjay.gravetoscustom.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.gravetoscustom.comandos.ComandoDarItens;
import me.ninjay.gravetoscustom.estruturas.ItensAPI;
import me.ninjay.gravetoscustom.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.recipe();
	}

}
