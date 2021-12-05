package me.ninjay.antiabuso.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.antiabuso.comandos.ComandoModReq;
import me.ninjay.antiabuso.comandos.ComandoReportar;
import me.ninjay.antiabuso.comandos.ComandoReports;
import me.ninjay.antiabuso.comandos.ComandoTeleportar;
import me.ninjay.antiabuso.eventos.EventosGerais;
import me.ninjay.antiabuso.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("modreq").setExecutor(new ComandoModReq());
		getCommand("teleportar").setExecutor(new ComandoTeleportar());
		getCommand("reportar").setExecutor(new ComandoReportar());
		getCommand("reports").setExecutor(new ComandoReports());
		
		for(Player todos : Bukkit.getOnlinePlayers()) {
			ComandoModReq.dado.put(todos.getName(), 0);
		}
		
		Bukkit.getPluginManager().registerEvents(new EventosGerais(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoModReq(), this);
		
		config = new BukkitConfig("reports.yml", this);
		config.saveConfig();
		
	}

}
