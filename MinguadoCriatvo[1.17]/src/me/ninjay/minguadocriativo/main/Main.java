package me.ninjay.minguadocriativo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.minguadocriativo.comandos.ComandoDarItens;
import me.ninjay.minguadocriativo.estruturas.ItensAPI;
import me.ninjay.minguadocriativo.eventos.EventosGeral;
import me.ninjay.minguadocriativo.eventos.EventosMercado;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new EventosMercado(), this);
		
		ItensAPI.customCraft();
	}

}
