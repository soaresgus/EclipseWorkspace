package me.ninjay.kustscoreboard.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustscoreboard.estruturas.SimplesScore;
import me.ninjay.kustscoreboard.eventos.EventosScore;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosScore(), this);
		
		SimplesScore.ligar(this);
		
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
	}

}
