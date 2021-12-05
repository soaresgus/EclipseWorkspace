package me.ninjay.picaretayoutuber.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.picaretayoutuber.main.Main;
import me.ninjay.picaretayoutuber.utils.Mine;

public class EventosGeral implements Listener {

	private static boolean robin = false;
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInMainHand().getType() != Material.AIR) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Minguado")) {
				if(e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.EMERALD_ORE) {
					for(ItemStack drops : e.getBlock().getDrops()) {
						e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(drops.getType(), drops.getAmount()*5));
					}
					}
				for(int x = 0; x < 2.5; x++) {
					for(int y = 0; y < 2.5; y++) {
						for(int z = 0; z < 2.5; z++) {
							Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
							Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
							Location loc3 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
							Location loc4 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
							Location loc5 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
							Location loc6 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
							Location loc7 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
							Location loc8 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
							p.getWorld().getBlockAt(loc1).breakNaturally();
							p.getWorld().getBlockAt(loc2).breakNaturally();
							p.getWorld().getBlockAt(loc3).breakNaturally();
							p.getWorld().getBlockAt(loc4).breakNaturally();
							p.getWorld().getBlockAt(loc5).breakNaturally();
							p.getWorld().getBlockAt(loc6).breakNaturally();
							p.getWorld().getBlockAt(loc7).breakNaturally();
							p.getWorld().getBlockAt(loc8).breakNaturally();
						}
					}
				}
				}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Moon")) {
				if(e.getBlock().getType() == Material.GOLD_ORE || e.getBlock().getType() == Material.COAL_ORE || e.getBlock().getType() == Material.IRON_ORE) {
					for(ItemStack drops : e.getBlock().getDrops()) {
						e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(drops.getType(), drops.getAmount()*5));
					}
					}
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Tazer")) {
				if(e.getBlock().getType() == Material.EMERALD_ORE) {
					for(ItemStack drops : e.getBlock().getDrops()) {
						e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(drops.getType(), drops.getAmount()*5));
					}
					}
				if(e.getBlock().getType() == Material.GOLD_ORE) {
					e.getBlock().setType(Material.AIR);
					e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLDEN_APPLE, 5, (short)1));
				}
			}
			}
			}
		}

	@EventHandler
	public void aoTrocar(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		Mine.removeEffects(p);
		robin = false;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(p.getInventory().getItemInMainHand() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
							if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE || p.getInventory().getItemInMainHand().getType() == Material.GOLD_PICKAXE || p.getInventory().getItemInMainHand().getType() == Material.WOOD_PICKAXE || p.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE || p.getInventory().getItemInMainHand().getType() == Material.IRON_PICKAXE) {

			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Minguado")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, false, false), false);
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2, false, false), false);
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 9, false, false), false);
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Moon")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false, false), false);
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Robin")) {
				robin = true;
			}
			}
		}
	}
}
}

		}.runTaskLater(Main.getPlugin(Main.class), 3);
	}
	
	

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if (p.getInventory().getItemInMainHand().getType() != Material.AIR) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Minguado")) {
				for(int x = -7; x < 7; x++) {
					for(int y = -7; y < 7; y++) {
						for(int z = -7; z < 7; z++) {
							Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
							Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
							Location loc3 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
							Location loc4 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
							Location loc5 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()-y, p.getLocation().getZ()+z);
							Location loc6 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()-y, p.getLocation().getZ()-z);
							Location loc7 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()-y, p.getLocation().getZ()-z);
							Location loc8 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()-y, p.getLocation().getZ()+z);
							
							if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc1).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc2).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc3).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc3).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc4).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc5).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc6).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc7).setType(Material.GOLD_ORE);
							}
							if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
								p.getWorld().getBlockAt(loc8).setType(Material.GOLD_ORE);
							}
						}
					}
				}
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Lua")) {
				for(int x = -7; x < 7; x++) {
					for(int y = -7; y < 7; y++) {
						for(int z = -7; z < 7; z++) {
							Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
							Location loc2 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
							Location loc3 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
							Location loc4 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
							Location loc5 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()-y, p.getLocation().getZ()+z);
							Location loc6 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()-y, p.getLocation().getZ()-z);
							Location loc7 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()-y, p.getLocation().getZ()-z);
							Location loc8 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()-y, p.getLocation().getZ()+z);
							
							if(p.getWorld().getBlockAt(loc1).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc1).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc2).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc2).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc3).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc3).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc3).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc3).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc4).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc4).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc5).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc5).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc6).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc6).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc7).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc7).setType(Material.COAL_ORE);
							}
							if(p.getWorld().getBlockAt(loc8).getType() == Material.STONE) {
								p.getWorld().getBlockAt(loc8).setType(Material.COAL_ORE);
							}
						}
					}
				}
			}
		}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().getType() != Material.AIR) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Minguado")) {
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Location loc = new Location(p.getWorld(), p.getEyeLocation().getX()+1, p.getEyeLocation().getY()+1, p.getEyeLocation().getZ()+1, p.getEyeLocation().getYaw(), p.getEyeLocation().getPitch());
					p.getWorld().spawnEntity(loc, EntityType.FIREBALL);
				}
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Jeredy")) {
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					if(p.getWorld().getTime() > 650 && p.getWorld().getTime() < 14000) {
					p.getWorld().setTime(14000);
					}
					if(p.getWorld().getTime() > 14000) {
						p.getWorld().setTime(650);
					}
				}
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if(e.getClickedBlock() != null) {
						Location loc = new Location(p.getWorld(), e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ());
						p.getWorld().getBlockAt(loc).setType(Material.WATER);
					}
				}
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Robin")) {
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
				p.launchProjectile(Arrow.class);
				}
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					p.launchProjectile(Arrow.class);
				}
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Tazer")) {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					for(int x = 0; x < 2.5; x++) {
							for(int z = 0; z < 2.5; z++) {
								if(e.getClickedBlock() != null) {
								Location loc1 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()+z);
								Location loc2 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()-z);
								Location loc3 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()-z);
								Location loc4 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()+z);
								Location loc5 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()+z);
								Location loc6 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()-z);
								Location loc7 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()-z);
								Location loc8 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()+z);
								Location loc9 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()+z);
								Location loc10 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()-z);
								Location loc11 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()-z);
								Location loc12 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()+z);
								Location loc13 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()+z);
								Location loc14 = new Location(p.getWorld(), e.getClickedBlock().getX()+x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()-z);
								Location loc15 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()-z);
								Location loc16 = new Location(p.getWorld(), e.getClickedBlock().getX()-x, e.getClickedBlock().getY()-1, e.getClickedBlock().getZ()+z);
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc1).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc9).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc1).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc2).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc10).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc2).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc3).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc11).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc3).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc4).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc12).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc4).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc5).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc13).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc5).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc6).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc14).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc6).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc7).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc15).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc7).setTypeIdAndData(31, (byte)1, false);
									}
								}
							}
							if(Mine.getChance(0.50)) {
								if(p.getWorld().getBlockAt(loc8).getType() == Material.AIR) {
									if(p.getWorld().getBlockAt(loc16).getType() != Material.GRASS) {
										p.getWorld().getBlockAt(loc8).setTypeIdAndData(31, (byte)1, false);
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

	//@EventHandler
	//public void flechaMove(ProjectileLaunchEvent e) {
	//	if(e.getEntity() != null) {
	//		if(e.getEntity().getType() == EntityType.ARROW) {
	//			if(robin == true) {
	//				new BukkitRunnable() {
	//					
	//					@Override
	//					public void run() {
	//						e.getEntity().getWorld().spigot().playEffect(e.getEntity().getLocation(), Effect.HAPPY_VILLAGER, 0, 0, 0.1F, 0.1F, 0.1F, 10F, 5, 15);
	//						if(e.getEntity().isOnGround()) {
	//							cancel();
	//						}
	//					}
	//				}.runTaskTimer(Main.getPlugin(Main.class), 0L, (long) 0.01);
	//			}
	//		}
	//	}
	//}
	
	@EventHandler
	public void aoFlecha(ProjectileHitEvent e) {
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.ARROW) {
				if(robin == true) {
					new BukkitRunnable() {
						int i = 4;
						@Override
						public void run() {
							i--;
							e.getEntity().getWorld().spigot().playEffect(e.getEntity().getLocation(), Effect.CLOUD, 0, 0, 0.1F, 0.5F, 0.1F, 0.002F, 5, 15);
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


