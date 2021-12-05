package me.ninjay.geleiashop.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.geleiashop.comandos.ComandoMoney;
import me.ninjay.geleiashop.comandos.ComandoResetar;
import me.ninjay.geleiashop.eventos.EventosGeral;
import me.ninjay.geleiashop.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		getCommand("money").setExecutor(new ComandoMoney());
		getCommand("resetar").setExecutor(new ComandoResetar());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveConfig();
		
		EventosGeral api = new EventosGeral();
		
		api.customRecipe();
	}

}
