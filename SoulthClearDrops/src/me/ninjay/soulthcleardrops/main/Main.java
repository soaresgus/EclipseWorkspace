package me.ninjay.soulthcleardrops.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthcleardrops.cleardrops.EventosClearDrops;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosClearDrops(), this);
	}

}
