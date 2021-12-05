package me.ninjay.minahack.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.minahack.comandos.ComandoMina;
import me.ninjay.minahack.eventos.EventosMina;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		getCommand("mina").setExecutor(new ComandoMina());
		Bukkit.getPluginManager().registerEvents(new EventosMina(), this);
	}

}
