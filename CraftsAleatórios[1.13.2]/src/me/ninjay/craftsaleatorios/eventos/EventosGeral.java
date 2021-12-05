package me.ninjay.craftsaleatorios.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import javafx.scene.text.Text;
import me.ninjay.craftsaleatorios.estruturas.ItensAPI;
import me.ninjay.craftsaleatorios.main.Main;
import me.ninjay.craftsaleatorios.utils.Mine;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EventosGeral implements Listener {

	private static ArrayList<Location> locs = new ArrayList<>();
	private static HashMap<Location, Material> blocks = new HashMap<>();
	private static ArrayList<Player> usando = new ArrayList<>();
	
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
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItem().isSimilar(ItensAPI.macadiamante)) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Mine.removeEffects(p);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 2);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 90*20, 3));
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 90*20, 4));
					new BukkitRunnable() {
						
						@Override
						public void run() {
							p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 89*20);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§ePicareta do Fim")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR) {
							Block bloco = p.getTargetBlock(null, 5000);
							Location loc = new Location(p.getWorld(), bloco.getX(), bloco.getY()+1, bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
							p.teleport(loc);
							p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
					}
				}
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§ePerola de Vidro")) {
					if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
						e.setCancelled(true);
					if(!usando.contains(p)) {
						usando.add(p);
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê ativou a visão de Raio-X!"));
						for(int x = (int) -2.5; x <= 2.5; x++) {
							for(int y = -255; y <= 255; y++) {
								for(int z = (int) -2.5; z <= 2.5; z++) {
									Location loc = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
									Block blocos = p.getWorld().getBlockAt(loc);
									
									if(blocos.getType() != Material.AIR) {
										if(blocos.getType() != Material.BEDROCK) {
											if(blocos.getType() != Material.IRON_ORE && blocos.getType() != Material.GOLD_ORE && blocos.getType() != Material.COAL_ORE && blocos.getType() != Material.LAPIS_ORE && blocos.getType() != Material.DIAMOND_ORE && blocos.getType() != Material.REDSTONE_ORE && blocos.getType() != Material.EMERALD_ORE && blocos.getType() != Material.QUARTZ) {
											new BukkitRunnable() {
												
												@Override
												public void run() {
													locs.add(blocos.getLocation());
													blocks.put(blocos.getLocation(), blocos.getType());
												}
											}.runTaskLater(Main.getPlugin(Main.class), 5);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													blocos.setType(Material.GLASS);
												}
											}.runTaskLater(Main.getPlugin(Main.class), 10);
											}
										}
									}
									}
								}
							}
						}else if(usando.contains(p)) {
							usando.remove(p);
							p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§cVocê desativou a visão de Raio-X!"));
							
							for(int i = 0; i < locs.size(); i++) {
								p.getWorld().getBlockAt(locs.get(i)).setType(blocks.get(locs.get(i)));
							}
						}
					}
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Dispenser")) {
					if(e.getAction() == Action.LEFT_CLICK_AIR) {
						p.launchProjectile(Arrow.class);
						p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 1F, 1F);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onItem(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		
		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§ePicareta de Esmeralda")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1));
				}
			}
		}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1*10);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Fornalha")) {
					p.getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 5, 0, 0.1, 0, 0);
				}
			}
		}
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Maca")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 5*20, 4));
				}
			}
		}
		if(p.getInventory().getChestplate() != null) {
			if(p.getInventory().getChestplate().getItemMeta() != null) {
				if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Maca")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5*20, 1));
				}
			}
		}
		if(p.getInventory().getLeggings() != null) {
			if(p.getInventory().getLeggings().getItemMeta() != null) {
				if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Maca")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*20, 1));
				}
			}
		}
		if(p.getInventory().getBoots() != null) {
			if(p.getInventory().getBoots().getItemMeta() != null) {
				if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Maca")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 5*20, 1));
				}
			}
		}
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Obsidian")) {
					if(p.getInventory().getChestplate() != null) {
						if(p.getInventory().getChestplate().getItemMeta() != null) {
							if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Obsidian")) {
								if(p.getInventory().getLeggings() != null) {
									if(p.getInventory().getLeggings().getItemMeta() != null) {
										if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Obsidian")) {
											if(p.getInventory().getBoots() != null) {
												if(p.getInventory().getBoots().getItemMeta() != null) {
													if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Obsidian")) {
														p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5*20, 9));
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
		}
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Magma")) {
					if(p.getInventory().getChestplate() != null) {
						if(p.getInventory().getChestplate().getItemMeta() != null) {
							if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Magma")) {
								if(p.getInventory().getLeggings() != null) {
									if(p.getInventory().getLeggings().getItemMeta() != null) {
										if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Magma")) {
											if(p.getInventory().getBoots() != null) {
												if(p.getInventory().getBoots().getItemMeta() != null) {
													if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Magma")) {
														p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 5*20, 1));	
														Location loc = new Location(p.getWorld(), Mine.getRandomDouble(p.getLocation().getX()-5, p.getLocation().getX()+5), Mine.getRandomDouble(p.getLocation().getY(), p.getLocation().getY()+5), Mine.getRandomDouble(p.getLocation().getZ()-5, p.getLocation().getZ()+5));
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
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Fornalha")) {
					if(p.getInventory().getChestplate() != null) {
						if(p.getInventory().getChestplate().getItemMeta() != null) {
							if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Fornalha")) {
								if(p.getInventory().getLeggings() != null) {
									if(p.getInventory().getLeggings().getItemMeta() != null) {
										if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Fornalha")) {
											if(p.getInventory().getBoots() != null) {
												if(p.getInventory().getBoots().getItemMeta() != null) {
													if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Fornalha")) {
														if(e.getBlock().getType() == Material.IRON_ORE) {
															e.getBlock().setType(Material.AIR);
															p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
														}
														if(e.getBlock().getType() == Material.GOLD_ORE) {
															e.getBlock().setType(Material.AIR);
															p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
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
			}
		}
	}
	
	@EventHandler 
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(e.isSneaking() == true) {
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Dispenser")) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if(p.isSneaking() == true) {
								p.launchProjectile(Arrow.class);
								p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 1F, 1F);
								}else if(p.isSneaking() == false){
									cancel();
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 0L, 3L);
					}
				}
			}
		}
	}

	@EventHandler
	public void onExplodir(EntityExplodeEvent e) {
		
		for(Block blocos : e.blockList()) {
			if(blocos.getType() == Material.TRAPPED_CHEST) {
				e.blockList().remove(blocos);
			}
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		
		if(e.getBlock().getType() == Material.REDSTONE_TORCH) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
			new BukkitRunnable() {
				int i = 8;
				@Override
				public void run() {
					i--;
					e.getBlock().getWorld().spawnParticle(Particle.CLOUD, e.getBlock().getLocation(), 5, 0.1, 0.1, 0.1, 0.1);
					if(i <= 0) {
						cancel();
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 0L, 5L);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 5F);
				}
			}.runTaskLater(Main.getPlugin(Main.class), 3*20);
		}
		
	}
}


