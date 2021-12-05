package me.ninjay.tesourargeleia.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.tesourargeleia.comandos.ComandoDarItens;
import me.ninjay.tesourargeleia.estruturas.ItensAPI;
import me.ninjay.tesourargeleia.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
