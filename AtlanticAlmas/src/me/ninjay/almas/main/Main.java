package me.ninjay.almas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.almas.almas.ComandoAlmas;
import me.ninjay.almas.almas.EventosAlmas;
import me.ninjay.almas.combustivel.Combustivel;
import me.ninjay.almas.combustivel.CombustivelAPI;
import me.ninjay.almas.combustivel.CombustivelControler;
import me.ninjay.almas.combustivel.CombustivelManager;
import me.ninjay.almas.maquinas.ComandoDarMaquina;
import me.ninjay.almas.maquinas.Maquina;
import me.ninjay.almas.maquinas.MaquinaAPI;
import me.ninjay.almas.maquinas.MaquinaControler;
import me.ninjay.almas.maquinas.MaquinaManager;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;

public class Main extends JavaPlugin{
	public static BukkitConfig almas;
	public static BukkitConfig blocos;
	
	@Override
	public void onEnable() {
		almas = new BukkitConfig("almas.yml", this);
		almas.saveConfig();
		blocos = new BukkitConfig("blocos.yml", this);
		blocos.saveConfig();
		getCommand("almas").setExecutor(new ComandoAlmas());
		Bukkit.getPluginManager().registerEvents(new EventosAlmas(), this);
		StorageAPI.register(Maquina.class);
		StorageAPI.register(MaquinaManager.class);
		StorageAPI.register(Combustivel.class);
		StorageAPI.register(CombustivelManager.class);
		CombustivelAPI.reload();
		MaquinaAPI.reload();
		Bukkit.getPluginManager().registerEvents(new MaquinaControler(), this);
		Bukkit.getPluginManager().registerEvents(new CombustivelControler(), this);
		getCommand("darmaquina").setExecutor(new ComandoDarMaquina());
	}

}
