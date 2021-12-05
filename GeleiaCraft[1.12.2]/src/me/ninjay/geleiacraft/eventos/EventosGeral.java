package me.ninjay.geleiacraft.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import me.ninjay.geleiacraft.estruturas.ItensAPI;
import me.ninjay.geleiacraft.main.Main;
import me.ninjay.geleiacraft.utils.Mine;

public class EventosGeral implements Listener{
	
	private static boolean on = false;
	
	public static Inventory menu = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, " ");
	private static boolean usando = false;
	private static boolean armor = false;
	
	@EventHandler
	public void onEscudo(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getEntityType() == EntityType.PLAYER) {
					Player p = (Player) e.getEntity();
					if(p.isBlocking() == true) {
						if(e.getEntity() instanceof LivingEntity) {
							LivingEntity entity = (LivingEntity) e.getDamager();
							entity.damage(entity.getMaxHealth()/2);
							p.getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
							p.getWorld().spigot().playEffect(e.getEntity().getLocation(), Effect.EXPLOSION_LARGE, 0, 0, 0.1F, 0.1F, 0.1F, 0.002F, 1, 15);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getType() == Material.OBSERVER) {
					e.setCancelled(true);
					p.openInventory(menu);
				}
			}
		}
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Axe Axe Axe")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR) {
						for(int i = 0; i<= 10; i++) {
							Location loc = new Location(p.getWorld(), p.getEyeLocation().getX()+1, p.getEyeLocation().getY(), p.getEyeLocation().getZ()+1, p.getEyeLocation().getYaw(), p.getEyeLocation().getPitch());
							p.getWorld().spawnEntity(loc, EntityType.WITHER_SKULL);
							Block bloco = p.getTargetBlock(null, 500);
							Location loc2 = new Location(p.getWorld(), bloco.getX(), bloco.getY()+1, bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
							p.getWorld().strikeLightning(loc2);
						}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bow Bow Bow")) {
					e.setCancelled(true);
					if(e.getAction() == Action.RIGHT_CLICK_AIR) {
						if(on == false) {
							on=true;
							new BukkitRunnable() {
								
								@Override
								public void run() {
									if(on == true) {
									p.launchProjectile(Arrow.class);
									}else {
										cancel();
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
						}else {
							on=false;
						}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Sword Sword Sword Sword Sword")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						Block bloco = p.getTargetBlock(null, 10);
					for(int i = (int)-2.5; i<= 2.5; i++) {
						Location loc = new Location(p.getWorld(), bloco.getX()+i, bloco.getY()+5, bloco.getZ()+i, p.getLocation().getYaw(), p.getLocation().getPitch());
						Location loc2 = new Location(p.getWorld(), bloco.getX()-i, bloco.getY()+5, bloco.getZ()-i, p.getLocation().getYaw(), p.getLocation().getPitch());
						Location loc3 = new Location(p.getWorld(), bloco.getX()+i, bloco.getY()+5, bloco.getZ()-i, p.getLocation().getYaw(), p.getLocation().getPitch());
						Location loc4 = new Location(p.getWorld(), bloco.getX()-i, bloco.getY()+5, bloco.getZ()+i, p.getLocation().getYaw(), p.getLocation().getPitch());
						ArmorStand espada = p.getWorld().spawn(loc, ArmorStand.class);
						espada.setCanPickupItems(false);
						espada.setArms(true);
						espada.setInvulnerable(true);
						espada.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
						espada.setBasePlate(false);
						espada.setRightArmPose(new EulerAngle(-5, 5, 0));
						espada.setCustomName("espada");
						espada.setVisible(false);
						espada.setCanPickupItems(false);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(espada.isOnGround() == true) {
									espada.getWorld().strikeLightning(espada.getLocation());
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1*20);
						
						ArmorStand espada2 = p.getWorld().spawn(loc2, ArmorStand.class);
						espada2.setCanPickupItems(false);
						espada2.setArms(true);
						espada2.setInvulnerable(true);
						espada2.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
						espada2.setBasePlate(false);
						espada2.setRightArmPose(new EulerAngle(-5, 5, 0));
						espada2.setCustomName("espada");
						espada2.setVisible(false);
						espada2.setCanPickupItems(false);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(espada2.isOnGround() == true) {
									espada2.getWorld().strikeLightning(espada2.getLocation());
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1*20);
						
						ArmorStand espada3 = p.getWorld().spawn(loc3, ArmorStand.class);
						espada3.setCanPickupItems(false);
						espada3.setArms(true);
						espada3.setInvulnerable(true);
						espada3.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
						espada3.setBasePlate(false);
						espada3.setRightArmPose(new EulerAngle(-5, 5, 0));
						espada3.setCustomName("espada");
						espada3.setVisible(false);
						espada3.setCanPickupItems(false);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(espada3.isOnGround() == true) {
									espada3.getWorld().strikeLightning(espada3.getLocation());
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1*20);
						
						ArmorStand espada4 = p.getWorld().spawn(loc4, ArmorStand.class);
						espada4.setCanPickupItems(false);
						espada4.setArms(true);
						espada4.setInvulnerable(true);
						espada4.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
						espada4.setBasePlate(false);
						espada4.setRightArmPose(new EulerAngle(-5, 5, 0));
						espada4.setCustomName("espada");
						espada4.setVisible(false);
						espada4.setCanPickupItems(false);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(espada4.isOnGround() == true) {
									espada4.getWorld().strikeLightning(espada4.getLocation());
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1*20);
					}
					
					
						
					if(armor == false) {
						armor = true;
						new BukkitRunnable() {
							int i = 10;
							@Override
							public void run() {
								i--;
							if(i <= 0) {
								cancel();
								armor = false;
								for(ArmorStand stand : p.getWorld().getEntitiesByClass(ArmorStand.class)) {
									if(stand.getCustomName().contains("espada")) {
										stand.remove();
									}
								}
							}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Diamond Diamond")) {
					for(int i = 1; i <= 15; i++) {
						Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-i, p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
						p.spigot().playEffect(loc2, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);

						    double rotation = (p.getLocation().getYaw() - 180) % 360;
					        if (rotation < 0) {
					            rotation += 360.0;
					        }
					        if (0 <= rotation && rotation < 22.5) {
					           // return "N";
					        	Location locN = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ()-i, p.getLocation().getYaw(), p.getLocation().getPitch());
								p.spigot().playEffect(locN, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);
								p.getWorld().createExplosion(locN, 5F);
					        } else if (22.5 <= rotation && rotation < 67.5) {
					           // return "NE";
					        } else if (67.5 <= rotation && rotation < 112.5) {
					           // return "E";
					        	Location locE = new Location(p.getWorld(), p.getLocation().getX()+i, p.getLocation().getY()+1, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
					        	p.getWorld().createExplosion(locE, 5F);
					        	p.spigot().playEffect(locE, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);
					        } else if (112.5 <= rotation && rotation < 157.5) {
					            //return "SE";
					        } else if (157.5 <= rotation && rotation < 202.5) {
					           // return "S";
					        	Location locS = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ()+i, p.getLocation().getYaw(), p.getLocation().getPitch());
					        	p.getWorld().createExplosion(locS, 5F);
					        	p.spigot().playEffect(locS, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);
					        } else if (202.5 <= rotation && rotation < 247.5) {
					            //return "SW";
					        } else if (247.5 <= rotation && rotation < 292.5) {
					            //return "W";
					        	Location locW = new Location(p.getWorld(), p.getLocation().getX()-i, p.getLocation().getY()+1, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
					        	p.getWorld().createExplosion(locW, 5F);
					        	p.spigot().playEffect(locW, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);
					        } else if (292.5 <= rotation && rotation < 337.5) {
					           // return "NW";
					        } else if (337.5 <= rotation && rotation < 360.0) {
					           // return "N";
					        	Location locN = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+1, p.getLocation().getZ()-i, p.getLocation().getYaw(), p.getLocation().getPitch());
					        	p.getWorld().createExplosion(locN, 5F);
					        	p.spigot().playEffect(locN, Effect.CLOUD, 1, 255, 0.1F, 0.1F, 0.1F, 0.002F, 5, 15);
					        } else {
					           // return null;
					        }
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Flint And Steel Steel Steel")) {
					if(e.getClickedBlock() != null) {
					for(int i = 0; i <= 500; i++) {
						Location loc = new Location(p.getWorld(), Mine.getRandomDouble(e.getClickedBlock().getLocation().getX()-5, e.getClickedBlock().getX()+5), Mine.getRandomDouble(e.getClickedBlock().getY(), e.getClickedBlock().getY()+5), Mine.getRandomDouble(e.getClickedBlock().getZ()-5, e.getClickedBlock().getZ()+5));
						if(p.getWorld().getBlockAt(loc).getType() == Material.AIR) {
							p.getWorld().getBlockAt(loc).setType(Material.FIRE);
						}
					}
					}
				}
			}
		}
		}
	}
	
	@EventHandler
	public void danoExplo(EntityDamageEvent e) {
		
	if(e.getEntity() != null) {
		if(e.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
			if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.diamond)) {
			if(e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
				e.setCancelled(true);
			}
		}
		}
	}
	}
	
	@EventHandler
	public void flecha(ProjectileHitEvent e) {
		
	if(e.getEntity() != null) {
		if(e.getEntityType() == EntityType.ARROW) {
			e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
			e.getEntity().getWorld().spigot().playEffect(e.getEntity().getLocation(), Effect.EXPLOSION_LARGE, 0, 0, 0.1F, 0.1F, 0.1F, 0.002F, 1, 15);
		}
	}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dWooden Pick Pick Pick")) {
					  double rot = (p.getLocation().getYaw() - 90) % 360;
					    if (rot < 0) {
					        rot += 360.0;
					    }
					    if (0 <= rot && rot < 67.5) {
					       // return "N";
					    	Location loc1 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()+2);
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()+1);
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
					    } else if (67.5 <= rot && rot < 157.5) {
					        //return "E";
					    } else if (157.5 <= rot && rot <247.5) {
					       // return "S";
					    } else if (247.5 <= rot && rot < 360.0) {
					       // return "W";
					    } 
					    
					    double rotation = (p.getLocation().getYaw() - 180) % 360;
				        if (rotation < 0) {
				            rotation += 360.0;
				        }
				        if (0 <= rotation && rotation < 22.5) {
				           // return "N";
				        	Location loc1 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()-2);
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()-1);
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
				        } else if (22.5 <= rotation && rotation < 67.5) {
				           // return "NE";
				        } else if (67.5 <= rotation && rotation < 112.5) {
				           // return "E";
				        	Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+1, e.getBlock().getY(), e.getBlock().getZ());
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+2, e.getBlock().getY(), e.getBlock().getZ());
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
				        } else if (112.5 <= rotation && rotation < 157.5) {
				            //return "SE";
				        } else if (157.5 <= rotation && rotation < 202.5) {
				           // return "S";
				        	Location loc1 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()+2);
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()+1);
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
				        } else if (202.5 <= rotation && rotation < 247.5) {
				            //return "SW";
				        } else if (247.5 <= rotation && rotation < 292.5) {
				            //return "W";
				        	Location loc1 = new Location(p.getWorld(), e.getBlock().getX()-1, e.getBlock().getY(), e.getBlock().getZ());
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX()-2, e.getBlock().getY(), e.getBlock().getZ());
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
				        } else if (292.5 <= rotation && rotation < 337.5) {
				           // return "NW";
				        } else if (337.5 <= rotation && rotation < 360.0) {
				           // return "N";
				        	Location loc1 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()-2);
					    	Location loc2 = new Location(p.getWorld(), e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()-1);
					    	p.getWorld().getBlockAt(loc1).breakNaturally();
					    	p.getWorld().getBlockAt(loc2).breakNaturally();
				        } else {
				           // return null;
				        }
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dStone Pick Pick Pick")) {
					if(e.getBlock().getType() == Material.IRON_ORE) {
						e.getBlock().setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
					if(e.getBlock().getType() == Material.GOLD_ORE) {
						e.getBlock().setType(Material.AIR);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§dIron Pick Pick Pick")) {
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
											p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc1).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
										p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_INGOT));
									}
								}.runTaskLater(Main.getPlugin(Main.class), 3);
							}
							if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
								p.getWorld().getBlockAt(loc2).setType(Material.AIR);
								new BukkitRunnable() {
									
									@Override
									public void run() {
										p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc3).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc4).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc5).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc6).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc7).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_INGOT));
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
											p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc8).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								
								if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
								p.getWorld().getBlockAt(loc8).breakNaturally();
								}
								
								
							}
						}
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Pick Pick Pick")) {
					ArrayList<ItemStack> itens = new ArrayList<>();
					itens.clear();
					itens.add(new ItemStack(Material.DIAMOND));
					itens.add(new ItemStack(Material.EMERALD));
					itens.add(new ItemStack(Material.GOLD_INGOT));
					itens.add(new ItemStack(Material.IRON_INGOT));
					if(Mine.getChance(0.50)) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.getWorld().getBlockAt(e.getBlock().getLocation()).getWorld().dropItem(e.getBlock().getLocation(), Mine.getRandomItem(itens));
							}
						}.runTaskLater(Main.getPlugin(Main.class), 3);
					}
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
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Pick Pick Pick")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, false, false));
				}else {
					p.removePotionEffect(PotionEffectType.FAST_DIGGING);
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Diamond Diamond Diamond")) {
					if(p.getGameMode() == GameMode.SURVIVAL) {
						p.setAllowFlight(true);
						p.setFlying(true);
					}
				}else if(p.getGameMode() == GameMode.SURVIVAL){
					p.setFlying(false);
				}
			}
		}
		}
	}
	
	@EventHandler
	public void woodpick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
	if(usando == false) {
		if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
			if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.WOOD_PICKAXE) {
				if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
				if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.WOOD_PICKAXE) {
					if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.WOOD_PICKAXE) {
						//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
						//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
							if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
									//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
									//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
										if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
										if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
												menu.setItem(Mine.getPosition(2, 7), ItensAPI.woodpic);
												p.getOpenInventory().close();
												p.openInventory(menu);
												p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
												usando = true;
											//}
										//}
									//}
								//}
									//}
									//}
								//}
								//}
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
		}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
			usando = false;
	}
		}
	}

	@EventHandler
	public void stonePick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STONE_PICKAXE) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.STONE_PICKAXE) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.STONE_PICKAXE) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.stonepic);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													//}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
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
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}

	@EventHandler
	public void ironPick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_PICKAXE) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_PICKAXE) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.IRON_PICKAXE) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.ironpic);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													//}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
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
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}
	
	@EventHandler
	public void dimaPick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND_PICKAXE) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND_PICKAXE) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.dimapic());
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													//}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
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
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}

	@EventHandler
	public void dimaAxe(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND_AXE) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND_AXE) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND_AXE) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.dimaaxe());
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													//}
												//}
											//}
										//}
											//}
											//}
										}
										}
										//}
									//}
								}
								}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}

	@EventHandler
	public void bow(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STRING) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.BOW) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.STRING) {
									//if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									//if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.BOW) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.STRING) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.BOW) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.bowbow());
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													}
												}
											//}
										//}
											//}
											//}
										}
										}
										//}
									//}
								}
								}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}

	@EventHandler
	public void espada(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				//if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					//if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STRING) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND_SWORD) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.STRING) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.DIAMOND_SWORD) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.BOW) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.STRING) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.dimaespada());
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
												//	}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
										//}
									//}
								//}
								//}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}

	@EventHandler
	public void espadaespada(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				//if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					//if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STRING) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).isSimilar(ItensAPI.dimaespada())) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.STRING) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).isSimilar(ItensAPI.dimaespada())) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.BOW) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.STRING) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.dimaespadaespada);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
												//	}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
										//}
									//}
								//}
								//}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}
	
	@EventHandler
	public void diamond(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
									//if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									//if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.DIAMOND) {
													if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.diamond);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													}
												}
											}
										}
											}
											}
										}
										}
										//}
									//}
								}
								}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}
	
	@EventHandler
	public void flint(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				//if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					//if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STRING) {
						//if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						//if(e.getInventory().getItem(Mine.getPosition(1, 4)).isSimilar(ItensAPI.dimaespada())) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.FLINT_AND_STEEL) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								//if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.STRING) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.FLINT_AND_STEEL) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										//if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.BOW) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.FLINT_AND_STEEL) {
												//if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												//if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.flint);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
												//	}
												//}
											//}
										//}
											//}
											//}
										//}
										//}
										//}
									//}
								//}
								//}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}
	
	@EventHandler
	public void escudo(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory() == menu) {
			if(usando == false) {
				//if(e.getInventory().getItem(Mine.getPosition(1, 3)) != null) {
					//if(e.getInventory().getItem(Mine.getPosition(1, 3)).getType() == Material.STRING) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)) != null) {
						if(e.getInventory().getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND_SWORD) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)) != null) {
							//if(e.getInventory().getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND_PICKAXE) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)) != null) {
								if(e.getInventory().getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND_SWORD) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null) {
									if(e.getInventory().getItem(Mine.getPosition(2, 4)).getType() == Material.SHIELD) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
										if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND_SWORD) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)) != null) {
											//if(e.getInventory().getItem(Mine.getPosition(3, 3)).getType() == Material.STRING) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)) != null) {
												if(e.getInventory().getItem(Mine.getPosition(3, 4)).getType() == Material.DIAMOND_SWORD) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)) != null) {
													//if(e.getInventory().getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
														menu.setItem(Mine.getPosition(2, 7), ItensAPI.escudo);
														p.getOpenInventory().close();
														p.openInventory(menu);
														p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
														usando = true;
													}
												}
											}
										}
											//}
											//}
										//}
										//}
										//}
									//}
								//}
								//}
							}
							}
						}
						}
					}
					}
				}
	if(usando == true) {
		e.getInventory().setItem(Mine.getPosition(1, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(1, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(2, 9), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 1), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 2), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 3), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 4), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 5), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 6), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 7), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 8), new ItemStack(Material.AIR));
		e.getInventory().setItem(Mine.getPosition(3, 9), new ItemStack(Material.AIR));
		usando = false;
	}
		}
	}
	
}
