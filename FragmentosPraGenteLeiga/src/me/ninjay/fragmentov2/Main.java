package me.ninjay.fragmentov2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onenable() {
		Bukkit.getPluginManager().registerEvents(new Evento(), this);
	}

}
