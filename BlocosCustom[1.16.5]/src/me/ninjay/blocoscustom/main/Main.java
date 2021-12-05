package me.ninjay.blocoscustom.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.blocoscustom.comandos.ComandoDarItens;
import me.ninjay.blocoscustom.estruturas.ItensAPI;
import me.ninjay.blocoscustom.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
	}

}
