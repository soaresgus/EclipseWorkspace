package me.ninjay.fragbase;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new A��o(), this);
		
	}
	@Override
	public void onDisable() {
	
	}

}
