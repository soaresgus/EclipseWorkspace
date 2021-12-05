package me.ninjay.loboscustom.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.loboscustom.main.Main;
import me.ninjay.loboscustom.utils.Mine;


public class EventosGeral implements Listener{
	
	@EventHandler
	public void onClickWolf(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		EquipmentSlot es = e.getHand();
		
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.WOLF) {
				if(e.getRightClicked().getCustomName() == null) {
					if(es.equals(EquipmentSlot.HAND)) {
					if(p.getInventory().getItemInMainHand().getType() == Material.GRASS_BLOCK || p.getInventory().getItemInMainHand().getType() == Material.GRASS) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 2);
							p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
									e.getRightClicked().setCustomName("§8grassdog");
									e.getRightClicked().setCustomNameVisible(false);
									p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
							
						}
					if(p.getInventory().getItemInMainHand().getType() == Material.BONE_MEAL) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8bonedog");
								e.getRightClicked().setCustomNameVisible(false);
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.INK_SAC) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8inkdog");
								e.getRightClicked().setCustomNameVisible(false);
								((LivingEntity) e.getRightClicked()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 6, false , false));
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.SNOWBALL) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8snowdog");
								e.getRightClicked().setCustomNameVisible(false);
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.FIRE_CHARGE) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8firedog");
								e.getRightClicked().setCustomNameVisible(false);
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.FIREWORK_ROCKET) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8fireworkdog");
								e.getRightClicked().setCustomNameVisible(false);
								((LivingEntity) e.getRightClicked()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 6, false , false));
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8waterdog");
								//e.getRightClicked().setGravity(false);
								e.getRightClicked().setCustomNameVisible(false);
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					if(p.getInventory().getItemInMainHand().getType() == Material.GLOWSTONE_DUST) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 2);
						p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getRightClicked().getWorld().spawnParticle(Particle.HEART, e.getRightClicked().getLocation().add(0, 0.5, 0), 15, 0.2, 0.2, 0.2, 0.2);
								e.getRightClicked().setCustomName("§8glowdog");
								e.getRightClicked().setCustomNameVisible(false);
								p.playSound(p.getLocation(), Sound.ENTITY_WOLF_HOWL, 1F, 1F);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5L);	
						
					}
					}
				}else if(e.getRightClicked().getCustomName().equals("§8firedog")) {
					for(int i = 1; i <= 5; i++) {
						e.getRightClicked().getWorld().dropItemNaturally(e.getRightClicked().getLocation().add(0, 0.3, 0), new ItemStack(Material.BLAZE_ROD));
					}
				}
			}
		}
	}

	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntityType() == EntityType.WOLF) {
				if(e.getEntity().getCustomName() != null) {
					if(e.getEntity().getCustomName().contains("grass")) {
						for(int y = 0; y <= 3; y++) {
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.DANDELION, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.POPPY, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.OXEYE_DAISY, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.CORNFLOWER, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(e.getEntity().getCustomName().contains("bone")) {
						for(int y = 0; y <= 3; y++) {
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BONE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BONE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BONE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BONE, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(e.getEntity().getCustomName().contains("snow")) {
						for(int y = 0; y <= 3; y++) {
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.PUMPKIN, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.PUMPKIN, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.PUMPKIN, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.PUMPKIN, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
						}
					}
					
					if(e.getEntity().getCustomName().equals("§8firedog")) {
						for(int y = 0; y <= 3; y++) {
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BLAZE_ROD, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BLAZE_ROD, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BLAZE_ROD, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
							e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.5, 0), new ItemStack(Material.BLAZE_ROD, 64)).setVelocity(new Vector(Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3), Mine.getRandomDouble(-0.3, 0.3)));
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
				if(e.getDamager().getType() == EntityType.WOLF) { 
					if(e.getDamager().getCustomName() != null) {
						if(e.getDamager().getCustomName().contains("water")) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									for(Entity entity : e.getDamager().getWorld().getNearbyEntities(BoundingBox.of(e.getDamager().getLocation().add(-10, -10, -10), e.getDamager().getLocation().add(10, 10, 10)))) {
										if(entity != null) {
											if(entity instanceof LivingEntity) {
												LivingEntity l = (LivingEntity) entity;
												l.damage(2);
												l.getWorld().spawnParticle(Particle.WATER_WAKE, l.getLocation().add(0, 1, 0), 500, 0.1, 0.1, 0.1);
											}
										}
									}
								}
							}.runTaskLater(Main.getPlugin(Main.class), 2);
						}
					}
				}
			}
		}
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					if(e.getDamager().getType() == EntityType.WOLF) {
						if(e.getDamager().getCustomName() != null) {
							if(e.getDamager().getCustomName().contains("bone")) {
								new BukkitRunnable() {
									
									@Override
									public void run() {
										p.setVelocity(new Vector(p.getVelocity().getX(), 2, p.getVelocity().getZ()));
									}
								}.runTaskLater(Main.getPlugin(Main.class), 2);
							}
							if(e.getDamager().getCustomName().contains("snow")) {
								new BukkitRunnable() {
									
									@Override
									public void run() {
										p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10*20, 1));
									}
								}.runTaskLater(Main.getPlugin(Main.class), 2);
							}
							
							if(e.getDamager().getCustomName().contains("firework")) {
								new BukkitRunnable() {
									
									@Override
									public void run() {
										p.setVelocity(new Vector(p.getVelocity().getX(), 1, p.getVelocity().getZ()));
										new BukkitRunnable() {
											int i = 5;
											@Override
											public void run() {
												i--;
												if(i <= 0) {
													cancel();
												}
												p.spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 20, 0.1, 0.1, 0.1, 0.1);
											}
										}.runTaskTimer(Main.getPlugin(Main.class), 0L, 3L);
									}
								}.runTaskLater(Main.getPlugin(Main.class), 2);
								
							}
						}
					}
				}
				
				if(e.getEntity() instanceof Wolf) {
					if(e.getDamager() instanceof Player) {
						if(e.getEntity().getCustomName() != null) {
							if(e.getEntity().getCustomName().contains("firework")) {
								new BukkitRunnable() {
									
									@Override
									public void run() {
										e.getEntity().setVelocity(new Vector(e.getEntity().getVelocity().getX(), 1, e.getEntity().getVelocity().getZ()));
										new BukkitRunnable() {
											int i = 5;
											@Override
											public void run() {
												i--;
												if(i <= 0) {
													cancel();
												}
												e.getEntity().getWorld().spawnParticle(Particle.FIREWORKS_SPARK, e.getEntity().getLocation(), 20, 0.1, 0.1, 0.1, 0.1);
											}
										}.runTaskTimer(Main.getPlugin(Main.class), 0L, 3L);
									}
								}.runTaskLater(Main.getPlugin(Main.class), 2);
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onWolf(EntityTargetLivingEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getTarget() != null) {
				if(!(e.getTarget() instanceof Player)) {
					if(e.getEntity().getType() == EntityType.WOLF) {
						if(e.getEntity().getCustomName() != null) {
							if(e.getEntity().getCustomName().equals("§8firedog")) {
								Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getX()+1, e.getEntity().getLocation().getY(), e.getEntity().getLocation().getZ()+1, e.getEntity().getLocation().getYaw(), e.getEntity().getLocation().getPitch());
								e.getEntity().getWorld().spawnEntity(loc, EntityType.FIREBALL);
							}
						}
					}
				}
			}
		}
	}
	
}
