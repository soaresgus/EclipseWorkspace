package me.ninjay.soulthcash.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.soulthcash.cash.ComandoCash;
import net.eduard.api.lib.BukkitConfig;

public class Main extends JavaPlugin{
	public static BukkitConfig cash;
	
	@Override
	public void onEnable() {
		cash = new BukkitConfig("cash.yml", this);
		cash.saveConfig();
		getCommand("cash").setExecutor(new ComandoCash());
	}

}
