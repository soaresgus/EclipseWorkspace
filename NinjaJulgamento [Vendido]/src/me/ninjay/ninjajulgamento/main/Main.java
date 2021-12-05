package me.ninjay.ninjajulgamento.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjajulgamento.eventos.EventosGeral;
import me.ninjay.ninjajulgamento.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		Bukkit.getConsoleSender().sendMessage("§6[NinjaJulgamento] §aPlugin ativado com sucesso!");

		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
	}

}
