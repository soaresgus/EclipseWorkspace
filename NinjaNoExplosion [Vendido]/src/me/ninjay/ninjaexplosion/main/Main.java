package me.ninjay.ninjaexplosion.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjaexplosion.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getConsoleSender().sendMessage("§6[NinjaNoExplosion] §aPlugin ativado com sucesso.");
	}

}
