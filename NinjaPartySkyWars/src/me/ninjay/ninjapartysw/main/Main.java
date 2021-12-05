package me.ninjay.ninjapartysw.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjapartysw.comandos.ComandoBau;
import me.ninjay.ninjapartysw.eventos.EventosTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("bau").setExecutor(new ComandoBau());
	}

}
