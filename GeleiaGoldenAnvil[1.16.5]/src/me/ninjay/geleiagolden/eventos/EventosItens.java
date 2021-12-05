package me.ninjay.geleiagolden.eventos;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.geleiagolden.estruturas.ItensAPI;
import me.ninjay.geleiagolden.main.Main;


public class EventosItens implements Listener{

	private static boolean flecha = false;
	private static boolean usando = false;
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(p.getInventory().getItemInMainHand() != null) {
		if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§5Cajado")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Block bloco = p.getTargetBlock(null, 1000);
					Location loc = new Location(p.getWorld(), bloco.getX(), bloco.getY()+1, bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
					p.teleport(loc);
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
					for(int x = (int)-2; x < 2; x++) {
						for(int y = (int)-2; y < 3; y++) {
							for(int z = (int)-2; z < 2; z++) {
								Location locp = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
								p.spawnParticle(Particle.PORTAL, locp, 20, 0.1, 0.1, 0.1, 0.1);
							}
						}
					}
				}
			}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§9Chuva")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR) {
						p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1F, 1F);
						for(int x = (int)-2.5; x < 2.5; x++) {
							for(int z = (int)-2.5; z <2.5; z++) {
								Block bloco = p.getTargetBlock(null, 8);
								Location loc1 = new Location(p.getWorld(), bloco.getX()+x, bloco.getY()+3, bloco.getZ()+z, p.getLocation().getYaw(), 90F);
								p.getWorld().spawnArrow(loc1, new Vector(0, 0, 0), 1F, 1F);
							if(flecha == false) {
								flecha=true;
								new BukkitRunnable() {
									
									@Override
									public void run() {
										for(Arrow flecha : p.getWorld().getEntitiesByClass(Arrow.class)) {
											flecha.remove();
										}
										flecha=false;
									}
								}.runTaskLater(Main.getPlugin(Main.class), 3*20);
							}
							}
						}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Machado")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						new BukkitRunnable() {
							int i = 10;
							@Override
							public void run() {
								if(i == 10) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-6, p.getLocation().getY()-5, p.getLocation().getZ()-6);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+6, p.getLocation().getY()+5, p.getLocation().getZ()+6);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									for(int x = (int)-3.5; x < 3.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+3);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-3);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-3.5; z < 3.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+3, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-3, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
								i--;
								if(i == 8) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-11, p.getLocation().getY()-5, p.getLocation().getZ()-11);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+11, p.getLocation().getY()+5, p.getLocation().getZ()+11);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									for(int x = (int)-5.5; x < 5.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+5);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-5);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-5.5; z < 5.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+5, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-5, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
								if(i == 6) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-13, p.getLocation().getY()-5, p.getLocation().getZ()-13);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+13, p.getLocation().getY()+5, p.getLocation().getZ()+13);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									for(int x = (int)-7.5; x < 7.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+7);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-7);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-7.5; z < 7.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+7, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-7, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
								if(i == 4) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-17, p.getLocation().getY()-5, p.getLocation().getZ()-17);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+17, p.getLocation().getY()+5, p.getLocation().getZ()+17);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									for(int x = (int)-9.5; x < 9.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+9);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-9);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-9.5; z < 9.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+9, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-9, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
								if(i == 2) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-21, p.getLocation().getY()-5, p.getLocation().getZ()-21);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+21, p.getLocation().getY()+5, p.getLocation().getZ()+21);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									for(int x = (int)-11.5; x < 11.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+11);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-11);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-11.5; z < 11.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+11, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-11, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
								if(i == 0) {
									p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									Location loc1b = new Location(p.getWorld(), p.getLocation().getX()-25, p.getLocation().getY()-5, p.getLocation().getZ()-25);
									Location loc2b = new Location(p.getWorld(), p.getLocation().getX()+25, p.getLocation().getY()+5, p.getLocation().getZ()+25);
									for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(loc1b, loc2b))) {
										if(mobs.getType() != EntityType.PLAYER) {
											mobs.setVelocity(new Vector(mobs.getVelocity().getX(), 2, mobs.getVelocity().getZ()));
										}
									}
									cancel();
									for(int x = (int)-13.5; x < 13.5 ; x++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()+13);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+1, p.getLocation().getZ()-13);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
									for(int z = (int)-13.5; z < 13.5 ; z++) {
										Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+13, p.getLocation().getY()+1, p.getLocation().getZ()+z);
										Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-13, p.getLocation().getY()+1, p.getLocation().getZ()-z);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc1, 1, 0.1, 0.1, 0.1, 0.1);
										p.spawnParticle(Particle.EXPLOSION_LARGE, loc2, 1, 0.1, 0.1, 0.1, 0.1);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 3, 3);
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§9Shuriken")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.getInventory().setItemInMainHand(ItensAPI.shuriken());
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3);
				}
			}
		}
	}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§9Chuva")) {
					usando=true;
				}else {
					usando=false;
				}
				}
		}
		}else {
			usando=false;
		}
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("§6Capacete")) {
						Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()-2, p.getLocation().getZ());
						if(p.isOnGround() == false) {
							if(p.isFlying() == false) {
								if(p.getWorld().getBlockAt(loc).getType() == Material.AIR) {
						p.setVelocity(p.getVelocity().setY(-0.15F));
								}
							}
						}
					}
				}
			}
		}
		
		if(p.getInventory().getChestplate() != null) {
			if(p.getInventory().getChestplate().getItemMeta() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("§6Peitoral")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3, false, false));
					}else {
						p.removePotionEffect(PotionEffectType.REGENERATION);
					}
				}
			}
		}else {
			p.removePotionEffect(PotionEffectType.REGENERATION);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5EspadaReta")) {
			for(int x = 0; x < 1.5; x++) {
				for(int y = 0; y < 1.5; y++) {
					for(int z = 0; z < 1.5; z++) {
						Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
						Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
						Location loc3 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
						Location loc4 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
						Location loc5 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
						Location loc6 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
						Location loc7 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
						Location loc8 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
					
						if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
					if(p.getWorld().getBlockAt(loc1).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc1).breakNaturally();
					}	
					
					if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_ORE));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
					if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_ORE));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
						
						if(p.getWorld().getBlockAt(loc2).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc2).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc3).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc4).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc5).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc6).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc7).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_ORE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
						p.getWorld().getBlockAt(loc8).breakNaturally();
						}
						if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
					if(p.getWorld().getBlockAt(loc1).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc1).breakNaturally();
					}	
					
					if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.COAL));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
					if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
						
						if(p.getWorld().getBlockAt(loc2).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc2).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc3).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc4).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc5).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc5).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc6).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc6).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc7).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc7).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.COAL));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc8).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.LAPIS_ORE ) {
						p.getWorld().getBlockAt(loc8).breakNaturally();
						}
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
					if(p.getWorld().getBlockAt(loc1).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc1).breakNaturally();
					}	
					
					if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.DIAMOND));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
					if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
						p.getWorld().getBlockAt(loc2).setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.REDSTONE));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
						
						if(p.getWorld().getBlockAt(loc2).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc2).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc3).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc3).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc4).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc4).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc5).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc5).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc5).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc5).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc6).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc6).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc6).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc6).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc7).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc7).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc7).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc7).breakNaturally();
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.DIAMOND));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						if(p.getWorld().getBlockAt(loc8).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc8).setType(Material.AIR);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.REDSTONE));
								}
							}.runTaskLater(Main.getPlugin(Main.class), 3);
						}
						
						if(p.getWorld().getBlockAt(loc8).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.REDSTONE_ORE ) {
						p.getWorld().getBlockAt(loc8).breakNaturally();
						}
					}
				}
			}
		}
		
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Picareta Totem")) {
			e.setCancelled(true);
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY()+1, e.getBlock().getLocation().getZ());
			e.getBlock().getWorld().dropItem(loc, new ItemStack(e.getBlock().getType()));
		}
	}

	@EventHandler
	public void onDano(EntityDamageEvent e) {
		if(e.getEntity() != null) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				
				if(p.getInventory().getHelmet() != null) {
					if(p.getInventory().getHelmet().getItemMeta() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
							if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("§6Capacete")) {
								if(e.getCause() == DamageCause.FALL) {
									e.setCancelled(true);
								}
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					
					if(p.getInventory().getLeggings() != null) {
						if(p.getInventory().getLeggings().getItemMeta() != null) {
							if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
								if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("§6Calças")) {
									e.getDamager().setFireTicks(40);
								}
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6Botas")) {
						if(e.isSneaking() == true) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 2, false, false));
						}else {
							p.removePotionEffect(PotionEffectType.LEVITATION);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void aoFlecha(ProjectileHitEvent e) {
	if(e.getEntity() != null) {
		if(e.getEntity().getType() == EntityType.SNOWBALL) {
			if(e.getHitEntity() != null) {
				if(e.getHitEntity() instanceof LivingEntity) {
					LivingEntity l = (LivingEntity) e.getHitEntity();
					l.damage(50);
				}
			}
		}
	}
		
	if(usando == true) {
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.ARROW) {
					Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 2);
					new BukkitRunnable() {
						int i = 4;
						@Override
						public void run() {
							i--;
							//e.getEntity().getWorld().spigot().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 0, 0, 0.1F, 0.5F, 0.1F, 0.002F, 5, 15);
							e.getEntity().getWorld().spawnParticle(Particle.REDSTONE, e.getEntity().getLocation(), 3, 0.1, 0.1, 0.1, dust);
							if(i <= 0) {
								cancel();
								i=4;
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 3);
							e.getEntity().remove();
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
			}
		}
	}
	}
	
}
