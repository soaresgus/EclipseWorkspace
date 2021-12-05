package me.ninjay.tntespecial.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.tntespecial.comandos.ComandoDarItens;
import me.ninjay.tntespecial.estruturas.ItensAPI;
import me.ninjay.tntespecial.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
