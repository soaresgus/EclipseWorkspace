package me.ninjay.dropsmob.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.dropsmob.estruturas.Drops;
import me.ninjay.dropsmob.estruturas.DropsAPI;
import me.ninjay.dropsmob.estruturas.DropsControler;
import me.ninjay.dropsmob.estruturas.DropsManager;
import me.ninjay.utils.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§6[NinjaDropsMob] §aPlugin ativado com sucesso!");
		Bukkit.getPluginManager().registerEvents(new DropsControler(), this);
		
		StorageAPI.register(Drops.class);
		StorageAPI.register(DropsManager.class);
		
		DropsAPI.reload();
	}

}
