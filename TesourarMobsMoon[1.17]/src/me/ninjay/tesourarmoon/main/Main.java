package me.ninjay.tesourarmoon.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.tesourarmoon.comandos.ComandoDarItens;
import me.ninjay.tesourarmoon.estruturas.ItensAPI;
import me.ninjay.tesourarmoon.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
