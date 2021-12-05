package me.ninjay.safemensagens.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safemensagens.comandos.ComandoNovidade;
import me.ninjay.safemensagens.eventos.EventosTemplate;
import me.ninjay.safemensagens.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig novidade;
	
	@Override
	public void onEnable() {
		getCommand("novidade").setExecutor(new ComandoNovidade());
		Bukkit.getPluginManager().registerEvents(new ComandoNovidade(), this);
		
		novidade = new BukkitConfig("novidades.yml", this);
		novidade.saveConfig();
	}

}
