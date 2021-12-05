package me.ninjay.kustspawners.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.kustspawners.comandos.ComandoSetarMob;
import me.ninjay.kustspawners.estruturas.Drops;
import me.ninjay.kustspawners.estruturas.DropsAPI;
import me.ninjay.kustspawners.estruturas.DropsControler;
import me.ninjay.kustspawners.estruturas.DropsManager;
import me.ninjay.kustspawners.eventos.EventosGeral;
import me.ninjay.kustspawners.utils.BukkitConfig;
import me.ninjay.utils.utils.Storable;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("setarmob").setExecutor(new ComandoSetarMob());
		Bukkit.getPluginManager().registerEvents(new ComandoSetarMob(), this);
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new DropsControler(), this);
		
		for(World worlds : Bukkit.getWorlds()) {
			for(Monster mobs : worlds.getEntitiesByClass(Monster.class)) {
				mobs.remove();
			}
			for(Animals mobs : worlds.getEntitiesByClass(Animals.class)) {
				mobs.remove();
			}
		}
		
		StorageAPI.register(Drops.class);
		StorageAPI.register(DropsManager.class);
		DropsAPI.reload();
	}

}
