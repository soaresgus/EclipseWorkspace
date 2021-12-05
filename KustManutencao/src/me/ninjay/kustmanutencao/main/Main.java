package me.ninjay.kustmanutencao.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustmanutencao.comandos.ComandoManutencao;
import me.ninjay.kustmanutencao.comandos.ComandoReiniciar;
import me.ninjay.kustmanutencao.estruturas.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("reiniciar").setExecutor(new ComandoReiniciar());
		getCommand("manutencao").setExecutor(new ComandoManutencao());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Bukkit.setWhitelist(false);
			}
		}.runTaskLaterAsynchronously(this, 5*20);
	}

}
