package me.ninjay.kustcaixas.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustcaixas.comandos.ComandoCaixaGive;
import me.ninjay.kustcaixas.comandos.ComandoCaixaShop;
import me.ninjay.kustcaixas.estruturas.Caixa;
import me.ninjay.kustcaixas.estruturas.CaixaAPI;
import me.ninjay.kustcaixas.estruturas.CaixaControler;
import me.ninjay.kustcaixas.estruturas.CaixaManager;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	public static BukkitConfig itens;
	
	@Override
	public void onEnable() {
		
		getCommand("caixagive").setExecutor(new ComandoCaixaGive());
		getCommand("caixashop").setExecutor(new ComandoCaixaShop());
		
		Bukkit.getPluginManager().registerEvents(new CaixaControler(), this);
		Bukkit.getPluginManager().registerEvents(new ComandoCaixaShop(), this);
		
		StorageAPI.register(Caixa.class);
		StorageAPI.register(CaixaManager.class);
		
		CaixaAPI.reload();
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		itens = new BukkitConfig("itens.yml", this);
		itens.saveDefaultConfig();
	}

}
