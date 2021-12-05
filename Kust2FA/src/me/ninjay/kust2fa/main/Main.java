package me.ninjay.kust2fa.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kust2fa.comandos.ComandoPin;
import me.ninjay.kust2fa.eventos.EventosGeral;
import me.ninjay.kust2fa.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("pin").setExecutor(new ComandoPin());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
	}

}
