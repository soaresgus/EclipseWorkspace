package me.ninjay.circles_hbninja.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.circles_hbninja.eventos.EventosPrimario;
import me.ninjay.circles_hbninja.eventos.EventosSecundario;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosPrimario(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSecundario(), this);
	}

}
