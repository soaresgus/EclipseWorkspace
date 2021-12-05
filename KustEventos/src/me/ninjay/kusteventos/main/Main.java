package me.ninjay.kusteventos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kusteventos.comandos.ComandoBasePerdida;
import me.ninjay.kusteventos.comandos.ComandoBolao;
import me.ninjay.kusteventos.comandos.ComandoLoteria;
import me.ninjay.kusteventos.comandos.ComandoPalavra;
import me.ninjay.kusteventos.comandos.ComandoSorteio;
import me.ninjay.kusteventos.estruturas.BPManager;
import me.ninjay.kusteventos.estruturas.EventosManager;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("eventos").setExecutor(new EventosManager());
		getCommand("loteria").setExecutor(new ComandoLoteria());
		getCommand("bolao").setExecutor(new ComandoBolao());
		getCommand("palavra").setExecutor(new ComandoPalavra());
		getCommand("sorteio").setExecutor(new ComandoSorteio());
		getCommand("baseperdida").setExecutor(new ComandoBasePerdida());
		
		Bukkit.getPluginManager().registerEvents(new EventosManager(), this);
		Bukkit.getPluginManager().registerEvents(new BPManager(), this);
	}

}
