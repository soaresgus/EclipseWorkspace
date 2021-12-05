package me.ninjay.safeminas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safeminas.comandos.ComandoTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("escavar").setExecutor(new ComandoTemplate());
	}

}
