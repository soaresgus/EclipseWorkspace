package me.ninjay.galaxy.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import me.ninjay.galaxy.essentials.ComandoCash;
import me.ninjay.galaxy.essentials.ComandoSetarSpawn;
import me.ninjay.galaxy.essentials.ComandoSpawn;
import me.ninjay.galaxy.essentials.EventosEntrar;
import me.ninjay.galaxy.essentials.EventosSempreDia;
import me.ninjay.galaxy.essentials.SimplesScore;
import me.ninjay.galaxy.kits.ComandoKit;
import me.ninjay.galaxy.ranks.ComandoRanks;
import net.eduard.api.lib.BukkitConfig;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin{
    public static BukkitConfig locais;
    public static BukkitConfig cash;
	@Override
	public void onEnable() {
	  Bukkit.getPluginManager().registerEvents(new ComandoRanks(), this);
	  Bukkit.getPluginManager().registerEvents(new EventosEntrar(), this);
	  Bukkit.getPluginManager().registerEvents(new EventosSempreDia(), this);
	  Bukkit.getPluginManager().registerEvents(new ComandoKit(), this);
	  
	  getCommand("ranks").setExecutor(new ComandoRanks());
	  getCommand("cash").setExecutor(new ComandoCash());
	  getCommand("setarspawn").setExecutor(new ComandoSetarSpawn());
	  getCommand("spawn").setExecutor(new ComandoSpawn());
	  getCommand("kit").setExecutor(new ComandoKit());
	  
	  
	  locais = new BukkitConfig("locais.yml", this);
	  locais.saveConfig();
	  cash = new BukkitConfig("cash.yml", this);
	  cash.saveConfig();
	  
	  setupPermissions();
	  setupChat();
	  setupEconomy();
	
	  SimplesScore.ligar(this);
	  
	}
	@Override
	public void onDisable() {
		
	}
	public static Permission permission = null;
	public static Economy economy = null;
	public static Chat chat = null;

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			permission = permissionProvider.getProvider();
		}
		return (permission != null);
	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.chat.Chat.class);
		if (chatProvider != null) {
			chat = chatProvider.getProvider();
		}

		return (chat != null);
	}

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}
}

	
