package me.ninjay.pocoesmobs.eventos;

import java.util.HashMap;

import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.pocoesmobs.main.Main;
import me.ninjay.pocoesmobs.utils.Mine;


public class EventosSuporte implements Listener{
	
	public static HashMap<Player, String> potion = new HashMap<>();
	public static boolean etapa0 = false;
	public static boolean etapa1 = false;
	public static boolean etapa2 = false;
	public static boolean etapa3 = false;
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Suporte de poção")) {
		if(e.getInventory().getItem(Mine.getPosition(4, 4)) != null && e.getInventory().getItem(Mine.getPosition(4, 5)) != null && e.getInventory().getItem(Mine.getPosition(4, 6)) != null) {
			if(e.getInventory().getItem(Mine.getPosition(4, 4)).getType() == Material.POTION && e.getInventory().getItem(Mine.getPosition(4, 5)).getType() == Material.POTION && e.getInventory().getItem(Mine.getPosition(4, 6)).getType() == Material.POTION) {
				if(e.getInventory().getItem(Mine.getPosition(2, 5)) != null) {
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.ROTTEN_FLESH) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "zumbi");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Zumbi §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.SPIDER_EYE) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "aranha");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Aranha §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.ENDER_PEARL) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "enderman");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Enderman §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.LEATHER) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "vaca");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Vaca §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getTypeId() == 289) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "creeper");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Creeper §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.FEATHER) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "galinha");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Galinha §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.GHAST_TEAR) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "ghast");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Ghast §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.EMERALD) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "villager");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Villager §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
					if(e.getInventory().getItem(Mine.getPosition(2, 5)).getType() == Material.DRAGON_EGG) {
						if(etapa0 == false) {
						p.getOpenInventory().close();
						etapa0 = true; 
						potion.remove(p);
						if(!potion.containsKey(p)) {
							potion.put(p, "enderdragon");
							new BukkitRunnable() {
								int i = 50;
								@Override
								public void run() {
									i--;
									 
									if(i == 40) {
										etapa1 = true;
									}
									if(i == 30) {
										etapa2 = true;
									}
									if(i == 20) {
										etapa3 = true;
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.sendMessage("\n §aSua §a§lPoção de Ender Dragon §aficou pronta :D\n ");
										int radius = 100;
										Location loc = p.getLocation();
										World world = loc.getWorld();
										for (int x = -radius; x < radius; x++) {
										    for (int y = -radius; y < radius; y++) {
										        for (int z = -radius; z < radius; z++) {
										            Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
										            if (block.getType() == Material.BREWING_STAND) {
										                Mine.newFirework(block.getLocation(), 0, Color.GREEN, Color.WHITE, true, true, Type.BALL_LARGE);
										            }
										        }
										    }
										}
										etapa2 = false;
										etapa1 = false;
									}
									if(i == 0) {
										cancel();
										etapa3 = false;
										etapa2 = false;
										etapa1 = false;
										etapa0 = false;
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
						}
					}
				}
				}
			}
		}
		}
		
	}

}
