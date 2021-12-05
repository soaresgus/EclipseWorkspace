package me.ninjay.megavender.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.megavender.comandos.ComandoDrops;
import me.ninjay.megavender.comandos.ComandoVender;
import me.ninjay.megavender.eventos.EventosDrops;
import me.ninjay.megavender.eventos.EventosVender;
import me.ninjay.megavender.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig global;
	public static BukkitConfig pdrops;
	
	@Override
	public void onEnable() {
		global = new BukkitConfig("config.yml", this);
		global.saveDefaultConfig();
		pdrops = new BukkitConfig("drops.yml", this);
		pdrops.saveConfig();
		getCommand("drops").setExecutor(new ComandoDrops());
		getCommand("vender").setExecutor(new ComandoVender());
		Bukkit.getPluginManager().registerEvents(new EventosVender(), this);
		Bukkit.getPluginManager().registerEvents(new EventosDrops(), this);
			
		}

}
