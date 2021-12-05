package me.ninjay.geleiabedrock.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.geleiabedrock.comandos.ComandoDarItens;
import me.ninjay.geleiabedrock.estruturas.ItensAPI;
import me.ninjay.geleiabedrock.eventos.EventosGeral;
import me.ninjay.geleiabedrock.utils.Mine;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		ItensAPI.customCraft();
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player todos : Bukkit.getOnlinePlayers()) {
					for(int x1 = (int)-8; x1 < 8; x1++) {
						for(int y1 = (int)-1.5; y1 < 1.5; y1++) {
							for(int z1 = (int)-8; z1 < 8; z1++) {
								Location loc = new Location(todos.getWorld(), todos.getLocation().getX()+x1, todos.getLocation().getY()+y1, todos.getLocation().getZ()+z1);
							if(todos.getWorld().getBlockAt(loc) != null) {
								if(todos.getWorld().getBlockAt(loc).getType() == Material.FIRE) {
									Location loc1 = new Location(todos.getWorld(), Mine.getRandomDouble(todos.getWorld().getBlockAt(loc).getX()-1, todos.getWorld().getBlockAt(loc).getX()+1), todos.getWorld().getBlockAt(loc).getY()+1, Mine.getRandomDouble(todos.getWorld().getBlockAt(loc).getZ()-1, todos.getWorld().getBlockAt(loc).getZ()+1));
									if(todos.getWorld().getBlockAt(loc1).getType() != Material.FIRE) {
									todos.getWorld().dropItem(loc1, Mine.newItem(Material.GOLDEN_APPLE, null, 1, 1));
									}
								}
							}
							}
						}
					}
				}
			}
		}.runTaskTimer(this, 0L, 20L);
	}

}
