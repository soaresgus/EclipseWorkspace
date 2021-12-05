package me.ninjay.ninjapartylb.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjapartylb.estruturas.SimplesScore;
import me.ninjay.ninjapartylb.eventos.EventosLobby;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosLobby(), this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
	}

}
