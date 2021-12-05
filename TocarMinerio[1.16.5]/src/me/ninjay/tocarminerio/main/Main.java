package me.ninjay.tocarminerio.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.tocarminerio.comandos.ComandoTocar;
import me.ninjay.tocarminerio.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("tocar").setExecutor(new ComandoTocar());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
