package me.ninjay.loginstf.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.loginstf.comandos.ComandoPin;
import me.ninjay.loginstf.eventos.EventosPin;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig pin;
	
	@Override
	public void onEnable() {
		getCommand("pin").setExecutor(new ComandoPin());
		Bukkit.getPluginManager().registerEvents(new EventosPin(), this);
	    pin = new BukkitConfig("pin.yml", this);
	    pin.saveDefaultConfig();
	    pin.saveConfig();
	    
	}

}
