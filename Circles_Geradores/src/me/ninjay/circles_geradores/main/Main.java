package me.ninjay.circles_geradores.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.circles_geradores.comandos.ComandoDarItens;
import me.ninjay.circles_geradores.estruturas.ItensAPI;
import me.ninjay.circles_geradores.eventos.EventosGeral;
import me.ninjay.circles_geradores.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		saveConfig();
		
		ItensAPI.customCraft();
	}
	
	private static Main plugin;

	public static Main getInstance() {
		return plugin;
	}

}
