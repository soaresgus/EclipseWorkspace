package me.ninjay.safesurvival.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safesurvival.comandos.ComandoSpawn;
import me.ninjay.safesurvival.comandos.ComandoTpa;
import me.ninjay.safesurvival.comandos.ComandoTpacancel;
import me.ninjay.safesurvival.comandos.ComandoTpaccept;
import me.ninjay.safesurvival.eventos.EventosGeral;

public class Main extends JavaPlugin{	
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("tpa").setExecutor(new ComandoTpa());
		getCommand("tpacancel").setExecutor(new ComandoTpacancel());
		getCommand("tpaccept").setExecutor(new ComandoTpaccept());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		Bukkit.getConsoleSender().sendMessage("§2[TaaSafeSurvival] §aSurvival iniciado.");
	}
	
	public static Main getInstance() {
		return instance;
	}

}
