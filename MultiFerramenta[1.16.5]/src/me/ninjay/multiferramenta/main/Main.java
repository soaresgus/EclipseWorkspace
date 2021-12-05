package me.ninjay.multiferramenta.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.multiferramenta.comandos.ComandoDarItens;
import me.ninjay.multiferramenta.eventos.EventosGeral;
import me.ninjay.multiferramenta.eventos.EventosHabilidades;
import me.ninjay.multiferramenta.eventos.EventosQuests;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new EventosQuests(), this);
		Bukkit.getPluginManager().registerEvents(new EventosHabilidades(), this);
	}

}
