package me.ninjay.onecash.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.onecash.comandos.ComandoCash;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("template").setExecutor(new ComandoCash());
	}

}
