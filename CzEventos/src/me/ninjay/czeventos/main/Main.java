package me.ninjay.czeventos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.czeventos.comandos.ComandoBolao;
import me.ninjay.czeventos.eventos.EventosTemplate;
import me.ninjay.czeventos.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig global;
	public static BukkitConfig bolao;
	public static BukkitConfig loteria;
	
	@Override
	public void onEnable() {
		getCommand("bolao").setExecutor(new ComandoBolao());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		global = new BukkitConfig("global.yml", this);
		global.saveConfig();
		bolao = new BukkitConfig("bolao.yml", this);
		bolao.saveConfig();
		loteria = new BukkitConfig("loteria.yml", this);
		loteria.saveConfig();
	}

}
