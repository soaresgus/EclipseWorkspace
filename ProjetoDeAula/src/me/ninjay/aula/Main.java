package me.ninjay.aula;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
       getCommand("limparchat").setExecutor(new ComandoLimparChat());
	}

}
