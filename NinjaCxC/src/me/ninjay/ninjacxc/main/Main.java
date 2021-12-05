package me.ninjay.ninjacxc.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjacxc.utils.BukkitConfig;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	public static BukkitConfig a1;
	
 	@Override
	public void onEnable() {
		config = new BukkitConfig("global.yml", this);
		config.saveConfig();
		a1 = new BukkitConfig("a1.yml", this);
		a1.saveConfig();
	}

}
