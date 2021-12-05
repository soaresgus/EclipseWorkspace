package me.ninjay.safedrops.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.safedrops.estruturas.Drops;
import me.ninjay.safedrops.estruturas.DropsAPI;
import me.ninjay.safedrops.estruturas.DropsControler;
import me.ninjay.safedrops.estruturas.DropsManager;
import me.ninjay.safedrops.utils.Mine;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		StorageAPI.register(Drops.class);
		StorageAPI.register(DropsManager.class);
		
		DropsAPI.reload();
		
		Bukkit.getPluginManager().registerEvents(new DropsControler(), this);
		
		Mine.console("§2[SafeDrops] §6Plugin iniciado!");
	}
}
