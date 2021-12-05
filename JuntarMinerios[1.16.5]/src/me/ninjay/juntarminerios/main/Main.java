package me.ninjay.juntarminerios.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.juntarminerios.comandos.ComandoDarItens;
import me.ninjay.juntarminerios.estruturas.ItensAPI;
import me.ninjay.juntarminerios.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}
}
