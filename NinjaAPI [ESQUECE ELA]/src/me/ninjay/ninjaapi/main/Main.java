package me.ninjay.ninjaapi.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjaapi.bukkit.CaixaAPI.Caixa;
import me.ninjay.ninjaapi.bukkit.CaixaAPI.CaixaAPI;
import me.ninjay.ninjaapi.bukkit.CaixaAPI.CaixaManager;
import me.ninjay.ninjaapi.bukkit.CashAPI.ComandoCash;
import me.ninjay.ninjaapi.bukkit.EventoAPI.ComandoEvento;
import me.ninjay.ninjaapi.bukkit.EventoAPI.ComandoGladiator;
import me.ninjay.ninjaapi.bukkit.EventoAPI.Evento;
import me.ninjay.ninjaapi.bukkit.EventoAPI.EventoAPI;
import me.ninjay.ninjaapi.bukkit.EventoAPI.EventoManager;
import me.ninjay.ninjaapi.bukkit.EventoAPI.EventosEvento;

import me.ninjay.ninjaapi.utils.BukkitConfig;
import me.ninjay.ninjaapi.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	//EVENTO API
	public static BukkitConfig locais;
    //EVENTO API	
	
	// CASH API
	public static BukkitConfig cash;
	// CASH API
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§a[NinjaAPI] §fAPI ativada com sucesso !");
	    
		//EVENTO API
		StorageAPI.register(Evento.class);
	    StorageAPI.register(EventoManager.class);
	    EventoAPI.reload();
	    getCommand("evento").setExecutor(new ComandoEvento());
	    getCommand("gladiator").setExecutor(new ComandoGladiator());
	    Bukkit.getPluginManager().registerEvents(new EventosEvento(), this);
	    locais = new BukkitConfig("locais.yml", this);
	    locais.saveConfig();
	    //EVENTO API
	    
	    //CAIXA API
	    StorageAPI.register(Caixa.class);
	    StorageAPI.register(CaixaManager.class);
	    CaixaAPI.reload();
	    //CAIXA API
	    
	   
	    
	    //CASH API
	    cash = new BukkitConfig("cash.yml", this);
	    cash.saveConfig();
	    getCommand("cash").setExecutor(new ComandoCash());
	    //CASH API
	    
	   
	    
	}
     
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§a[NinjaAPI] §fAPI desativada com sucesso !");
	    
	}
}
