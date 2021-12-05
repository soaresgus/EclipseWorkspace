package br.beta.eletron.rankup.api;

import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin{
	
	public void onEnable() {
		System.out.println("Ativado");
		Mine.registerDefaults();
	}
	public void onDisable() {
		System.out.println("Desativado");
		
	}

	

}
