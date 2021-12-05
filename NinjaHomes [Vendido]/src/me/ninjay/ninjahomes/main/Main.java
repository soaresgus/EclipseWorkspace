package me.ninjay.ninjahomes.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjahomes.comandos.ComandoDelHome;
import me.ninjay.ninjahomes.comandos.ComandoHome;
import me.ninjay.ninjahomes.comandos.ComandoListHomes;
import me.ninjay.ninjahomes.comandos.ComandoParticular;
import me.ninjay.ninjahomes.comandos.ComandoPublica;
import me.ninjay.ninjahomes.comandos.ComandoSetHome;
import me.ninjay.ninjahomes.eventos.EventosFirstJoin;
import me.ninjay.ninjahomes.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	public static BukkitConfig homeconf;
	public static BukkitConfig listar;
	
	@Override
	public void onEnable() {
		getCommand("home").setExecutor(new ComandoHome());
		getCommand("delhome").setExecutor(new ComandoDelHome());
		getCommand("sethome").setExecutor(new ComandoSetHome());
		getCommand("particular").setExecutor(new ComandoParticular());
		getCommand("publica").setExecutor(new ComandoPublica());
		getCommand("listhomes").setExecutor(new ComandoListHomes());
		
		Bukkit.getPluginManager().registerEvents(new EventosFirstJoin(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		homeconf = new BukkitConfig("homes.yml", this);
		homeconf.saveConfig();
		
		listar = new BukkitConfig("listagem.yml", this);
		listar.saveConfig();
		
		Bukkit.getConsoleSender().sendMessage("§6[NinjaHomes] §aPlugin ativado com sucesso!");
	}

}
