package me.ninjay.ninjakitpvp.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjakitpvp.comandos.admin.ComandoBuild;
import me.ninjay.ninjakitpvp.comandos.admin.ComandoReloadConfig;
import me.ninjay.ninjakitpvp.comandos.admin.ComandoSet;
import me.ninjay.ninjakitpvp.comandos.global.ComandoFly;
import me.ninjay.ninjakitpvp.comandos.global.ComandoInfo;
import me.ninjay.ninjakitpvp.comandos.global.ComandoSpawn;
import me.ninjay.ninjakitpvp.comandos.global.ComandoWarps;
import me.ninjay.ninjakitpvp.estruturas.ComandoCoins;
import me.ninjay.ninjakitpvp.estruturas.InfoAPI;
import me.ninjay.ninjakitpvp.estruturas.KitAPI;
import me.ninjay.ninjakitpvp.estruturas.SimplesScore;
import me.ninjay.ninjakitpvp.eventos.EventosGlobal;
import me.ninjay.ninjakitpvp.eventos.EventosWarps;
import me.ninjay.ninjakitpvp.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig locations;
	public static BukkitConfig global;
	public static BukkitConfig cash;
	public static BukkitConfig info;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGlobal(), this);
		Bukkit.getPluginManager().registerEvents(new KitAPI(), this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
		Bukkit.getPluginManager().registerEvents(new EventosWarps(), this);
		Bukkit.getPluginManager().registerEvents(new InfoAPI(), this);
		SimplesScore.ligar(this);
	    locations = new BukkitConfig("locations.yml", this);
	    locations.saveConfig();
	    global = new BukkitConfig("config.yml", this);
	    global.saveDefaultConfig();
	    cash = new BukkitConfig("coins.yml", this);
	    cash.saveConfig();
	    info = new BukkitConfig("info.yml", this);
	    info.saveConfig();
	    Bukkit.getConsoleSender().sendMessage("§aPlugin ativado.");
	    getCommand("set").setExecutor(new ComandoSet());
	    getCommand("spawn").setExecutor(new ComandoSpawn());
	    getCommand("build").setExecutor(new ComandoBuild());
	    getCommand("reloadconfig").setExecutor(new ComandoReloadConfig());
	    getCommand("fly").setExecutor(new ComandoFly());
	    getCommand("warps").setExecutor(new ComandoWarps());
	    getCommand("info").setExecutor(new ComandoInfo());
	    getCommand("coins").setExecutor(new ComandoCoins());
	}

}
