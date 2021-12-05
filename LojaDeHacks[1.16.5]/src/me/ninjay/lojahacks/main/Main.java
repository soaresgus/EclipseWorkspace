package me.ninjay.lojahacks.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.lojahacks.comandos.ComandoClearHack;
import me.ninjay.lojahacks.comandos.ComandoDarItens;
import me.ninjay.lojahacks.estruturas.ItensAPI;
import me.ninjay.lojahacks.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		getCommand("clearhack").setExecutor(new ComandoClearHack());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
