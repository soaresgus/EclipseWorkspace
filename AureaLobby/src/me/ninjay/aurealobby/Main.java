package me.ninjay.aurealobby;



import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.BukkitConfig;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	public static BukkitConfig config;

	public static Main getmain() {
		return (Main) Bukkit.getPluginManager().getPlugin("NomeDoPL");
	}
	@Override
	public void onEnable() {
		config = new BukkitConfig("config.yml", this);
		config.saveConfig();
		Bukkit.getPluginManager().registerEvents(new EventosEntrar(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBloqueadorDeComandos(), this);
		Bukkit.getPluginManager().registerEvents(new EventosDeChat(), this);
		Bukkit.getPluginManager().registerEvents(new EventosAntiDrop(), this);
		Bukkit.getPluginManager().registerEvents(new EventosRenascer(), this);
		Bukkit.getPluginManager().registerEvents(new EventosBússola(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSempreDia(), this);
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		SimplesScore.ligar(this);
		getCommand("cargo").setExecutor(new ComandoCargos());
		Bukkit.getPluginManager().registerEvents(new EventosCargos(), this);
		setupChat();
		setupEconomy();
		setupPermissions();
		Bukkit.getPluginManager().registerEvents(new EventosMorrer(), this);
		Bukkit.getPluginManager().registerEvents(new EventosSair(), this);
		Bukkit.getPluginManager().registerEvents(new EventosAntiBugs(), this);
		Bukkit.getPluginManager().registerEvents(new EventosGadgets(), this);
		getCommand("thor").setExecutor(new ComandoThor());
		getCommand("flyoff").setExecutor(new ComandoFly());
		getCommand("pvp").setExecutor(new ComandoPvP());
		getCommand("setarena").setExecutor(new ComandoSetarArena());
		Bukkit.getPluginManager().registerEvents(new EventosSopa(), this);

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
