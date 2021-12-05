package me.ninjay.onewarps.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onewarps.comandos.ComandoArena;
import me.ninjay.onewarps.comandos.ComandoLoja;
import me.ninjay.onewarps.comandos.ComandoMina;
import me.ninjay.onewarps.comandos.ComandoSetArena;
import me.ninjay.onewarps.comandos.ComandoSetLoja;
import me.ninjay.onewarps.comandos.ComandoSetMina;
import me.ninjay.onewarps.comandos.ComandoSetSpawn;
import me.ninjay.onewarps.comandos.ComandoSpawn;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	public static BukkitConfig locais;
	@Override
	public void onEnable() {
		locais = new BukkitConfig("locais.yml", this);
		locais.saveConfig();
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("loja").setExecutor(new ComandoLoja());
		getCommand("mina").setExecutor(new ComandoMina());
		Bukkit.getPluginManager().registerEvents(new ComandoMina(), this);
		getCommand("arena").setExecutor(new ComandoArena());
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("setloja").setExecutor(new ComandoSetLoja());
		getCommand("setmina").setExecutor(new ComandoSetMina());
		getCommand("setarena").setExecutor(new ComandoSetArena());
		Bukkit.getPluginManager().registerEvents(new ComandoSetMina(), this);
	}

}
