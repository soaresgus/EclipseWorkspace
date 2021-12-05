package me.ninjay.omegakibe.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.omegakibe.comandos.ComandoDarMoeda;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("darmoeda").setExecutor(new ComandoDarMoeda());
	}
	

}
