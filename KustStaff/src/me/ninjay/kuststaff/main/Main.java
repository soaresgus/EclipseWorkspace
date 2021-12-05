package me.ninjay.kuststaff.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kuststaff.comandos.ComandoPlayer;
import me.ninjay.kuststaff.comandos.ComandoReport;
import me.ninjay.kuststaff.comandos.ComandoReports;
import me.ninjay.kuststaff.comandos.ComandoStaff;
import me.ninjay.kuststaff.comandos.ComandoStaffChat;
import me.ninjay.kuststaff.comandos.ComandoVanish;
import me.ninjay.kuststaff.eventos.EventosGeral;
import me.ninjay.kuststaff.utils.BukkitConfig;

public class Main extends JavaPlugin{

	public static BukkitConfig config;
	public static BukkitConfig reports;
	
	@Override
	public void onEnable() {
		getCommand("player").setExecutor(new ComandoPlayer());
		getCommand("v").setExecutor(new ComandoVanish());
		getCommand("report").setExecutor(new ComandoReport());
		getCommand("reports").setExecutor(new ComandoReports());
		getCommand("s").setExecutor(new ComandoStaffChat());
		getCommand("staff").setExecutor(new ComandoStaff());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoReports(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoVanish(), this);
		
		config = new BukkitConfig("players.yml", this);
		config.saveConfig();
		
		reports = new BukkitConfig("reports.yml", this);
		reports.saveConfig();
	}
}
