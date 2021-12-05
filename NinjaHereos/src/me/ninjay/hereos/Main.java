package me.ninjay.hereos;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("givecabine").setExecutor(new Pegar());
	}

}
