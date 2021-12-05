package me.ninjay.craftsaleatorios.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.craftsaleatorios.comandos.ComandoDarItens;
import me.ninjay.craftsaleatorios.estruturas.ItensAPI;
import me.ninjay.craftsaleatorios.eventos.EventosGeral;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("daritens").setExecutor(new ComandoDarItens());
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		Bukkit.getPluginManager().registerEvents(new ItensAPI(), this);
		
		ItensAPI api = new ItensAPI();
		
		api.customRecipe();
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Entity entity : Bukkit.getWorld("world").getEntities()) {
					if(entity.getType() != EntityType.PLAYER) {
						if(entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.ZOMBIE_VILLAGER || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.SPIDER || entity.getType() == EntityType.CREEPER) {
 						for(int x = (int) -1.5; x <= 1.5 ; x++) {
							for(int y = -255; y <= 255; y++) {
								for(int z = (int) -1.5; z <= 1.5; z++) {
									Location loc = new Location(Bukkit.getWorld("world"), entity.getLocation().getX()+x, entity.getLocation().getY()+y, entity.getLocation().getZ()+z);
								if(entity.getWorld().getBlockAt(loc) != null) {
									if(entity.getWorld().getBlockAt(loc).getType() == Material.ACACIA_FENCE) {
										if(entity instanceof LivingEntity) {
											LivingEntity e = (LivingEntity) entity;
											e.damage(e.getMaxHealth());
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
		}.runTaskTimerAsynchronously(this, 0L, 20L);
	}
	
}
