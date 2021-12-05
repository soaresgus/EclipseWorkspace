package me.ninjay.kustmina.main;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustmina.comandos.ComandoMina;
import me.ninjay.kustmina.comandos.ComandoMinaVip;
import me.ninjay.kustmina.comandos.ComandoSetMina;
import me.ninjay.kustmina.estruturas.CaptchaAPI;
import me.ninjay.kustmina.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("mina").setExecutor(new ComandoMina());
		getCommand("setmina").setExecutor(new ComandoSetMina());
		getCommand("minavip").setExecutor(new ComandoMinaVip());
		
		Bukkit.getPluginManager().registerEvents(new ComandoMina(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoMinaVip(), this);
		Bukkit.getPluginManager().registerEvents(new CaptchaAPI(), this);
		
		Bukkit.createWorld(new WorldCreator("minavip"));
		Bukkit.createWorld(new WorldCreator("mina"));
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
	}

}
