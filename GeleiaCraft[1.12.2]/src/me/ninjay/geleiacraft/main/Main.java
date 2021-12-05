package me.ninjay.geleiacraft.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.geleiacraft.comandos.ComandoDarItens;
import me.ninjay.geleiacraft.estruturas.ItensAPI;
import me.ninjay.geleiacraft.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI api = new ItensAPI();
		
		api.customRecipe();
	}

}
