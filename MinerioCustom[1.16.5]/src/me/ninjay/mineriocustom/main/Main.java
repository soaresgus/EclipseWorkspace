package me.ninjay.mineriocustom.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjay.mineriocustom.comandos.ComandoDarItens;
import me.ninjay.mineriocustom.estruturas.Minerio;
import me.ninjay.mineriocustom.estruturas.MinerioAPI;
import me.ninjay.mineriocustom.estruturas.MinerioManager;
import me.ninjay.mineriocustom.eventos.EventosGeral;
import me.ninjay.mineriocustom.utils.BukkitStorables;
import me.ninjay.mineriocustom.utils.StorageAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		BukkitStorables.load();
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		StorageAPI.register(Minerio.class);
		StorageAPI.register(MinerioManager.class);
		
		MinerioAPI.reload();
	}

}
