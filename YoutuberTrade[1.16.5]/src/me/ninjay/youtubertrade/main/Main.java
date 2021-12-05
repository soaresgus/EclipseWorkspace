package me.ninjay.youtubertrade.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.youtubertrade.comandos.ComandoClearNPC;
import me.ninjay.youtubertrade.comandos.ComandoDarItens;
import me.ninjay.youtubertrade.estruturas.ItensAPI;
import me.ninjay.youtubertrade.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		getCommand("clearnpc").setExecutor(new ComandoClearNPC());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
