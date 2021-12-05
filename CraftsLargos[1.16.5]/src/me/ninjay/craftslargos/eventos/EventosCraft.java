package me.ninjay.craftslargos.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import me.ninjay.craftslargos.estruturas.ItensAPI;
import me.ninjay.craftslargos.utils.Mine;

public class EventosCraft implements Listener{
	
	public static Inventory menu = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, "Crafting Table Larga");
	

	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.setDropItems(false);
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ANVIL_USE, 1F, 1F);
			e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), ItensAPI.craft());
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() != null) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getType() == Material.YELLOW_CONCRETE) {
					p.openInventory(menu);
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("Crafting Table Larga")) {
			
			//1
			
			if(menu.getItem(Mine.getPosition(2, 1)) != null) {
				if(menu.getItem(Mine.getPosition(2, 2)) != null) {
					if(menu.getItem(Mine.getPosition(2, 3)) != null) {
						if(menu.getItem(Mine.getPosition(2, 4)) != null) {
							if(menu.getItem(Mine.getPosition(2, 5)) != null) {
								if(menu.getItem(Mine.getPosition(2, 6)) != null) {
									if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.COOKED_BEEF) {
										if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.COOKED_BEEF) {
											if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.COOKED_BEEF) {
												if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.COOKED_BEEF) {
													if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.COOKED_BEEF) {
														if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.COOKED_BEEF) {
															menu.clear();
															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
															menu.setItem(Mine.getPosition(2, 8), ItensAPI.beef());
															p.openInventory(menu);
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
			
			//1
			
			//2
			
			if(menu.getItem(Mine.getPosition(2, 1)) != null) {
				if(menu.getItem(Mine.getPosition(2, 2)) != null) {
					if(menu.getItem(Mine.getPosition(2, 3)) != null) {
						if(menu.getItem(Mine.getPosition(2, 4)) != null) {
							if(menu.getItem(Mine.getPosition(2, 5)) != null) {
								if(menu.getItem(Mine.getPosition(2, 6)) != null) {
									if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.COOKED_PORKCHOP) {
										if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.COOKED_PORKCHOP) {
											if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.COOKED_PORKCHOP) {
												if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.COOKED_PORKCHOP) {
													if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.COOKED_PORKCHOP) {
														if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.COOKED_PORKCHOP) {
															menu.clear();
															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
															menu.setItem(Mine.getPosition(2, 8), ItensAPI.bacon());
															p.openInventory(menu);
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
			
			//2
			
			//3
			
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
										if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.OAK_PLANKS) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.OAK_PLANKS) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.OAK_PLANKS) {
																						if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.OAK_PLANKS) {
																							if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.OAK_PLANKS) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.OAK_PLANKS) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.OAK_PLANKS) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.OAK_PLANKS) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.OAK_PLANKS) {
																												if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.OAK_PLANKS) {
																													if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.OAK_PLANKS) {
																														if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.OAK_PLANKS) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.escudo());
																															p.openInventory(menu);
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
										}
									}
								}
							}
						}
					}
				}
			}
			
			//3
			
			//4
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.BLAZE_POWDER) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.BLAZE_POWDER) {
																				if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.BLAZE_POWDER) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.BLAZE_POWDER) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.BLAZE_POWDER) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.ENDER_PEARL) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.ENDER_PEARL) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.BLAZE_POWDER) {
																													if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.BLAZE_POWDER) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.BLAZE_POWDER) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.BLAZE_POWDER) {
																																if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.BLAZE_POWDER) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.olho());
																															p.openInventory(menu);
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
			
			//4
			
			//5
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) == null) {
						if(menu.getItem(Mine.getPosition(1, 4)) == null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 1)) != null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) != null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.IRON_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.IRON_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.IRON_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.IRON_INGOT) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.IRON_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.IRON_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.IRON_INGOT) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.IRON_INGOT) {
																												if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.IRON_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 1)).getType() == Material.IRON_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.IRON_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.IRON_INGOT) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.IRON_INGOT) {
																																if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.IRON_INGOT) {
																																	if(menu.getItem(Mine.getPosition(3, 6)).getType() == Material.IRON_INGOT) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.peitoral1());
																															p.openInventory(menu);
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
			
			//5
			
			//6
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) == null) {
						if(menu.getItem(Mine.getPosition(1, 4)) == null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 1)) != null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) != null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.GOLD_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.GOLD_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.GOLD_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.GOLD_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.GOLD_INGOT) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.GOLD_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.GOLD_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.GOLD_INGOT) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.GOLD_INGOT) {
																												if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.GOLD_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 1)).getType() == Material.GOLD_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.GOLD_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.GOLD_INGOT) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.GOLD_INGOT) {
																																if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.GOLD_INGOT) {
																																	if(menu.getItem(Mine.getPosition(3, 6)).getType() == Material.GOLD_INGOT) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.peitoral2());
																															p.openInventory(menu);
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
			
			//6
			
			//7
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) == null) {
						if(menu.getItem(Mine.getPosition(1, 4)) == null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 1)) != null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) != null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.DIAMOND) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.DIAMOND) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND) {
																						if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.DIAMOND) {
																							if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.DIAMOND) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.DIAMOND) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.DIAMOND) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.DIAMOND) {
																												if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.DIAMOND) {
																													if(menu.getItem(Mine.getPosition(3, 1)).getType() == Material.DIAMOND) {
																													if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.DIAMOND) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.DIAMOND) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.DIAMOND) {
																																if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.DIAMOND) {
																																	if(menu.getItem(Mine.getPosition(3, 6)).getType() == Material.DIAMOND) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.peitoral3());
																															p.openInventory(menu);
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
			
			//7

			//8
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) == null) {
						if(menu.getItem(Mine.getPosition(1, 4)) == null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 1)) != null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) != null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.NETHERITE_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.NETHERITE_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.NETHERITE_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.NETHERITE_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.NETHERITE_INGOT) {
																								if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.NETHERITE_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.NETHERITE_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.NETHERITE_INGOT) {
																											if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.NETHERITE_INGOT) {
																												if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.NETHERITE_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 1)).getType() == Material.NETHERITE_INGOT) {
																													if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.NETHERITE_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.NETHERITE_INGOT) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.NETHERITE_INGOT) {
																																if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.NETHERITE_INGOT) {
																																	if(menu.getItem(Mine.getPosition(3, 6)).getType() == Material.NETHERITE_INGOT) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.peitoral4());
																															p.openInventory(menu);
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
			
			//8
			
			//9
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.COBBLESTONE) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.COBBLESTONE) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.COBBLESTONE) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.COBBLESTONE) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.espada1());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//9
			
			//10
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.IRON_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.IRON_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.espada2());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//10
			
			//11
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.GOLD_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.GOLD_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.GOLD_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.GOLD_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.espada3());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//11
			
			//12
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.DIAMOND) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.DIAMOND) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.espada4());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//12
			
			//13
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.NETHERITE_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.NETHERITE_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.NETHERITE_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.NETHERITE_INGOT) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.espada5());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//13
			
			//14
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.COBBLESTONE) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.COBBLESTONE) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.COBBLESTONE) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.COBBLESTONE) {
																						if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.COBBLESTONE) {			
																							if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.COBBLESTONE) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.picareta1());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//14
			
			//15
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.IRON_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.IRON_INGOT) {			
																							if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.IRON_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.picareta2());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//15

			//16
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.GOLD_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.GOLD_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.GOLD_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.GOLD_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.GOLD_INGOT) {			
																							if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.GOLD_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.picareta3());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//16

			//17
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.DIAMOND) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.DIAMOND) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND) {
																						if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.DIAMOND) {			
																							if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.DIAMOND) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.picareta4());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//17
			
			//18
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.NETHERITE_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.NETHERITE_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.NETHERITE_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.NETHERITE_INGOT) {
																						if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.NETHERITE_INGOT) {			
																							if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.NETHERITE_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.picareta5());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//18
			
			//19
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.COBBLESTONE) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.COBBLESTONE) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.COBBLESTONE) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.COBBLESTONE) {
																						if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.COBBLESTONE) {
																							if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.COBBLESTONE) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.machado1());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//19
			
			//20
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.IRON_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_INGOT) {
																						if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.IRON_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.IRON_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.machado2());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//20
			
			//21
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.GOLD_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.GOLD_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.GOLD_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.GOLD_INGOT) {
																						if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.GOLD_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.GOLD_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.machado3());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//21
			
			//22
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.DIAMOND) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.DIAMOND) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND) {
																						if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.DIAMOND) {
																							if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.DIAMOND) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.machado4());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//22
			
			//23
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.NETHERITE_INGOT) {
																				if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.NETHERITE_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.NETHERITE_INGOT) {
																					if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.NETHERITE_INGOT) {
																						if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.NETHERITE_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.NETHERITE_INGOT) {
																							if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.machado5());
																															p.openInventory(menu);
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
											}
										}
									}
							}
						}
						}
					}
			}
			
			//23
			
			//24
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.COBBLESTONE) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.COBBLESTONE) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.pa1());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//24
			
			//25
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.IRON_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.IRON_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.pa2());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//25
			
			//26
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.GOLD_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.GOLD_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.pa3());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//26
			
			//27
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.DIAMOND) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.DIAMOND) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.pa4());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//27
			
			//28
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) == null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) == null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) == null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) == null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.NETHERITE_INGOT) {
																		if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.NETHERITE_INGOT) {
																									if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.STICK) {
																										if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.STICK) {
																														if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.STICK) {
																															if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.STICK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.pa5());
																															p.openInventory(menu);
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
						}
						}
					}
			}
			
			//28
			
			//29
			if(menu.getItem(Mine.getPosition(1, 1)) == null) {
				if(menu.getItem(Mine.getPosition(1, 2)) == null) {
					if(menu.getItem(Mine.getPosition(1, 3)) == null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) == null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) == null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) == null) {
															if(menu.getItem(Mine.getPosition(3, 1)) == null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) == null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) == null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) == null) {
																			if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.FLINT) {
																		if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.FLINT) {
																									if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.IRON_INGOT) {
																										if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.IRON_INGOT) {
																											if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.FLINT) {
																												if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.FLINT) {		
																												if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.IRON_INGOT) {
																															if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.IRON_INGOT) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.isqueiro());
																															p.openInventory(menu);
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
									}
							}
						}
						}
					}
			}
			
			//29
			
			//30
			if(menu.getItem(Mine.getPosition(1, 1)) != null) {
				if(menu.getItem(Mine.getPosition(1, 2)) != null) {
					if(menu.getItem(Mine.getPosition(1, 3)) != null) {
						if(menu.getItem(Mine.getPosition(1, 4)) != null) {
							if(menu.getItem(Mine.getPosition(1, 5)) != null) {
								if(menu.getItem(Mine.getPosition(1, 6)) != null) {	
									if(menu.getItem(Mine.getPosition(2, 1)) != null) {
								if(menu.getItem(Mine.getPosition(2, 2)) != null) {
											if(menu.getItem(Mine.getPosition(2, 3)) != null) {
												if(menu.getItem(Mine.getPosition(2, 4)) != null) {
													if(menu.getItem(Mine.getPosition(2, 5)) != null) {
														if(menu.getItem(Mine.getPosition(2, 6)) != null) {
															if(menu.getItem(Mine.getPosition(3, 1)) != null) {
														if(menu.getItem(Mine.getPosition(3, 2)) != null) {
															if(menu.getItem(Mine.getPosition(3, 3)) != null) {
																if(menu.getItem(Mine.getPosition(3, 4)) != null) {
																	if(menu.getItem(Mine.getPosition(3, 5)) != null) {
																		if(menu.getItem(Mine.getPosition(3, 6)) != null) {
																			if(menu.getItem(Mine.getPosition(1, 1)).getType() == Material.GOLD_BLOCK) {
																			if(menu.getItem(Mine.getPosition(1, 2)).getType() == Material.GOLD_BLOCK) {
																			if(menu.getItem(Mine.getPosition(1, 3)).getType() == Material.GOLD_BLOCK) {
																			if(menu.getItem(Mine.getPosition(1, 4)).getType() == Material.GOLD_BLOCK) {
																		if(menu.getItem(Mine.getPosition(1, 5)).getType() == Material.GOLD_BLOCK) {
																			if(menu.getItem(Mine.getPosition(1, 6)).getType() == Material.GOLD_BLOCK) {
																				if(menu.getItem(Mine.getPosition(2, 1)).getType() == Material.GOLD_BLOCK) {
																					if(menu.getItem(Mine.getPosition(2, 2)).getType() == Material.GOLDEN_APPLE) {
																					if(menu.getItem(Mine.getPosition(2, 3)).getType() == Material.GOLDEN_APPLE) {
																					if(menu.getItem(Mine.getPosition(2, 4)).getType() == Material.GOLDEN_APPLE) {
																				if(menu.getItem(Mine.getPosition(2, 5)).getType() == Material.GOLDEN_APPLE) {
																					if(menu.getItem(Mine.getPosition(2, 6)).getType() == Material.GOLD_BLOCK) {
																						if(menu.getItem(Mine.getPosition(3, 1)).getType() == Material.GOLD_BLOCK) {
																							if(menu.getItem(Mine.getPosition(3, 2)).getType() == Material.GOLD_BLOCK) {
																							if(menu.getItem(Mine.getPosition(3, 3)).getType() == Material.GOLD_BLOCK) {
																							if(menu.getItem(Mine.getPosition(3, 4)).getType() == Material.GOLD_BLOCK) {
																						if(menu.getItem(Mine.getPosition(3, 5)).getType() == Material.GOLD_BLOCK) {
																							if(menu.getItem(Mine.getPosition(3, 6)).getType() == Material.GOLD_BLOCK) {
																															menu.clear();
																															p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
																															menu.setItem(Mine.getPosition(2, 8), ItensAPI.maca());
																															p.openInventory(menu);
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
			
			//30
		}
	}

}
