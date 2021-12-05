package me.ninjay.teste112.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.teste112.comandos.ComandoTeste;
import me.ninjay.teste112.eventos.EventosTeste;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("teste").setExecutor(new ComandoTeste());
		Bukkit.getPluginManager().registerEvents(new EventosTeste(), this);
	}

}
