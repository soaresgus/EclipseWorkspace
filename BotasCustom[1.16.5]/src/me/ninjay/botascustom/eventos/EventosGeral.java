package me.ninjay.botascustom.eventos;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.ninjay.botascustom.main.Main;
import me.ninjay.botascustom.utils.Mine;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("agua")) {
					if(p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType() == Material.LAVA) {
						p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.OBSIDIAN);
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("gelo")) {
					if(p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType() == Material.WATER) {
						p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.BLUE_ICE);
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("prismarine")) {
					if(p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType() == Material.WATER) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 10, false, false));
					}else {
						p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
					}
				}else {
					p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
				}
			}else {
				p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
			}
		}else {
			p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("esponja")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int z = (int)-1.5; z <= 1.5; z++) {
								for(int y = (int)-200; y <= 200; y++) {
									if(p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).getType() == Material.WATER) {
								p.getWorld().getBlockAt(p.getLocation().add(x, y, z)).setType(Material.AIR);
							}
						}
					}
				}
			}
		}
	}
	}
	
	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("aranha")) {
					if(e.isSneaking() == true) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 2, false, false));
					}else {
						p.removePotionEffect(PotionEffectType.LEVITATION);
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("perola")) {
					if(e.isSneaking() == true) {
						p.teleport(p.getTargetBlock(null, 500).getLocation());
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int y = (int)-1.5; y <= 1.5; y++) {
								for(int z = (int)-1.5; z <= 1.5; z++) {
									p.spawnParticle(Particle.PORTAL, p.getLocation().add(x, y, z), 50, 0.1, 0.1, 0.1);
								}
							}
						}
						p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("slime")) {
					if(e.isSneaking() == true) {
						new BukkitRunnable() {
							int i = 5;
							@Override
							public void run() {
								i--;
								p.spawnParticle(Particle.SLIME, p.getLocation(), 200, 2, 2, 2);
								p.playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1F, 1F);
								
								if(i <= 0) {
									cancel();
									p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1F, 1F);
									p.setVelocity(new Vector(p.getVelocity().getX(), 2, p.getVelocity().getY()));
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 0L, 5L);
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("obsidian")) {
					if(p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType() == Material.LAVA) {
						p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.OBSIDIAN);
					}
				}
			}
		}
	}
}
