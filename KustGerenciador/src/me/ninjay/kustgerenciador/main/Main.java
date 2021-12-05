package me.ninjay.kustgerenciador.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustgerenciador.comandos.ComandoArena;
import me.ninjay.kustgerenciador.comandos.ComandoGerenciar;
import me.ninjay.kustgerenciador.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("gerenciar").setExecutor(new ComandoGerenciar());
		getCommand("arena").setExecutor(new ComandoArena());
		
		Bukkit.getPluginManager().registerEvents(new ComandoGerenciar(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		ComandoGerenciar.startDrops(this);
	}

}
