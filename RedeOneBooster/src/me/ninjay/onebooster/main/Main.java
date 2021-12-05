package me.ninjay.onebooster.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onebooster.comandos.ComandoDarBooster;
import me.ninjay.onebooster.eventos.EventosTemplate;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("darbooster").setExecutor(new ComandoDarBooster());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
	}

}
