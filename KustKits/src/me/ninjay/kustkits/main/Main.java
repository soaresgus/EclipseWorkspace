package me.ninjay.kustkits.main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kustkits.estruturas.Kit;
import me.ninjay.kustkits.estruturas.KitAPI;
import me.ninjay.kustkits.estruturas.KitControler;
import me.ninjay.kustkits.estruturas.KitManager;
import me.ninjay.kustkits.estruturas.TimerAPI;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	public static BukkitConfig playerKits;
	
	@Override
	public void onEnable() {
		getCommand("kit").setExecutor(new KitControler());
		Bukkit.getPluginManager().registerEvents(new KitControler(), this);
		
		StorageAPI.register(Kit.class);
		StorageAPI.register(KitManager.class);
		
		KitAPI.reload();
		
		playerKits = new BukkitConfig("PlayerKits.yml", this);
		playerKits.saveConfig();
		
		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			for(Kit kits : KitAPI.manager.getKits()) {
				if(playerKits.contains(player.getName()+"."+kits.getName())) {
					if(playerKits.getInt(player.getName()+"."+kits.getName()) <= 0) {
						playerKits.remove(player.getName()+"."+kits.getName());
						playerKits.saveConfig();
					}else if(playerKits.getInt(player.getName()+"."+kits.getName()) >= 1) {
						TimerAPI.timer(TimerAPI.getTempoCorrendo(playerKits, player.getName()+"."+kits.getName()), playerKits, this, player.getName()+"."+kits.getName());
					}
				}
			}
		}
		
		new BukkitRunnable() {
			int i = 60;
			@Override
			public void run() {
				i--;
				if(i <= 0) {
					i=60;
					for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
						for(Kit kits : KitAPI.manager.getKits()) {
							if(playerKits.contains(player.getName()+"."+kits.getName())) {
								if(playerKits.getInt(player.getName()+"."+kits.getName()) <= 0) {
									playerKits.remove(player.getName()+"."+kits.getName());
									playerKits.saveConfig();
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(this, 20, 20);
		
	}

}
