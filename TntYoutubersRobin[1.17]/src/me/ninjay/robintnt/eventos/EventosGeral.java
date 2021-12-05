package me.ninjay.robintnt.eventos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.ninjay.robintnt.estruturas.ItensAPI;
import me.ninjay.robintnt.main.Main;
import me.ninjay.robintnt.utils.Mine;

public class EventosGeral implements Listener{
	
	private static boolean robin = false;
	private static boolean davi = false;
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlockPlaced().getType() == Material.LIME_CONCRETE || e.getBlockPlaced().getType() == Material.RED_CONCRETE || e.getBlockPlaced().getType() == Material.YELLOW_CONCRETE || e.getBlockPlaced().getType() == Material.ORANGE_CONCRETE || e.getBlockPlaced().getType() == Material.PINK_CONCRETE) {
			p.playSound(p.getLocation(), Sound.BLOCK_GRASS_PLACE, 1F, 1F);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getInventory().getItemInMainHand() != null) {
					if(p.getInventory().getItemInMainHand().getType() == Material.FLINT_AND_STEEL) {
						if(e.getClickedBlock().getType() == Material.LIME_CONCRETE) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									e.getClickedBlock().setType(Material.AIR);
									FallingBlock block = p.getWorld().spawnFallingBlock(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), Material.LIME_CONCRETE.createBlockData());
									block.setDropItem(false);
									block.setVelocity(new Vector(block.getVelocity().getX(), 1, block.getVelocity().getZ()));
									
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
											block.remove();
											robin=true;
											for(int i = 0; i <= 50; i++) {
												p.spawnParticle(Particle.ITEM_CRACK, e.getClickedBlock().getLocation().add(0.5, 10, 0.5), 100, 0.1, 0.1, 0.1, new ItemStack(Material.EMERALD_BLOCK));
												p.getWorld().spawnArrow(e.getClickedBlock().getLocation().add(0.5, 10, 0.5), new Vector(Mine.getRandomDouble(-0.005, 0.005),Mine.getRandomDouble(-0.005, 0.005), Mine.getRandomDouble(-0.005, 0.005)), 1F, 1F);
											}
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20L);
									
									new BukkitRunnable() {
										
										@Override
										public void run() {
											robin=false;
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20*6L);
									
									new BukkitRunnable() {
										int i = 1;
										@Override
										public void run() {
											i--;
											if(i <= 0) {
												cancel();
											}
											for(double y = 0; y <= 10; y++) {
												p.spawnParticle(Particle.VILLAGER_HAPPY, e.getClickedBlock().getLocation().add(0.5, y, 0.5), 30, 0.1, 0.1, 0.1, 0.1);
											}
										}
									}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20*3L);
					}
						if(e.getClickedBlock().getType() == Material.RED_CONCRETE) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
							davi=true;
							
						new BukkitRunnable() {
							
							@Override
							public void run() {
								new BukkitRunnable() {
									int i = 12;
									@Override
									public void run() {
										i--;
										p.getWorld().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
										e.getClickedBlock().getWorld().spawnParticle(Particle.FLAME, e.getClickedBlock().getLocation().add(0.50, 0.50, 0.5), 200, 0.1, 0.1, 0.1);
										if(i <= 0) {
											cancel();
											e.getClickedBlock().setType(Material.AIR);
											for(Player todos : Bukkit.getOnlinePlayers()) {
												todos.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 30*20, 1));
											}
											p.getWorld().createExplosion(e.getClickedBlock().getLocation(), 20F);
										}
									}
								}.runTaskTimer(Main.getPlugin(Main.class), 0L, 5L);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*3L);
						}
						if(e.getClickedBlock().getType() == Material.YELLOW_CONCRETE) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									FallingBlock block = p.getWorld().spawnFallingBlock(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), Material.YELLOW_CONCRETE.createBlockData());
									block.setDropItem(false);
									block.setVelocity(new Vector(block.getVelocity().getX(), 1, block.getVelocity().getZ()));
									
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
											block.remove();
											for(int i = 0; i <= 30; i++) {
												p.spawnParticle(Particle.ITEM_CRACK, e.getClickedBlock().getLocation().add(0.5, 10, 0.5), 300, 0.1, 0.1, 0.1, new ItemStack(Material.BREAD));
												ItemStack drop = Mine.newItem(Material.BREAD, null, 64);
												p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0.5, 10, 0.5), drop).setVelocity(new Vector(Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5)));;
											}
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20L);
									
									new BukkitRunnable() {
										int i = 1;
										@Override
										public void run() {
											i--;
											if(i <= 0) {
												cancel();
											}
											for(double y = 0; y <= 60; y++) {
												p.spawnParticle(Particle.ENCHANTMENT_TABLE, e.getClickedBlock().getLocation().add(0.5, y, 0.5), 30, 0.1, 0.1, 0.1, 0.1);
											}
										}
									}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20*3L);
						}
						if(e.getClickedBlock().getType() == Material.ORANGE_CONCRETE) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
							FallingBlock block = p.getWorld().spawnFallingBlock(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), Material.ORANGE_CONCRETE.createBlockData());
							block.setDropItem(false);
							block.setVelocity(new Vector(block.getVelocity().getX(), 1, block.getVelocity().getZ()));
							
							new BukkitRunnable() {
								
								@Override
								public void run() {
									e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
									block.remove();
									for(int i = 0; i <= 30; i++) {
										p.spawnParticle(Particle.ITEM_CRACK, e.getClickedBlock().getLocation().add(0.5, 10, 0.5), 300, 0.1, 0.1, 0.1, new ItemStack(Material.SALMON));
										ItemStack drop = Mine.newItem(Material.COOKED_SALMON, null, 64);
										p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0.5, 10, 0.5), drop).setVelocity(new Vector(Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5)));;
									}
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20L);
							
							new BukkitRunnable() {
								int i = 1;
								@Override
								public void run() {
									i--;
									if(i <= 0) {
										cancel();
									}
									for(double y = 0; y <= 10; y++) {
										p.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, e.getClickedBlock().getLocation().add(0.5, y, 0.5), 10, 0.1, 0.1, 0.1, 0.1);
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20*3L);
						}
						if(e.getClickedBlock().getType() == Material.PINK_CONCRETE) {
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
							new BukkitRunnable() {
								
								@Override
								public void run() {
									FallingBlock block = p.getWorld().spawnFallingBlock(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), Material.PINK_CONCRETE.createBlockData());
									block.setDropItem(false);
									block.setVelocity(new Vector(block.getVelocity().getX(), 1, block.getVelocity().getZ()));
									
									new BukkitRunnable() {
										
										@Override
										public void run() {
											e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
											block.remove();
											for(int i = 0; i <= 30; i++) {
												p.spawnParticle(Particle.ITEM_CRACK, e.getClickedBlock().getLocation().add(0.5, 10, 0.5), 300, 0.1, 0.1, 0.1, new ItemStack(Material.COOKED_BEEF));
												p.spawnParticle(Particle.ITEM_CRACK, e.getClickedBlock().getLocation().add(0.5, 10, 0.5), 300, 0.1, 0.1, 0.1, new ItemStack(Material.BONE));
												ItemStack drop = Mine.newItem(Material.COOKED_BEEF, null, 64);
												p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0.5, 10, 0.5), drop).setVelocity(new Vector(Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5)));;
												ItemStack drop2 = Mine.newItem(Material.BONE, null, 64);
												p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0.5, 10, 0.5), drop2).setVelocity(new Vector(Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5), Mine.getRandomDouble(-0.5, 0.5)));;
											}
										}
									}.runTaskLater(Main.getPlugin(Main.class), 20L);
									
									new BukkitRunnable() {
										int i = 1;
										@Override
										public void run() {
											i--;
											if(i <= 0) {
												cancel();
											}
											for(double y = 0; y <= 10; y++) {
												Particle.DustOptions dust1 = new Particle.DustOptions(Color.PURPLE, 2);
												p.spawnParticle(Particle.REDSTONE, e.getClickedBlock().getLocation().add(0.5, y, 0.5), 10, 0.1, 0.1, 0.1, 0.1, dust1);
											}
										}
									}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
								}
							}.runTaskLater(Main.getPlugin(Main.class), 20*3L);
						}
					}
				}
			}
		}
		
		if(e.getClickedBlock() != null) {
			if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if(e.getClickedBlock().getType() == Material.LIME_CONCRETE || e.getClickedBlock().getType() == Material.RED_CONCRETE || e.getClickedBlock().getType() == Material.YELLOW_CONCRETE || e.getClickedBlock().getType() == Material.ORANGE_CONCRETE || e.getClickedBlock().getType() == Material.PINK_CONCRETE) {
					p.playSound(p.getLocation(), Sound.BLOCK_GRASS_BREAK, 1F, 1F);
				}
				if(e.getClickedBlock().getType() == Material.LIME_CONCRETE) {
					e.getClickedBlock().setType(Material.AIR);
					p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0, 0.3, 0), ItensAPI.robin);
				}
				if(e.getClickedBlock().getType() == Material.RED_CONCRETE) {
					e.getClickedBlock().setType(Material.AIR);
					p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0, 0.3, 0), ItensAPI.davi);
				}
				if(e.getClickedBlock().getType() == Material.YELLOW_CONCRETE) {
					e.getClickedBlock().setType(Material.AIR);
					p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0, 0.3, 0), ItensAPI.beto);
				}
				if(e.getClickedBlock().getType() == Material.ORANGE_CONCRETE) {
					e.getClickedBlock().setType(Material.AIR);
					p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0, 0.3, 0), ItensAPI.faisca);
				}
				if(e.getClickedBlock().getType() == Material.PINK_CONCRETE) {
					e.getClickedBlock().setType(Material.AIR);
					p.getWorld().dropItem(e.getClickedBlock().getLocation().add(0, 0.3, 0), ItensAPI.jhow);
				}
			}
		}
	}
	
	@EventHandler
	public void aoFlecha(ProjectileHitEvent e) {
		if(e.getEntity() != null) {
			if(e.getEntity().getType() == EntityType.ARROW) {
				if(robin == true) {
					new BukkitRunnable() {
						int i = 6;
						@Override
						public void run() {
							i--;
							for(double y = 0; y <= 3; y++) {
								e.getEntity().getWorld().spawnParticle(Particle.CLOUD, e.getEntity().getLocation().add(0.5, y, 0.5), 3, 0.1, 0.1, 0.1, 0.1);
							}
							if(i <= 0) {
								cancel();
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							e.getEntity().remove();
							e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 5F);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 3*20);
				}
			}
		}
	}
	
	private static final Set<Material> toDestroy = new HashSet<Material>();
	static {
	  toDestroy.add(Material.COAL_ORE);
	  toDestroy.add(Material.COPPER_ORE);
	  toDestroy.add(Material.IRON_ORE);
	  toDestroy.add(Material.GOLD_ORE);
	  toDestroy.add(Material.DIAMOND_ORE);
	  toDestroy.add(Material.EMERALD_ORE);
	  toDestroy.add(Material.REDSTONE_ORE);
	  toDestroy.add(Material.LAPIS_ORE);
	}
	 
	@EventHandler
	public void onEntityExplode(BlockExplodeEvent event) {
	   if(davi == true) {
		List destroyed = event.blockList();
	    Iterator it = destroyed.iterator();
	    while (it.hasNext()) {
	    Block block = (Block) it.next();
	    if (toDestroy.contains(block.getType()))
	      it.remove();
	    }
	   }
}
}