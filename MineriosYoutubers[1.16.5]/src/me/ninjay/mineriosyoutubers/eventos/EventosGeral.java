package me.ninjay.mineriosyoutubers.eventos;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.mineriosyoutubers.estruturas.ItensAPI;
import me.ninjay.mineriosyoutubers.main.Main;
import me.ninjay.mineriosyoutubers.utils.Mine;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onBreakOre(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.RED_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.minguadodrop);
		}
		
		if(e.getBlock().getType() == Material.PINK_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.bunnydrop);
		}
		
		if(e.getBlock().getType() == Material.CYAN_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.luadrop);
		}
		
		if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
			e.setDropItems(false);
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.jeredydrop);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
	
		if(e.getItem() != null) {
			if(e.getItem().getItemMeta().getDisplayName().contains("Espada do Minguado")) {
				if(e.getAction().toString().contains("RIGHT")) {
					if(Mine.getChance(0.50)) {
						for(int i = 0; i <= 5; i++) {
							p.getWorld().dropItem(p.getLocation().add(0 ,1, 0), Mine.newItem(Material.COCOA_BEANS, "§fChocolate", 64));
						}
					}else {
						Spider spider = p.getWorld().spawn(p.getLocation().add(0, 1, 0), Spider.class);
						spider.setCustomName("§fMiranha");
						spider.setCustomNameVisible(true);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Minguado")) {
						if(p.isSneaking() == false) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.setVelocity(p.getLocation().getDirection().multiply(8.0));
									p.playSound(p.getLocation(), Sound.ENTITY_COW_DEATH, 1F, 1F);
									for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-8, -8, -8), p.getLocation().add(8, 8, 8)))) {
										if(entity != p) {
										entity.setVelocity(entity.getVelocity().add(new Vector(0, 2, 0)));
										}
									}
								}
							}.runTaskLater(Main.getPlugin(Main.class), 2*20);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Picareta da Lua")) {
						if(p.getInventory().getItemInOffHand() != null && p.getInventory().getItemInOffHand().getType() != Material.AIR) {
							e.setDropItems(false);
							p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), p.getInventory().getItemInOffHand());
						}
					}
				}
			}
		}
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Pa da Bunny")) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.PURPLE_CONCRETE_POWDER);
									p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.BLUE_CONCRETE_POWDER);
											p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.LIGHT_BLUE_CONCRETE_POWDER);
													p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
													new BukkitRunnable() {
														
														@Override
														public void run() {
															p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.LIME_CONCRETE_POWDER);
															p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
															new BukkitRunnable() {
																
																@Override
																public void run() {
																	p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.YELLOW_CONCRETE_POWDER);
																	p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
																	new BukkitRunnable() {
																		
																		@Override
																		public void run() {
																			p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.ORANGE_CONCRETE_POWDER);
																			p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
																			new BukkitRunnable() {
																				
																				@Override
																				public void run() {
																					p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 15, 0)).setType(Material.RED_CONCRETE_POWDER);
																					p.getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_ANVIL_FALL, 1F, 1F);
																					new BukkitRunnable() {
																						
																						@Override
																						public void run() {
																							p.getWorld().strikeLightningEffect(p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 8, 0)).getLocation());
																							for(int i = 0; i <= 15; i++) {
																								p.getWorld().dropItemNaturally(p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 8.3, 0)).getLocation(), new ItemStack(Material.TOTEM_OF_UNDYING));
																								p.getWorld().spawnParticle(Particle.CLOUD, p.getWorld().getBlockAt(e.getBlock().getLocation().add(0, 8.3, 0)).getLocation(), 50, 0.1, 0.1, 0.1);
																							}
																						}
																					}.runTaskLater(Main.getPlugin(Main.class), 25);
																				}
																			}.runTaskLater(Main.getPlugin(Main.class), 10);
																		}
																	}.runTaskLater(Main.getPlugin(Main.class), 10);
																}
															}.runTaskLater(Main.getPlugin(Main.class), 10);
														}
													}.runTaskLater(Main.getPlugin(Main.class), 10);
												}
											}.runTaskLater(Main.getPlugin(Main.class), 10);
										}
									}.runTaskLater(Main.getPlugin(Main.class), 10);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 10);
						}
					}
				}
			}
		}

	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getDamager() instanceof Player) {
					Player p = (Player) e.getDamager();
					
					if(p.getInventory().getItemInMainHand() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Machado do Jeredy")) {
									p.getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 1, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 2, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 0, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 0, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 0, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 0, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 0, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 0, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 0, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 0, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 0, -1)).setType(Material.ICE);
									
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 1, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 1, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 1, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 1, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 1, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 1, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 1, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 1, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 1, -1)).setType(Material.ICE);
									
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 2, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 2, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 2, 1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 2, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 2, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(0, 2, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(-1, 2, -1)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 2, 0)).setType(Material.ICE);
									p.getWorld().getBlockAt(e.getEntity().getLocation().add(1, 2, -1)).setType(Material.ICE);
									
									p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1F, 1F);
								}
							}
						}
					}
			
				}
				
				if(e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					
					if(p.getInventory().getChestplate() != null) {
						if(p.getInventory().getChestplate().getItemMeta() != null) {
							if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Lua")) {
									e.getDamager().setVelocity(e.getDamager().getLocation().getDirection().multiply(-20.0));
								}
							}
						}
					}
				}
			}
		}
		
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null || p.getInventory().getChestplate() != null || p.getInventory().getLeggings() != null || p.getInventory().getBoots() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null || p.getInventory().getChestplate().getItemMeta() != null || p.getInventory().getLeggings().getItemMeta() != null || p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null || p.getInventory().getChestplate().getItemMeta().getDisplayName() != null || p.getInventory().getLeggings().getItemMeta().getDisplayName() != null || p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Bunny") || p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Bunny") || p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Bunny") || p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Bunny")) {
						/*ArrayList<Material> list = new ArrayList<>();
						list.add(Material.BLACK_CONCRETE);
						list.add(Material.BROWN_CONCRETE);
						list.add(Material.GRAY_CONCRETE);
						list.add(Material.LIME_CONCRETE);
						list.add(Material.GREEN_CONCRETE);
						list.add(Material.YELLOW_CONCRETE);
						list.add(Material.ORANGE_CONCRETE);
						if(p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType() == Material.AIR) {
							p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType((Mine.getRandom(list)));
						}*/
						if(p.getWorld().getBlockAt(p.getLocation()).getType() == Material.AIR) {
							p.getWorld().getBlockAt(p.getLocation()).setType(Material.FIRE);
						}
					}
				}
			}
		}
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Jeredy")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15*20, 1));
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15*20, 4));
						p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15*20, 1));
					if(!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 4));
					}
					}else {
						p.removePotionEffect(PotionEffectType.SPEED);
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
					}
				}else {
					p.removePotionEffect(PotionEffectType.SPEED);
					p.removePotionEffect(PotionEffectType.REGENERATION);
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				}
			}else {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.REGENERATION);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
			}
		}else {
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.REGENERATION);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		}
	}
}



