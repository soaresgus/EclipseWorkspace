package me.ninjay.soulthmaquinas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthmaquinas.comandos.ComandoDarMaquina;
import me.ninjay.soulthmaquinas.comandos.ComandoMaquina;
import me.ninjay.soulthmaquinas.estruturas.Maquina;
import me.ninjay.soulthmaquinas.estruturas.MaquinaAPI;
import me.ninjay.soulthmaquinas.estruturas.MaquinaControler;
import me.ninjay.soulthmaquinas.estruturas.MaquinaManager;
import me.ninjay.soulthmaquinas.eventos.EventosTemplate;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;

public class Main extends JavaPlugin{
	
	public static BukkitConfig drop;
	public static BukkitConfig maquinasquantia;
	
	@Override
	public void onEnable() {
		getCommand("maquina").setExecutor(new ComandoMaquina());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		drop = new BukkitConfig("drop.yml", this);
		drop.saveConfig();
		maquinasquantia = new BukkitConfig("maquinasqnt.yml", this);
		maquinasquantia.saveConfig();
		getCommand("darmaquina").setExecutor(new ComandoDarMaquina());
		Bukkit.getPluginManager().registerEvents(new MaquinaControler(), this);
		StorageAPI.register(Maquina.class);
		StorageAPI.register(MaquinaManager.class);
		MaquinaAPI.reload();
	}

}
