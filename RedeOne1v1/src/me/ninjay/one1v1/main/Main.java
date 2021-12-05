package me.ninjay.one1v1.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.one1v1.comandos.Comando1v1;
import me.ninjay.one1v1.eventos.EventosTemplate;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	public static BukkitConfig arenas;
	
	@Override
	public void onEnable() {
		getCommand("x1").setExecutor(new Comando1v1());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		arenas = new BukkitConfig("arenas.yml", this);
		arenas.saveConfig();
	}

}
