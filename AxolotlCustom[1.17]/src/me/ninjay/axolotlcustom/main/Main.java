package me.ninjay.axolotlcustom.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.axolotlcustom.comandos.ComandoDarItens;
import me.ninjay.axolotlcustom.estruturas.ItensAPI;
import me.ninjay.axolotlcustom.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
	
		ItensAPI.customCraft();
	}
	
}
