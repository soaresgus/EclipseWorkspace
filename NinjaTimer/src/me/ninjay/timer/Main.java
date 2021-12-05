package me.ninjay.timer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("timer").setExecutor(new ComandoTimer());
	}

	public static Main getmain() {
		return (Main) Bukkit.getPluginManager().getPlugin("NinjaTimer");
	}

}
