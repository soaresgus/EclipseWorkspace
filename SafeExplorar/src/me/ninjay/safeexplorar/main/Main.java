package me.ninjay.safeexplorar.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safeexplorar.comandos.ComandoExplorar;
import me.ninjay.safeexplorar.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		getCommand("explorar").setExecutor(new ComandoExplorar());
		Bukkit.getPluginManager().registerEvents(new ComandoExplorar(), this);
		
		Bukkit.getConsoleSender().sendMessage("§2[SafeExplorar] §aPlugin iniciado com sucesso!");
	}
	

}
