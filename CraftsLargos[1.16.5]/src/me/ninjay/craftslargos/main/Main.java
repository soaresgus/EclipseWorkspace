package me.ninjay.craftslargos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.craftslargos.comandos.ComandoDarItens;
import me.ninjay.craftslargos.estruturas.ItensAPI;
import me.ninjay.craftslargos.eventos.EventosCraft;
import me.ninjay.craftslargos.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		
		Bukkit.getPluginManager().registerEvents(new EventosCraft(), this);
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
