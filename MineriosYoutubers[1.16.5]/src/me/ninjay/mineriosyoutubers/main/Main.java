package me.ninjay.mineriosyoutubers.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.mineriosyoutubers.comandos.ComandoDarItens;
import me.ninjay.mineriosyoutubers.estruturas.ItensAPI;
import me.ninjay.mineriosyoutubers.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
