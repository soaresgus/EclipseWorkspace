package me.ninjay.pocoesmobs.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.pocoesmobs.comandos.ComandoGive;
import me.ninjay.pocoesmobs.eventos.EventosPocoes;
import me.ninjay.pocoesmobs.eventos.EventosSuporte;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosPocoes(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSuporte(), this);
		getCommand("darpocao").setExecutor(new ComandoGive());
	}

}
