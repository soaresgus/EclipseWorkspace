package me.ninjay.kustespeciais.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustespeciais.comandos.ComandoGive;
import me.ninjay.kustespeciais.comandos.ComandoShop;
import me.ninjay.kustespeciais.eventos.EventosGeral;
import me.ninjay.kustespeciais.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoGive(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoShop(), this);
		
		getCommand("giveespeciais").setExecutor(new ComandoGive());
		getCommand("shop").setExecutor(new ComandoShop());
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
	}

}
