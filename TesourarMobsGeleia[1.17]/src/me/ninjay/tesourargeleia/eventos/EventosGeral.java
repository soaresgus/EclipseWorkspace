package me.ninjay.tesourargeleia.eventos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.tesourargeleia.estruturas.Armardura;
import me.ninjay.tesourargeleia.estruturas.ItensAPI;
import me.ninjay.tesourargeleia.main.Main;
import me.ninjay.tesourargeleia.utils.Mine;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EventosGeral implements Listener{
	
	private static ArrayList<String> repetido = new ArrayList<>();
	private static ArrayList<Player> piglin = new ArrayList<>();
	
	public static void tosar(Player p, Entity mob, EntityType tipo, String name, Sound som, ItemStack drop1, ItemStack drop2, String itemTipo, String itemNome, String mobnome) {
		
		if(mob.getType() == tipo) {
			if(mob.getCustomName() == null) {
			mob.setCustomName("§8"+name);
			p.getWorld().playSound(p.getLocation(), som, 1F, 1F);
			if(drop1.getType() != Material.AIR) {
				p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3, 0), drop1);
			}
			if(drop2.getType() != Material.AIR) {
				p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3, 0), drop2);
			}
			
			if(!repetido.contains("capa"+mobnome)) {
				repetido.add("capa"+mobnome);
				p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3 ,0), ItensAPI.create(Armardura.CAPACETE, itemTipo, itemNome));
			}else {
				if(!repetido.contains("peito"+mobnome)) {
					repetido.add("peito"+mobnome);
					p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3 ,0), ItensAPI.create(Armardura.PEITORAL, itemTipo, itemNome));
				}else {
					if(!repetido.contains("calca"+mobnome)) {
						repetido.add("calca"+mobnome);
						p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3 ,0), ItensAPI.create(Armardura.CALÇA, itemTipo, itemNome));
					}else {
						if(!repetido.contains("bota"+mobnome)) {
							repetido.add("bota"+mobnome);
							p.getWorld().dropItemNaturally(mob.getLocation().add(0, 0.3 ,0), ItensAPI.create(Armardura.BOTA, itemTipo, itemNome));
							repetido.remove("capa"+mobnome);
							repetido.remove("peito"+mobnome);
							repetido.remove("calca"+mobnome);
							repetido.remove("bota"+mobnome);
						}
					}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void aoTosar(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		
		repetido.add("a");
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Tesoura")) {
						tosar(p, e.getRightClicked(), EntityType.CHICKEN, "nakedchiken", Sound.ENTITY_CHICKEN_DEATH, new ItemStack(Material.FEATHER), new ItemStack(Material.CHICKEN), "CHAINMAIL", "Galinha", "galinha");
						
						tosar(p, e.getRightClicked(), EntityType.AXOLOTL, "nakedaxolotl", Sound.ENTITY_AXOLOTL_DEATH, new ItemStack(Material.AIR), new ItemStack(Material.AIR), "CHAINMAIL", "Axolotl", "axolotl");
						
						tosar(p, e.getRightClicked(), EntityType.PIG, "nakedpig", Sound.ENTITY_PIG_DEATH, new ItemStack(Material.PORKCHOP), new ItemStack(Material.AIR), "CHAINMAIL", "Porco", "porco");
						
						tosar(p, e.getRightClicked(), EntityType.SHEEP, "nakedsheep", Sound.ENTITY_SHEEP_DEATH, new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.MUTTON), "CHAINMAIL", "Ovelha", "ovelha");
						
						tosar(p, e.getRightClicked(), EntityType.COW, "nakedcow", Sound.ENTITY_COW_DEATH, new ItemStack(Material.LEATHER), new ItemStack(Material.BEEF), "CHAINMAIL", "Vaca", "vaca");
						
						tosar(p, e.getRightClicked(), EntityType.GOAT, "nakedgoat", Sound.ENTITY_GOAT_DEATH, Mine.newItem(Material.MUTTON, "§eCarne de Cabra"), new ItemStack(Material.AIR), "DIAMOND", "Cabra", "cabra");
						
						tosar(p, e.getRightClicked(), EntityType.VILLAGER, "nakedvillager", Sound.ENTITY_VILLAGER_DEATH, new ItemStack(Material.AIR), new ItemStack(Material.AIR), "CHAINMAIL", "Villager", "villager");
						
						tosar(p, e.getRightClicked(), EntityType.ZOMBIE, "nakedzombie", Sound.ENTITY_ZOMBIE_DEATH, new ItemStack(Material.ROTTEN_FLESH), new ItemStack(Material.AIR), "IRON", "Zumbi", "zumbi");
						
						tosar(p, e.getRightClicked(), EntityType.SPIDER, "nakedspider", Sound.ENTITY_SPIDER_DEATH, new ItemStack(Material.STRING), new ItemStack(Material.AIR), "IRON", "Aranha", "aranha");
						
						tosar(p, e.getRightClicked(), EntityType.ENDERMAN, "nakedenderman", Sound.ENTITY_ENDERMAN_DEATH, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.AIR), "DIAMOND", "Enderman", "enderman");
					
						tosar(p, e.getRightClicked(), EntityType.IRON_GOLEM, "nakedgolem", Sound.ENTITY_IRON_GOLEM_DEATH, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.AIR), "IRON", "Golem", "golem");
					
						tosar(p, e.getRightClicked(), EntityType.SKELETON, "nakedskeleton", Sound.ENTITY_SKELETON_DEATH, new ItemStack(Material.BONE), new ItemStack(Material.AIR), "IRON", "Esqueleto", "esqueleto");
					
						tosar(p, e.getRightClicked(), EntityType.CREEPER, "nakedcreeper", Sound.ENTITY_CREEPER_DEATH, new ItemStack(Material.GUNPOWDER), new ItemStack(Material.AIR), "IRON", "Creeper", "creeper");
						
						tosar(p, e.getRightClicked(), EntityType.PIGLIN_BRUTE, "nakedpiglinbrute", Sound.ENTITY_PIGLIN_BRUTE_DEATH, new ItemStack(Material.AIR), new ItemStack(Material.AIR), "IRON", "Piglin Brute", "piglin");
					
						tosar(p, e.getRightClicked(), EntityType.BLAZE, "nakedblaze", Sound.ENTITY_BLAZE_DEATH, new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.AIR), "IRON", "Blaze", "blaze");
						
						tosar(p, e.getRightClicked(), EntityType.WITHER_SKELETON, "nakedwitherskeleton", Sound.ENTITY_WITHER_SKELETON_DEATH, new ItemStack(Material.AIR), new ItemStack(Material.AIR), "NETHERITE", "Esqueleto Wither", "wither");
					}
				}
			}
		}
	}

	@EventHandler
	public void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Galinha")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Galinha")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Galinha")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Galinha")) {
																		if(e.isSneaking() == false) {
																		p.setVelocity(new Vector(p.getVelocity().getX(), 2, p.getVelocity().getZ()));
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
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Axolotl")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Axolotl")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Axolotl")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Axolotl")) {
																		p.getWorld().spawnParticle(Particle.WATER_WAKE, p.getLocation().add(0, 1, 0), 500, 0.1, 0.1, 0.1);
																		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aDano de afogamento aplicado na região"));
																		for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-10, -10, -10), p.getLocation().add(10, 10, 10)))) {
																			if(entity != null) {
																				if(entity instanceof LivingEntity) {
																					LivingEntity l = (LivingEntity) entity;
																					l.damage(2);
																					l.getWorld().spawnParticle(Particle.WATER_WAKE, l.getLocation().add(0, 1, 0), 500, 0.1, 0.1, 0.1);
																					if(l != p) {
																					l.getWorld().getBlockAt(l.getLocation().add(0, 1, 0)).setType(Material.WATER);
																					new BukkitRunnable() {
																						
																						@Override
																						public void run() {
																							l.getWorld().getBlockAt(l.getLocation().add(0, 1, 0)).setType(Material.AIR);
																						}
																					}.runTaskLater(Main.getPlugin(Main.class), 10);
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
							}
						}
					}
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Cabra")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Cabra")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Cabra")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Cabra")) {
																		if(p.isSneaking() == false) {
																		new BukkitRunnable() {
																			
																			@Override
																			public void run() {
																				p.setVelocity(p.getLocation().getDirection().multiply(8.0));
																				p.playSound(p.getLocation(), Sound.ENTITY_GOAT_SCREAMING_HURT, 1F, 1F);
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
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Ovelha")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Ovelha")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Ovelha")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Ovelha")) {
																		if(p.isSneaking() == false) {
																		new BukkitRunnable() {
																			
																			@Override
																			public void run() {
																				p.setVelocity(p.getLocation().getDirection().multiply(6.0));
																				p.playSound(p.getLocation(), Sound.ENTITY_SHEEP_AMBIENT, 1F, 1F);
																				for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-8, -8, -8), p.getLocation().add(8, 8, 8)))) {
																					if(entity != p) {
																					entity.setVelocity(entity.getVelocity().add(new Vector(0, 1, 0)));
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
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Piglin")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Piglin")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Piglin")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Piglin")) {
																		if(p.isSneaking() == false) {
																		if(!piglin.contains(p)) {
																			new BukkitRunnable() {
																				int i = 60*5;
																				@Override
																				public void run() {
																					i--;
																					if(i <= 0) {
																						piglin.remove(p);
																					}
																				}
																			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
																		piglin.add(p);
																		Inventory menu = Bukkit.createInventory(null, InventoryType.DISPENSER, "§6Inventário de Piglin Brute");
																		
																		menu.clear();
																		ArrayList<ItemStack> itens = new ArrayList<>();
																		itens.clear();
																		itens.add(new ItemStack(Material.GOLD_INGOT, 32));
																		itens.add(new ItemStack(Material.GOLD_INGOT, 64));
																		itens.add(new ItemStack(Material.GOLD_NUGGET, 32));
																		itens.add(new ItemStack(Material.GOLD_NUGGET, 64));
																		itens.add(new ItemStack(Material.GOLDEN_CARROT, 32));
																		itens.add(new ItemStack(Material.GOLDEN_CARROT, 64));
																		itens.add(new ItemStack(Material.ENDER_PEARL, 8));
																		itens.add(new ItemStack(Material.ENDER_PEARL, 16));
																		itens.add(new ItemStack(Material.QUARTZ, 32));
																		itens.add(new ItemStack(Material.QUARTZ, 64));
																		itens.add(new ItemStack(Material.ARROW, 32));
																		itens.add(new ItemStack(Material.ARROW, 64));
																		itens.add(new ItemStack(Material.ROTTEN_FLESH, 32));
																		itens.add(new ItemStack(Material.ROTTEN_FLESH, 64));
																		
																		for(int i = 0; i <= 8; i++) {
																			menu.setItem(i, Mine.getRandomItem(itens));
																		}
																		
																	if(p.isSneaking() == false) {
																		p.openInventory(menu);
																	}
																	}else {
																		p.sendMessage("§cAguarde para utilizar novamente!");
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
					}
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Aranha")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Aranha")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Aranha")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Aranha")) {
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
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Villager")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Villager")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Villager")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Villager")) {
																		if(e.getBlock().getType() == Material.WHEAT || e.getBlock().getType() == Material.CARROTS ||e.getBlock().getType() == Material.POTATOES || e.getBlock().getType() == Material.BEETROOT_SEEDS || e.getBlock().getType() == Material.BEETROOTS || e.getBlock().getType() == Material.STONE || e.getBlock().getType() == Material.COBBLESTONE) {
																			e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.EMERALD));
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
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
            if(p.getInventory().getHelmet().getItemMeta() != null) {
                if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
                    if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Creeper")) {
                        if(p.getInventory().getChestplate() != null) {
                            if(p.getInventory().getChestplate().getItemMeta() != null) {
                                if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
                                    if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Creeper")) {
                                        if(p.getInventory().getLeggings() != null) {
                                            if(p.getInventory().getLeggings().getItemMeta() != null) {
                                                if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
                                                    if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Creeper")) {
                                                        if(p.getInventory().getBoots() != null) {
                                                            if(p.getInventory().getBoots().getItemMeta() != null) {
                                                                if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
                                                                    if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Creeper")) {
                                                                    	e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 5F);
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
            }
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Vaca")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Vaca")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Vaca")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Vaca")) {
																			if(e.getBlock().getType() == Material.GRASS_BLOCK) {
																				p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1F, 1F);
																				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aSua vida e fome foram recuperados."));
																				p.setFoodLevel(p.getFoodLevel()+1);
																				p.setHealth(p.getHealth()+1);
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
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		
		if(e.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
			
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Galinha")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Galinha")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Galinha")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Galinha")) {
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
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Creeper")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Creeper")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Creeper")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Creeper")) {
																			if(e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
																				e.setCancelled(true);
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
					}
				}
			}
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Blaze")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Blaze")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Blaze")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Blaze")) {
																			if(e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) {
																				e.setCancelled(true);
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
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		
		if(e.getDamager().getType() == EntityType.PLAYER) {
			Player p = (Player) e.getDamager();
			
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Galinha")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Galinha")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Galinha")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Galinha")) {
																			if(e.getEntityType() == EntityType.CHICKEN) {
																			e.setCancelled(true);
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
					}
				}
			}
			
			if(p.getInventory().getHelmet() != null) {
                if(p.getInventory().getHelmet().getItemMeta() != null) {
                    if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
                        if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Villager")) {
                            if(p.getInventory().getChestplate() != null) {
                                if(p.getInventory().getChestplate().getItemMeta() != null) {
                                    if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
                                        if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Villager")) {
                                            if(p.getInventory().getLeggings() != null) {
                                                if(p.getInventory().getLeggings().getItemMeta() != null) {
                                                    if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
                                                        if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Villager")) {
                                                            if(p.getInventory().getBoots() != null) {
                                                                if(p.getInventory().getBoots().getItemMeta() != null) {
                                                                    if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
                                                                        if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Villager")) {
                                                                        	if(e.getEntity().getType() == EntityType.IRON_GOLEM) {
                                                                        		LivingEntity l = (LivingEntity) e.getEntity();
                                                                        		l.damage(200);
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
                    }
                }
			}
			if(p.getInventory().getHelmet() != null) {
                if(p.getInventory().getHelmet().getItemMeta() != null) {
                    if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
                        if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Creeper")) {
                            if(p.getInventory().getChestplate() != null) {
                                if(p.getInventory().getChestplate().getItemMeta() != null) {
                                    if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
                                        if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Creeper")) {
                                            if(p.getInventory().getLeggings() != null) {
                                                if(p.getInventory().getLeggings().getItemMeta() != null) {
                                                    if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
                                                        if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Creeper")) {
                                                            if(p.getInventory().getBoots() != null) {
                                                                if(p.getInventory().getBoots().getItemMeta() != null) {
                                                                    if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
                                                                        if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Creeper")) {
                                                                        	e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 5F);
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
                }
			}
			
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Zumbi")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Zumbi")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Zumbi")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Zumbi")) {
																			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aSua vida e fome foram regenerados."));
																			p.setFoodLevel(p.getFoodLevel()+4);
																			p.setHealth(p.getHealth()+4);
																			p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
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
				}
			}
			
			if(p.getInventory().getHelmet() != null) {
				if(p.getInventory().getHelmet().getItemMeta() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
						if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Esqueleto Wither")) {
							if(p.getInventory().getChestplate() != null) {
								if(p.getInventory().getChestplate().getItemMeta() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
										if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Esqueleto Wither")) {
											if(p.getInventory().getLeggings() != null) {
												if(p.getInventory().getLeggings().getItemMeta() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
														if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Esqueleto Wither")) {
															if(p.getInventory().getBoots() != null) {
																if(p.getInventory().getBoots().getItemMeta() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																		if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Esqueleto Wither")) {
																			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1F, 1F);
																			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aFoi aplicado efeito de wither em seu adversário."));
																			if(e.getEntity() instanceof LivingEntity) {
																				LivingEntity l = (LivingEntity) e.getEntity();
																				l.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 1));
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
					}
				}
			}
			
		} 
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
            if(p.getInventory().getHelmet().getItemMeta() != null) {
                if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
                    if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Golem")) {
                        if(p.getInventory().getChestplate() != null) {
                            if(p.getInventory().getChestplate().getItemMeta() != null) {
                                if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
                                    if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Golem")) {
                                        if(p.getInventory().getLeggings() != null) {
                                            if(p.getInventory().getLeggings().getItemMeta() != null) {
                                                if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
                                                    if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Golem")) {
                                                        if(p.getInventory().getBoots() != null) {
                                                            if(p.getInventory().getBoots().getItemMeta() != null) {
                                                                if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
                                                                    if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Golem")) {
                                                                    	if(!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
                                                                    	p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 14));
                                                                    	p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 4));
                                                                    	}
                                                                    	}
                                                                }
                                                            }
                                                        }else {
                                                            p.removePotionEffect(PotionEffectType.REGENERATION);
                                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                                      	}
                                                    }
                                                }
                                            }
                                        }else {
                                            p.removePotionEffect(PotionEffectType.REGENERATION);
                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                      	}
                                    }
                                }
                            }
                        }else {
                            p.removePotionEffect(PotionEffectType.REGENERATION);
                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                      	}
                    }
                }
            }
		}else {
            p.removePotionEffect(PotionEffectType.REGENERATION);
            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
      	}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Axolotl")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Axolotl")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Axolotl")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Axolotl")) {
																		if(p.getWorld().getBlockAt(p.getLocation()).getType() == Material.WATER) {
																			p.setHealth(20);
																			p.setFoodLevel(20);
																			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aSua fome e vida foram regenerados!"));
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
				}
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Blaze")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Blaze")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Blaze")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Blaze")) {
																		p.spawnParticle(Particle.FLAME, p.getLocation(), 3, 0.1, 0.1, 0.1, 0.1);
																		if(p.getGameMode() == GameMode.SURVIVAL) {
																			p.setAllowFlight(true);
																			p.setFlying(true);
																		}
																	}
																}
															}
														}else {
															if(p.getGameMode() == GameMode.SURVIVAL) {
																p.setAllowFlight(true);
																p.setFlying(false);
															}
														}
													}
												}
											}
										}else {
											if(p.getGameMode() == GameMode.SURVIVAL) {
												p.setAllowFlight(true);
												p.setFlying(false);
											}
										}
									}
								}
							}
						}else {
							if(p.getGameMode() == GameMode.SURVIVAL) {
								p.setAllowFlight(true);
								p.setFlying(false);
							}
						}
					}
				}
			}
		}else {
			if(p.getGameMode() == GameMode.SURVIVAL) {
				p.setAllowFlight(true);
				p.setFlying(false);
			}
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Esqueleto")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Esqueleto")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Esqueleto")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Esqueleto")) {
																		if(!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
	                                                                    	p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 4));
	                                                                    	}
																	}
																}
															}
														}else {
                                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                                      	}
													}
												}
											}
										}else {
                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                      	}
									}
								}
							}
						}else {
                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                      	}
					}
				}
			}
		}else {
            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
      	}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Esqueleto Wither")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Esqueleto Wither")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Esqueleto Wither")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Esqueleto Wither")) {
																		if(!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
	                                                                    	p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 4));
	                                                                    	p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 4));
	                                                                    	}
																	}
																}
															}
														}else {
                                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                                            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                                                      	}
													}
												}
											}
										}else {
                                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                                            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                                      	}
									}
								}
							}
						}else {
                            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                      	}
					}
				}
			}
		}else {
            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
      	}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Porco")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Porco")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Porco")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Porco")) {
																		p.spawnParticle(Particle.ITEM_CRACK, p.getLocation(), 5, 0.1, 0.1, 0.1, 0.1, new ItemStack(Material.BROWN_WOOL));
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
			}
		}
	}
	
	private static final Set<Material> toDestroy = new HashSet<Material>();
	static {
	  //toDestroy.add(Material.STONE);
	  //toDestroy.add(Material.GRAVEL);
	  //toDestroy.add(Material.ANDESITE);
	  //toDestroy.add(Material.DIORITE);
	  //toDestroy.add(Material.DIRT);
	  //toDestroy.add(Material.GRASS_BLOCK);
	  toDestroy.add(Material.COAL_ORE);
	  toDestroy.add(Material.IRON_ORE);
	  toDestroy.add(Material.GOLD_ORE);
	  toDestroy.add(Material.REDSTONE_ORE);
	  toDestroy.add(Material.LAPIS_ORE);
	  toDestroy.add(Material.COPPER_ORE);
	  toDestroy.add(Material.DIAMOND_ORE);
	  toDestroy.add(Material.EMERALD_ORE);
	}
	
	@EventHandler
	public void onEntityExplode(BlockExplodeEvent event) {
		List destroyed = event.blockList();
	    Iterator it = destroyed.iterator();
	    while (it.hasNext()) {
	    Block block = (Block) it.next();
	    if (toDestroy.contains(block.getType()))
	      it.remove();
	    }
}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Blaze")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Blaze")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Blaze")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Blaze")) {
																		if(e.getAction() == Action.LEFT_CLICK_AIR) {
																			Location loc = new Location(p.getWorld(), p.getEyeLocation().getX()+1, p.getEyeLocation().getY()+1, p.getEyeLocation().getZ()+1, p.getEyeLocation().getYaw(), p.getEyeLocation().getPitch());
																			p.getWorld().spawnEntity(loc, EntityType.FIREBALL);
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
				}
			}
		}

		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Enderman")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Enderman")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Enderman")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Enderman")) {
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
		}
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§eCapacete de Esqueleto")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§ePeitoral de Esqueleto")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§eCalca de Esqueleto")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§eBotas de Esqueleto")) {
																		if(e.getAction() == Action.LEFT_CLICK_AIR) {
																			p.launchProjectile(Arrow.class);
																			p.getWorld().playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1F, 1F);
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
				}
			}
		}
		
	}
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getHelmet() != null) {
			if(p.getInventory().getHelmet().getItemMeta() != null) {
				if(p.getInventory().getHelmet().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Porco")) {
						if(p.getInventory().getChestplate() != null) {
							if(p.getInventory().getChestplate().getItemMeta() != null) {
								if(p.getInventory().getChestplate().getItemMeta().getDisplayName() != null) {
									if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Porco")) {
										if(p.getInventory().getLeggings() != null) {
											if(p.getInventory().getLeggings().getItemMeta() != null) {
												if(p.getInventory().getLeggings().getItemMeta().getDisplayName() != null) {
													if(p.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Porco")) {
														if(p.getInventory().getBoots() != null) {
															if(p.getInventory().getBoots().getItemMeta() != null) {
																if(p.getInventory().getBoots().getItemMeta().getDisplayName() != null) {
																	if(p.getInventory().getBoots().getItemMeta().getDisplayName().contains("Porco")) {
																		if(!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
																		p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 0, false, false));
																		}else {
																			int ampl = p.getPotionEffect(PotionEffectType.HEALTH_BOOST).getAmplifier()+1;
																			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, ampl, false, false));
																		}
																		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê recebeu +2 corações por comer esse alimento."));
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
			}
		}
	}
	
}
