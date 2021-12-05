package me.ninjay.safemina.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import me.ninjay.safemina.comandos.ComandoEscavar;
import me.ninjay.safemina.comandos.ComandoMina;
import me.ninjay.safemina.eventos.EventosGeral;
import me.ninjay.safemina.utils.BukkitConfig;
import me.ninjay.safemina.utils.Mine;

public class Main extends JavaPlugin {

	public static BukkitConfig config;

	@Override
	public void onEnable() {
		getCommand("escavar").setExecutor(new ComandoEscavar());
		getCommand("mina").setExecutor(new ComandoMina());
		
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		config = new BukkitConfig("config.yml", this);
		config.saveDefaultConfig();
		
		Mine.console("§6[SafeMina] §aMina iniciada.");

		Bukkit.getServer().createWorld(WorldCreator.name(Main.config.getString("MundoEscavar")));
		Bukkit.getServer().createWorld(WorldCreator.name(Main.config.getString("MundoMina")));
	}

	@Override
	public void onDisable() {
		for(Block blocos : EventosGeral.quebrados) {
			Bukkit.getServer().getWorld(Main.config.getString("MundoEscavar")).getBlockAt(blocos.getLocation()).setType(Material.SAND);;
		}
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(EventosGeral.loc.isEmpty() == false) {
			Bukkit.getWorld(Main.config.getString("MundoMina")).createExplosion(EventosGeral.loc.get(all), 80F);
			}else {
				return;
			}
			}
	}
}