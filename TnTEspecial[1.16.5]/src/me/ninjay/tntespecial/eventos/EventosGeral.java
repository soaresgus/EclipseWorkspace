package me.ninjay.tntespecial.eventos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;

import me.ninjay.tntespecial.main.Main;
import me.ninjay.tntespecial.utils.Mine;

public class EventosGeral implements Listener{
	
	public static void animation(Block b) {
		
		b.getWorld().playSound(b.getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
		
		b.getWorld().spawnParticle(Particle.SMOKE_NORMAL, b.getLocation().add(0.5, 1, 0.5), 15, 0.1, 0.1, 0.1, 0.1);
	
		new BukkitRunnable() {
			@Override
			public void run() {
				b.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, b.getLocation(), 100, 1, 1, 1, 1);
				b.getWorld().playSound(b.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
				b.setType(Material.AIR);
			}
		}.runTaskLater(Main.getPlugin(Main.class), 20*5);
		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.hasPotionEffect(PotionEffectType.LUCK)) {
			p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation().add(0, 2, 0), 5, 0.1, 0.1, 0.1, 0.1);
		}
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			
			if(p.hasPotionEffect(PotionEffectType.LUCK)) {
				if(e.getCause() == DamageCause.FALL) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.hasPotionEffect(PotionEffectType.LUCK)) {
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.DIAMOND));
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT));
			p.getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.NETHERITE_INGOT));
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(p.getInventory().getItemInMainHand().getType() == Material.FLINT_AND_STEEL) {
					if(e.getClickedBlock().getType().toString().contains("CONCRETE") && e.getClickedBlock().getType() != Material.RED_CONCRETE) {
						e.setCancelled(true);
						animation(e.getClickedBlock());
					}
					
					if(e.getClickedBlock().getType() == Material.ORANGE_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								File file = new File("plugins/WorldEdit/schematics/buraco.schem");
							       com.sk89q.worldedit.world.World adaptedWorld = BukkitAdapter.adapt(p.getWorld());

							        ClipboardFormat format = ClipboardFormats.findByFile(file);

							        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

							            Clipboard clipboard = reader.read();

							            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld, -1)) {

							                Operation operation = new ClipboardHolder(clipboard).createPaste(editSession)
							                        .to(BlockVector3.at(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ())).ignoreAirBlocks(false).build();

							                try {
							                    Operations.complete(operation);
							                    editSession.flushSession();

							                } catch (WorldEditException e) {
							                    e.printStackTrace();
							                }
							            }


							        } catch (FileNotFoundException e) {
							            e.printStackTrace();
							            return;
							        } catch (IOException e) {
							            e.printStackTrace();
							            return;
							        }
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.MAGENTA_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(int i = 0; i <= 20; i++) {
									Bee bee = p.getWorld().spawn(e.getClickedBlock().getLocation().add(Mine.getRandomDouble(-3, 3), Mine.getRandomDouble(1, 3), Mine.getRandomDouble(-3, 3)), Bee.class);
									bee.setAnger(999);
									bee.setAdult();
									bee.setAware(true);
									bee.setTarget(p);
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.YELLOW_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-10, -10, -10), e.getClickedBlock().getLocation().add(10, 10, 10)))) {
									if(entity != null) {
									if(entity instanceof Pig) {
										if(entity.getWorld().getBlockAt(entity.getLocation().add(0, 3, 0)).getType() == Material.AIR) {
											entity.getWorld().getBlockAt(entity.getLocation().add(0, 3, 0)).setType(Material.ANVIL);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													((Pig) entity).damage(200.0);
													entity.getWorld().dropItemNaturally(entity.getLocation().add(0, 0.3, 0), new ItemStack(Material.CYAN_CONCRETE, 1));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 15);
										}
									}
									}
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.LIME_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-10, -10, -10), e.getClickedBlock().getLocation().add(10, 10, 10)))) {
									if(entity != null) {
										if(entity instanceof LivingEntity) {
											if(!(entity instanceof Player)) {
												for(int i = 0; i <= 5; i++) {
												p.getWorld().spawn(entity.getLocation().add(Mine.getRandomDouble(-1, 1), 0, Mine.getRandomDouble(-1, 1)), entity.getClass());
												}
											}
										}
									}
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.GREEN_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								p.playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_WITHER_SHOOT, 1F, 1F);
								for(int i = 0; i <= 30; i++) {
									p.getWorld().spawn(new Location(p.getWorld(), Mine.getRandomDouble(e.getClickedBlock().getX()-10, e.getClickedBlock().getX()+10), e.getClickedBlock().getY()+25, Mine.getRandomDouble(e.getClickedBlock().getZ()-10, e.getClickedBlock().getZ()+10), p.getLocation().getYaw(), 90), WitherSkull.class);
								}
								
								for(int i = 0; i <= 30; i++) {
									p.getWorld().spawn(new Location(p.getWorld(), Mine.getRandomDouble(e.getClickedBlock().getX()-12, e.getClickedBlock().getX()+12), e.getClickedBlock().getY()+25, Mine.getRandomDouble(e.getClickedBlock().getZ()-12, e.getClickedBlock().getZ()+12), p.getLocation().getYaw(), 90), Fireball.class);
								}
								
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.PINK_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-16, -16, -16), e.getClickedBlock().getLocation().add(16, 16, 16)))) {
									if(entity != null) {
										if(entity instanceof LivingEntity) {
											((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*15, 1, false, false), false);
										}
									}
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.BLUE_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-10, -10, -10), e.getClickedBlock().getLocation().add(10, 10, 10)))) {
									if(entity != null) {
										if(entity instanceof Player) {
											((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 20*61, 1));
										}
									}
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.BROWN_CONCRETE) {
						e.setCancelled(true);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-10, -10, -10), e.getClickedBlock().getLocation().add(10, 10, 10)))) {
									if(entity != null) {
										if(entity instanceof Cow) {
											entity.setCustomNameVisible(false);
											entity.setCustomName("§8bedrockcow");
										}
									}
								}
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
					
					if(e.getClickedBlock().getType() == Material.RED_CONCRETE) {
						e.setCancelled(true);
						
						e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_TNT_PRIMED, 1F, 1F);
						
						e.getClickedBlock().getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getClickedBlock().getLocation().add(0.5, 1, 0.5), 15, 0.1, 0.1, 0.1, 0.1);
						
						new BukkitRunnable() {
							
							@Override
							public void run() {
								e.getClickedBlock().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, e.getClickedBlock().getLocation(), 100, 1, 1, 1, 1);
								e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 1F);
								p.playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1F, 1F);
								for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-200, -200, -200), e.getClickedBlock().getLocation().add(200, 200, 200)))) {
									if(entity != null) {
										if(entity instanceof EnderDragon) {
										if(!(entity instanceof Player)) {
											drawLine(e.getClickedBlock().getLocation(), entity.getLocation(), 0.3);
											p.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 100, 1, 1, 1, 1);
											p.getWorld().strikeLightningEffect(entity.getLocation());
											if(((EnderDragon) entity).getHealth() <= 65) {
												((EnderDragon) entity).setHealth(0);
											}else {
												((EnderDragon) entity).setHealth(((EnderDragon) entity).getHealth()-65);
											}
										}
										}
									}
								}
								
								new BukkitRunnable() {
									
									@Override
									public void run() {
										for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-200, -200, -200), e.getClickedBlock().getLocation().add(200, 200, 200)))) {
											if(entity != null) {
												if(entity instanceof EnderDragon) {
												if(!(entity instanceof Player)) {
													drawLine(e.getClickedBlock().getLocation(), entity.getLocation(), 0.3);
													p.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 100, 1, 1, 1, 1);
													p.getWorld().strikeLightningEffect(entity.getLocation());
													if(((EnderDragon) entity).getHealth() <= 65) {
														((EnderDragon) entity).setHealth(0);
													}else {
														((EnderDragon) entity).setHealth(((EnderDragon) entity).getHealth()-65);
													}
												}
												}
											}
										}
										
										new BukkitRunnable() {
											
											@Override
											public void run() {
												for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-200, -200, -200), e.getClickedBlock().getLocation().add(200, 200, 200)))) {
													if(entity != null) {
														if(entity instanceof EnderDragon) {
														if(!(entity instanceof Player)) {
															drawLine(e.getClickedBlock().getLocation(), entity.getLocation(), 0.3);
															p.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 100, 1, 1, 1, 1);
															p.getWorld().strikeLightningEffect(entity.getLocation());
															if(((EnderDragon) entity).getHealth() <= 65) {
																((EnderDragon) entity).setHealth(0);
															}else {
																((EnderDragon) entity).setHealth(((EnderDragon) entity).getHealth()-65);
															}
														}
														}
													}
												}
												
												new BukkitRunnable() {
													
													@Override
													public void run() {
														for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(e.getClickedBlock().getLocation().add(-200, -200, -200), e.getClickedBlock().getLocation().add(200, 200, 200)))) {
															if(entity != null) {
																if(entity instanceof EnderDragon) {
																if(!(entity instanceof Player)) {
																	drawLine(e.getClickedBlock().getLocation(), entity.getLocation(), 0.3);
																	p.spawnParticle(Particle.EXPLOSION_LARGE, entity.getLocation(), 100, 1, 1, 1, 1);
																	p.getWorld().strikeLightningEffect(entity.getLocation());
																	if(((EnderDragon) entity).getHealth() <= 65) {
																		((EnderDragon) entity).setHealth(0);
																	}else {
																		((EnderDragon) entity).setHealth(((EnderDragon) entity).getHealth()-65);
																	}
																	
																	e.getClickedBlock().setType(Material.AIR);
																}
																}
															}
														}
													}
												}.runTaskLater(Main.getPlugin(Main.class), 20*3);
											}
										}.runTaskLater(Main.getPlugin(Main.class), 20*3);
									}
								}.runTaskLater(Main.getPlugin(Main.class), 20*3);
								
							}
						}.runTaskLater(Main.getPlugin(Main.class), 20*5);
					}
				}
			}
		}
	}

	public void drawLine(Location point1, Location point2, double space) {
	    World world = point1.getWorld();
	    Validate.isTrue(point2.getWorld().equals(world), "Lines cannot be in different worlds!");
	    double distance = point1.distance(point2);
	    Vector p1 = point1.toVector();
	    Vector p2 = point2.toVector();
	    Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
	    double length = 0;
	    Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 2);
	    for (; length < distance; p1.add(vector)) {
	    	
	        world.spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY()+1, p1.getZ(), 100, dust);
	        length += space;
	    }
	    
	}
	
}
