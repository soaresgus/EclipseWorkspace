package me.ninjay.soulthmina.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthmina.mina.ComandoMina;
import me.ninjay.soulthmina.mina.ComandoSetarMina;
import me.ninjay.soulthmina.mina.EventosMina;
import me.ninjay.soulthmina.mina.EventosSetarMina;
import net.eduard.api.lib.BukkitConfig;


public class Main extends JavaPlugin{
	public static BukkitConfig locais;
	@Override
	public void onEnable() {
		getCommand("mina").setExecutor(new ComandoMina());
		getCommand("setarmina").setExecutor(new ComandoSetarMina());
		locais = new BukkitConfig("locais.yml", this);
		locais.saveConfig();
		Bukkit.getPluginManager().registerEvents(new EventosMina(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSetarMina(), this);
	}

}
