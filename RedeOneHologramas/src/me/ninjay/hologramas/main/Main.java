package me.ninjay.hologramas.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.hologramas.comandos.ComandoHolograma;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("holograma").setExecutor(new ComandoHolograma());
	}

}
