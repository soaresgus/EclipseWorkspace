package me.ninjay.maquina;

import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.comandos.ComandoDarMaquina;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
	getCommand("givemaquina").setExecutor(new ComandoDarMaquina());
	}

}
