package me.ninjay.megataymaquinas.main;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.megataymaquinas.comandos.ComandoMaquina;
import me.ninjay.megataymaquinas.estruturas.Maquina;
import me.ninjay.megataymaquinas.estruturas.MaquinaAPI;
import me.ninjay.megataymaquinas.estruturas.MaquinaControler;
import me.ninjay.megataymaquinas.estruturas.MaquinaManager;
import me.ninjay.megataymaquinas.estruturas.Refinaria;
import me.ninjay.megataymaquinas.estruturas.RefinariaAPI;
import me.ninjay.megataymaquinas.estruturas.RefinariaManager;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;

public class Main extends JavaPlugin{
	
	public static BukkitConfig config;
	public static BukkitConfig locations;
	
	public HashMap<Player, List<Location>> Maquinas = new HashMap<>();
	
	@Override
	public void onEnable() {
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		locations = new BukkitConfig("locations.yml", this);
		locations.saveConfig();
		
		StorageAPI.register(Maquina.class);
		StorageAPI.register(MaquinaManager.class);
		
		StorageAPI.register(Refinaria.class);
		StorageAPI.register(RefinariaManager.class);
		
		RefinariaAPI.reload();
		
		MaquinaAPI.reload();
        
		Bukkit.getPluginManager().registerEvents(new MaquinaControler(), this);
		 
		getCommand("maquina").setExecutor(new ComandoMaquina());
		
		loadMaquinas();
		saveMaquinas();
		
	}
	
	@SuppressWarnings("unchecked")
	private void loadMaquinas() {
		for(String player : locations.getConfig().getKeys(false)) {
			Maquinas.put(Bukkit.getPlayer(player), (List<Location>)locations.getConfig().get(player));
		}
	}
	
	public void saveMaquinas() {
		for(Player player : Maquinas.keySet()) {
			if(player == null) {
				locations.saveConfig();
			}else {
			locations.getConfig().set(player.getName(), Maquinas.get(player));
			locations.saveConfig();
		}
		}
	}
}

			
