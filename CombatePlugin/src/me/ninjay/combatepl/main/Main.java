package me.ninjay.combatepl.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import me.ninjay.combatepl.eventos.EventosCombate;
import me.ninjay.combatepl.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosCombate(), this);
		config = new BukkitConfig("config.yml");
		config.saveDefaultConfig();
		config.set("Plugin", "Plugin de combate feito por Ninjay_, todos direitos reservados.");
		config.set("Direitos", "Discord: Ninja#0603 | Twitter: @ManoNinjay");
		config.saveConfig();
	}

}
