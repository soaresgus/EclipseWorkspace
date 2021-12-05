package me.ninjay.ninjakibes.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjakibes.Hyze.LaunchPad.eventos.EventosLaunchPad;
import me.ninjay.ninjakibes.Hyze.lancador.eventos.EventosLancador;
import me.ninjay.ninjakibes.comandos.ComandoDar;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("dar").setExecutor(new ComandoDar());
		Bukkit.getPluginManager().registerEvents(new EventosLaunchPad(), this);
	    Bukkit.getPluginManager().registerEvents(new EventosLancador(), this);
	}

}
