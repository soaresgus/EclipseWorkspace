package me.ninjay.geleiagolden.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.geleiagolden.comandos.ComandoDarItens;
import me.ninjay.geleiagolden.estruturas.ItensAPI;
import me.ninjay.geleiagolden.eventos.EventosBigorna;
import me.ninjay.geleiagolden.eventos.EventosItens;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosBigorna(), this);
		Bukkit.getPluginManager().registerEvents(new EventosItens(), this);
		
		ItensAPI.recipe();
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Entity entity : Bukkit.getWorld("world").getEntities()) {
					if(entity.getType() != EntityType.PLAYER) {
						if(entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.SPIDER || entity.getType() == EntityType.CREEPER || entity.getType() == EntityType.PIGLIN_BRUTE || entity.getType() == EntityType.PIGLIN || entity.getType() == EntityType.ENDERMAN) {
 						for(int x = (int) -1.5; x <= 1.5 ; x++) {
							for(int y = -255; y <= 255; y++) {
								for(int z = (int) -1.5; z <= 1.5; z++) {
									Location loc = new Location(Bukkit.getWorld("world"), entity.getLocation().getX()+x, entity.getLocation().getY()+y, entity.getLocation().getZ()+z);
								if(entity.getWorld().getBlockAt(loc) != null) {
									if(entity.getWorld().getBlockAt(loc).getType() == Material.CHAIN) {
										if(entity instanceof LivingEntity) {
											LivingEntity e = (LivingEntity) entity;
											e.damage(100);
										}
									}
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
