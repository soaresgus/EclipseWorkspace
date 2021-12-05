package me.ninjay.kustlobby.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustlobby.comandos.ComandoConnect;
import me.ninjay.kustlobby.comandos.ComandoNPCH;
import me.ninjay.kustlobby.estruturas.SimplesScore;
import me.ninjay.kustlobby.eventos.EventosGeral;
import me.ninjay.kustlobby.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("conectar").setExecutor(new ComandoConnect());
		getCommand("npch").setExecutor(new ComandoNPCH());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();

		Bukkit.getConsoleSender().sendMessage("§a[KustLobby] §6Lobby iniciado.");
	}

}
