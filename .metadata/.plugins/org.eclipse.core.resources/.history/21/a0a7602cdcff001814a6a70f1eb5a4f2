package me.ninjay.onealmas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onealmas.comandos.ComandoAlmas;
import me.ninjay.onealmas.eventos.EventosAlmas;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	public static BukkitConfig almas;
	@Override
	public void onEnable() {
		almas = new BukkitConfig("almas.yml", this);
		almas.saveConfig();
		getCommand("alma").setExecutor(new ComandoAlmas());
		Bukkit.getPluginManager().registerEvents(new EventosAlmas(), this);
	}

}
