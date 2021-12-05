package me.ninjay.melmagico.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.melmagico.comandos.ComandoAtivar;
import me.ninjay.melmagico.comandos.ComandoDarItens;
import me.ninjay.melmagico.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("ativar").setExecutor(new ComandoAtivar());
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	}

}
