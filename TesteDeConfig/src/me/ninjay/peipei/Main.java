package me.ninjay.peipei;

import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.BukkitConfig;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	
	@Override
	public void onEnable() {
		config = new BukkitConfig("config.yml", this);
		config.set("mensagem", "");
		getCommand("comando").setExecutor(new Config());
	}
	@Override
	public void onDisable() {
	}

}
