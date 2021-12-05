package me.ninjay.poo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.poo.comandos.ComandoProbabilidade;
import me.ninjay.poo.comandos.Porra;
import me.ninjay.poo.eventos.EventoClick;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("hm").setExecutor(new ComandoProbabilidade());
		Bukkit.getPluginManager().registerEvents(new EventoClick(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoProbabilidade(), this);
		getCommand("hmm").setExecutor(new Porra());
	}

}
