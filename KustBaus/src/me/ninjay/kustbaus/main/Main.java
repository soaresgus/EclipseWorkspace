package me.ninjay.kustbaus.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustbaus.comandos.ComandoBau;
import me.ninjay.kustbaus.comandos.ComandoGiveBau;
import me.ninjay.kustbaus.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig pchest;
	
	@Override
	public void onEnable() {
		getCommand("givebau").setExecutor(new ComandoGiveBau());
		getCommand("bau").setExecutor(new ComandoBau());
		
		Bukkit.getPluginManager().registerEvents(new ComandoBau(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoGiveBau(), this);
		
		pchest = new BukkitConfig("playerChest.yml", this);
		pchest.saveConfig();
		
		saveDefaultConfig();
		
	}

}
