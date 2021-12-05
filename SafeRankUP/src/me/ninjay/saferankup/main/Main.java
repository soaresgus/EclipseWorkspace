package me.ninjay.saferankup.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safecash.utils.BukkitConfig;
import me.ninjay.saferankup.comandos.ComandoRankUP;
import me.ninjay.saferankup.comandos.ComandoRanks;
import me.ninjay.saferankup.estruturas.Rank;
import me.ninjay.saferankup.estruturas.RankAPI;
import me.ninjay.saferankup.estruturas.RankManager;
import me.ninjay.saferankup.estruturas.SimplesScore;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("ranks").setExecutor(new ComandoRanks());
		Bukkit.getPluginManager().registerEvents(new ComandoRanks(), this);
		
		getCommand("rankup").setExecutor(new ComandoRankUP());
		Bukkit.getPluginManager().registerEvents(new ComandoRankUP(), this);
		
		Bukkit.getPluginManager().registerEvents(new SimplesScore(), this);
		SimplesScore.ligar(this);
		
		StorageAPI.register(RankManager.class);
		StorageAPI.register(Rank.class);
		
		RankAPI.reload();
		
		Bukkit.getConsoleSender().sendMessage("§2[SafeRanks] §aPlugin iniciado com sucesso!");
	}
	

}
