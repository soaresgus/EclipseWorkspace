package me.ninjay.aureascore;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	public static Main getmain() {
		return (Main) Bukkit.getPluginManager().getPlugin("AureaScore");
	}
	
	public static ArrayList<String> score = new ArrayList();
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Scoreboard(), this);

	}

}
