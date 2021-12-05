package me.ninjay.rankup112.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.rankup112.comandos.ComandoRanks;
import me.ninjay.rankup112.estruturas.Ranks;
import me.ninjay.rankup112.estruturas.RanksAPI;
import me.ninjay.rankup112.estruturas.RanksManager;
import me.ninjay.rankup112.eventos.EventosTemplate;
import me.ninjay.rankup112.utils.BukkitStorables;
import me.ninjay.rankup112.utils.StorageAPI;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("ranks").setExecutor(new ComandoRanks());
		Bukkit.getPluginManager().registerEvents(new EventosTemplate(), this);
		
		BukkitStorables.load();
		
		StorageAPI.register(RanksManager.class);
		StorageAPI.register(Ranks.class);
		
		RanksAPI.reload();
	}
}
