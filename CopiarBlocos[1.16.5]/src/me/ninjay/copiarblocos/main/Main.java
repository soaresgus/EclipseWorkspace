package me.ninjay.copiarblocos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.copiarblocos.comandos.ComandoDarItens;
import me.ninjay.copiarblocos.estruturas.ItensAPI;
import me.ninjay.copiarblocos.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
