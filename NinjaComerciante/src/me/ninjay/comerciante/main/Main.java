package me.ninjay.comerciante.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.comerciante.comandos.ComandoComerciante;
import me.ninjay.comerciante.comandos.ComandoNPC;
import me.ninjay.comerciante.comandos.ComandoReloadConfig;
import me.ninjay.comerciante.estruturas.ComercianteControler;
import me.ninjay.comerciante.estruturas.Itens;
import me.ninjay.comerciante.estruturas.ItensAPI;
import me.ninjay.comerciante.estruturas.ItensManager;
import me.ninjay.comerciante.estruturas.TimerAPI;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("comerciante").setExecutor(new ComandoComerciante());
		getCommand("comerciantenpc").setExecutor(new ComandoNPC());
		getCommand("reloadconfig").setExecutor(new ComandoReloadConfig());
		
		Bukkit.getPluginManager().registerEvents(new ComercianteControler(), this);

		ItensAPI.configp.saveDefaultConfig();
		ItensAPI.configp.saveConfig();
		
		StorageAPI.register(Itens.class);
		StorageAPI.register(ItensManager.class);
		
		ItensAPI.reload();
		
		TimerAPI.timer(ItensAPI.configp.getInt("ResetPorSegundo"), ItensAPI.info, this, "timer");
	}
	
	

}
