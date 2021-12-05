package me.ninjay.loboscustom.main;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.loboscustom.eventos.EventosGeral;
import me.ninjay.loboscustom.utils.Mine;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventosGeral(), this);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					for(Entity lobo : p.getWorld().getEntitiesByClass(Wolf.class)) {
						if(lobo.getCustomName() != null) {
							if(lobo.getCustomName().contains("grass")) {
								Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
								for(int i = 1; i <= 5; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 2, 0.1, 0.1, 0.1, dust);
								}
								
								if(lobo.getWorld().getBlockAt(lobo.getLocation()).getType() == Material.AIR) {
									lobo.getWorld().getBlockAt(lobo.getLocation()).setType(Material.GRASS);
								}
								
							}
							
							if(lobo.getCustomName().contains("bone")) {
							}
							
							if(lobo.getCustomName().contains("ink")) {
								Particle.DustOptions dust = new Particle.DustOptions(Color.BLACK, 2);
								for(int i = 1; i <= 5; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 20, 0.1, 0.1, 0.1, dust);
								}
								
							}
							
							if(lobo.getCustomName().contains("snow")) {
								if(lobo.getWorld().getBlockAt(lobo.getLocation()).getType() == Material.AIR) {
									lobo.getWorld().getBlockAt(lobo.getLocation()).setType(Material.SNOW);
								}
								
							}
							
							if(lobo.getCustomName().equals("§8firedog")) {
								for(int i = 1; i <= 5; i++) {
									lobo.getWorld().spawnParticle(Particle.FLAME, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 5, 0.1, 0.1, 0.1, 0.1);
								}
								
							}
							
							if(lobo.getCustomName().contains("firework")) {
								Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
								Particle.DustOptions dust2 = new Particle.DustOptions(Color.BLUE, 2);
								Particle.DustOptions dust3 = new Particle.DustOptions(Color.RED, 2);
								Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
								for(int i = 1; i <= 3; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 2, 0.1, 0.1, 0.1, dust);
								}
								
								for(int i = 1; i <= 3; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 2, 0.1, 0.1, 0.1, dust2);
								}
								
								for(int i = 1; i <= 3; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 2, 0.1, 0.1, 0.1, dust3);
								}
								
								for(int i = 1; i <= 3; i++) {
									lobo.getWorld().spawnParticle(Particle.REDSTONE, lobo.getLocation().add(Mine.getRandomDouble(-1.5, 1.5), Mine.getRandomDouble(0, 1.5), Mine.getRandomDouble(-1.5, 1.5)), 2, 0.1, 0.1, 0.1, dust4);
								}
							}
							
							
						}
					}
				}
			}
		}.runTaskTimer(this, 0L, 5L);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					for(Entity lobo : p.getWorld().getEntitiesByClass(Wolf.class)) {
						if(lobo.getCustomName() != null) {
							if(lobo.getCustomName().contains("glow")) {
								lobo.getWorld().getBlockAt(lobo.getLocation().add(0, -1, 0)).setType(Material.GLOWSTONE);
								
							}
						
						}
					}
				}
			}
		}.runTaskTimer(this, 0L, 80L);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					for(Entity lobo : p.getWorld().getEntitiesByClass(Wolf.class)) {
						if(lobo.getCustomName() != null) {
							if(lobo.getCustomName().contains("water")) {
								if(lobo.isInWater()) {
									lobo.setGravity(false);
								}else {
									lobo.setGravity(true);
								}
							}
						
						}
					}
				}
			}
		}.runTaskTimer(this, 0L, 1L);
		
	}

}
