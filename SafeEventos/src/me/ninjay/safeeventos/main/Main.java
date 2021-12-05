package me.ninjay.safeeventos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safeeventos.comandos.ComandoBasePerdida;
import me.ninjay.safeeventos.comandos.ComandoBolao;
import me.ninjay.safeeventos.comandos.ComandoGuerra;
import me.ninjay.safeeventos.comandos.ComandoLoteria;
import me.ninjay.safeeventos.comandos.ComandoPalavra;
import me.ninjay.safeeventos.comandos.ComandoSorteio;
import me.ninjay.safeeventos.estruturas.BPManager;
import me.ninjay.safeeventos.estruturas.EventosManager;
import me.ninjay.safeeventos.estruturas.GuerraManager;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("eventos").setExecutor(new EventosManager());
		getCommand("loteria").setExecutor(new ComandoLoteria());
		getCommand("bolao").setExecutor(new ComandoBolao());
		getCommand("palavra").setExecutor(new ComandoPalavra());
		getCommand("sorteio").setExecutor(new ComandoSorteio());
		getCommand("baseperdida").setExecutor(new ComandoBasePerdida());
		getCommand("guerra").setExecutor(new ComandoGuerra());
		
		Bukkit.getPluginManager().registerEvents(new EventosManager(), this);
		Bukkit.getPluginManager().registerEvents(new BPManager(), this);
		Bukkit.getPluginManager().registerEvents(new GuerraManager(), this);
	}

}
