package me.ninjay.pocoesmobs.eventos;

import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.pocoesmobs.estruturas.ItemAPI;
import me.ninjay.pocoesmobs.main.Main;
import me.ninjay.pocoesmobs.utils.Mine;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;


public class EventosPocoes implements Listener{
	
	public static ItemStack verde25 = Mine.newItem(Material.STAINED_GLASS_PANE, "§eProgresso: 25%", 1, 5);
	public static ItemStack verde50 = Mine.newItem(Material.STAINED_GLASS_PANE, "§eProgresso: 50%", 1, 5);
	public static ItemStack verde75 = Mine.newItem(Material.STAINED_GLASS_PANE, "§eProgresso: 75%", 1, 5);
	public static ItemStack verde100 = Mine.newItem(Material.STAINED_GLASS_PANE, "§eProgresso: 100%", 1, 5);
	public static ItemStack vermelho = Mine.newItem(Material.STAINED_GLASS_PANE, "§eProgresso", 1, 14);
	public static Inventory menu = Mine.newInventory("Suporte de poção", 9*6);
	
	public static HashMap<Player, String> mob = new HashMap<>();
	private static int i = 60;
	
	@EventHandler
	public void aoAbrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(e.getClickedBlock() != null) {
		if(e.getClickedBlock().getType() == Material.BREWING_STAND) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.getOpenInventory().close();
				ItemStack cinza = Mine.newItem(Material.STAINED_GLASS_PANE, " ", 1, 15);
				for(int i = 0; i < 9*6; i++) {
					menu.setItem(i, cinza);
				}
				menu.setItem(Mine.getPosition(2, 5), Mine.newItem(Material.AIR, null));
			if(EventosSuporte.etapa0 == false) {
				menu.setItem(Mine.getPosition(2, 2), vermelho);
				menu.setItem(Mine.getPosition(3, 2), vermelho);
				menu.setItem(Mine.getPosition(4, 2), vermelho);
				menu.setItem(Mine.getPosition(5, 2), vermelho);
				menu.setItem(Mine.getPosition(2, 8), vermelho);
				menu.setItem(Mine.getPosition(3, 8), vermelho);
				menu.setItem(Mine.getPosition(4, 8), vermelho);
				menu.setItem(Mine.getPosition(5, 8), vermelho);
				menu.setItem(Mine.getPosition(4, 4), Mine.newItem(Material.AIR, null));
				menu.setItem(Mine.getPosition(4, 5), Mine.newItem(Material.AIR, null));
				menu.setItem(Mine.getPosition(4, 6), Mine.newItem(Material.AIR, null));
			}
			if(EventosSuporte.etapa0 == true || EventosSuporte.etapa1 == true || EventosSuporte.etapa2 == true) {
				menu.setItem(Mine.getPosition(4, 4), Mine.newItem(Material.POTION, null));
				menu.setItem(Mine.getPosition(4, 5), Mine.newItem(Material.POTION, null));
				menu.setItem(Mine.getPosition(4, 6), Mine.newItem(Material.POTION, null));
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("zumbi")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.zumbi);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.zumbi);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.zumbi);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("aranha")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.aranha);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.aranha);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.aranha);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("enderman")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.enderman);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.enderman);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.enderman);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("vaca")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.vaca);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.vaca);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.vaca);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("creeper")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.creeper);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.creeper);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.creeper);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("galinha")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.galinha);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.galinha);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.galinha);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("ghast")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.ghast);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.ghast);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.ghast);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("villager")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.vilager);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.vilager);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.vilager);
					}
				}
			}
			if(EventosSuporte.etapa3 == true) {
				if(EventosSuporte.potion.get(p) != null) {
					if(EventosSuporte.potion.get(p).equalsIgnoreCase("enderdragon")) {
						menu.setItem(Mine.getPosition(4, 4), ItemAPI.dragao);
						menu.setItem(Mine.getPosition(4, 5), ItemAPI.dragao);
						menu.setItem(Mine.getPosition(4, 6), ItemAPI.dragao);
					}
				}
			}
 			if(EventosSuporte.etapa0 == true) {
				menu.setItem(Mine.getPosition(2, 2), vermelho);
				menu.setItem(Mine.getPosition(3, 2), vermelho);
				menu.setItem(Mine.getPosition(4, 2), vermelho);
				menu.setItem(Mine.getPosition(5, 2), verde25);
				menu.setItem(Mine.getPosition(2, 8), vermelho);
				menu.setItem(Mine.getPosition(3, 8), vermelho);
				menu.setItem(Mine.getPosition(4, 8), vermelho);
				menu.setItem(Mine.getPosition(5, 8), verde25);
			}
 			if(EventosSuporte.etapa1 == true) {
				menu.setItem(Mine.getPosition(2, 2), vermelho);
				menu.setItem(Mine.getPosition(3, 2), vermelho);
				menu.setItem(Mine.getPosition(4, 2), verde50);
				menu.setItem(Mine.getPosition(5, 2), verde50);
				menu.setItem(Mine.getPosition(2, 8), vermelho);
				menu.setItem(Mine.getPosition(3, 8), vermelho);
				menu.setItem(Mine.getPosition(4, 8), verde50);
				menu.setItem(Mine.getPosition(5, 8), verde50);
			}
 			if(EventosSuporte.etapa2 == true) {
				menu.setItem(Mine.getPosition(2, 2), vermelho);
				menu.setItem(Mine.getPosition(3, 2), verde75);
				menu.setItem(Mine.getPosition(4, 2), verde75);
				menu.setItem(Mine.getPosition(5, 2), verde75);
				menu.setItem(Mine.getPosition(2, 8), vermelho);
				menu.setItem(Mine.getPosition(3, 8), verde75);
				menu.setItem(Mine.getPosition(4, 8), verde75);
				menu.setItem(Mine.getPosition(5, 8), verde75);
			}
 			if(EventosSuporte.etapa3 == true) {
				menu.setItem(Mine.getPosition(2, 2), verde100);
				menu.setItem(Mine.getPosition(3, 2), verde100);
				menu.setItem(Mine.getPosition(4, 2), verde100);
				menu.setItem(Mine.getPosition(5, 2), verde100);
				menu.setItem(Mine.getPosition(2, 8), verde100);
				menu.setItem(Mine.getPosition(3, 8), verde100);
				menu.setItem(Mine.getPosition(4, 8), verde100);
				menu.setItem(Mine.getPosition(5, 8), verde100);
			}
				p.openInventory(menu);
			}
		}
	}
	}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("Suporte de poção")) {
		if(e.getCurrentItem() != null) {
			if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
			if(EventosSuporte.etapa0 == true || EventosSuporte.etapa1 == true || EventosSuporte.etapa2 == true) {
				e.setCancelled(true);
			}
			if(EventosSuporte.etapa3 == true) {
				if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
					e.setCancelled(false);
				}
			}
		}
		}
	}
	
	@EventHandler
	public void aoBeber(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItem() != null) {
			if(e.getItem().getType() == Material.GOLDEN_APPLE) {
				new BukkitRunnable() {
					
					@Override
					public void run() {
						Mine.removeEffects(p);
					}
				}.runTaskLater(Main.getPlugin(Main.class), 3);
				if(e.getItem().getItemMeta().getDisplayName() != null) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aZumbi Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Zumbi! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 1F, 1F);
				if(mob.get(p) == null) {
					mob.put(p, "zumbi");
					new BukkitRunnable() {
						@Override
						public void run() {
							if(!mob.containsKey(p)) {
								cancel();
							}
							
							if(mob.containsKey(p)) {
								i--;
								p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
								if(i <= 0) {
									p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
									mob.remove(p);
								}
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
				}else {
					i = 60;
					mob.put(p, "zumbi");
				}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAranha Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Aranha! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "aranha");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "aranha");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEnderman Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Enderman! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "enderman");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "enderman");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVaca Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Vaca! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "vaca");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "vaca");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCreeper Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Creeper! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_HURT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "creeper");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "creeper");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGalinha Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Galinha! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_AMBIENT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "galinha");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "galinha");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGhast Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Ghast! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "ghast");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									if(i == 50) {
										p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
									}
									if(i == 40) {
										p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
									}
									if(i == 30) {
										p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
									}
									if(i == 20) {
										p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
									}
									if(i == 10) {
										p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1F, 1F);
									}
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "ghast");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVillager Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Villager! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "villager");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "villager");
					}
				}
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEnder Dragon Potion")) {
					i = 60;
					p.sendMessage("\n §aVocê bebeu a §a§lPoção de Dragão do Fim! §aVocê ficará com efeitos por 1 minuto!\n ");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1F, 1F);
					if(mob.get(p) == null) {
						mob.put(p, "enderdragon");
						new BukkitRunnable() {
							@Override
							public void run() {
								if(!mob.containsKey(p)) {
									cancel();
								}
								
								if(mob.containsKey(p)) {
									i--;
									p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVocê perderá seus efeitos em "+i+" segundos!"));
									if(i <= 0) {
										p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
										mob.remove(p);
									}
								}
							}
						}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
					}else {
						i = 60;
						mob.put(p, "enderdragon");
					}
				}
				}
			}
			if(e.getItem().getType() == Material.MILK_BUCKET) {
				if(mob.containsKey(p)) {
				p.sendMessage("§cVocê perdeu seus efeitos de "+mob.get(p)+" :(");
				mob.remove(p);
				}
			}
		}
	}
	
	@EventHandler
	public void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
	if(mob.get(p) != null) {
		if(mob.get(p).equalsIgnoreCase("zumbi")) {
			 p.getWorld().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 30);
		}
		if(mob.get(p).equalsIgnoreCase("aranha")) {
			if(Mine.getChance(0.10)) {
				Location loc = new Location(p.getWorld(), Mine.getRandomDouble(p.getLocation().getX()-5, p.getLocation().getX()+5), Mine.getRandomDouble(p.getLocation().getY()+1, p.getLocation().getY()+5), Mine.getRandomDouble(p.getLocation().getZ()-5, p.getLocation().getZ()+5));
				if(p.getWorld().getBlockAt(loc).getType() == Material.AIR) {
					p.getWorld().getBlockAt(loc).setType(Material.WEB);
				}
			}
		}
		if(mob.get(p).equalsIgnoreCase("enderman")) {
			if(Mine.getChance(0.60)) {
				Location loc = new Location(p.getWorld(), Mine.getRandomDouble(p.getLocation().getX()-5, p.getLocation().getX()+5), Mine.getRandomDouble(p.getLocation().getY(), p.getLocation().getY()+3), Mine.getRandomDouble(p.getLocation().getZ()-5, p.getLocation().getZ()+5));
				p.getWorld().dropItem(loc, Mine.newItem(Material.ENDER_PEARL, null));
			}
		}
		if(mob.get(p).equalsIgnoreCase("galinha")) {
			if(Mine.getChance(0.60)) {
				Location loc = new Location(p.getWorld(), Mine.getRandomDouble(p.getLocation().getX()-5, p.getLocation().getX()+5), Mine.getRandomDouble(p.getLocation().getY(), p.getLocation().getY()+3), Mine.getRandomDouble(p.getLocation().getZ()-5, p.getLocation().getZ()+5));
				p.getWorld().dropItem(loc, Mine.newItem(Material.EGG, null));
			}
			Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()-2, p.getLocation().getZ());
			if(p.isOnGround() == false) {
				if(p.isFlying() == false) {
					if(p.getWorld().getBlockAt(loc).getType() == Material.AIR) {
			p.setVelocity(p.getVelocity().setY(-0.15F));
					}
				}
			}
		}
		if(mob.get(p).equalsIgnoreCase("enderdragon")) {
			if(e.getTo().getBlockX() > e.getFrom().getBlockX() || e.getTo().getBlockX() < e.getFrom().getBlockX() || e.getTo().getBlockZ() > e.getFrom().getBlockZ() || e.getTo().getBlockZ() < e.getFrom().getBlockZ()) {
				p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 1F, 1F);
			}
			for(int x = -3; x < 3; x++) {
				for(int y = 0; y < 3; y++) {
					for(int z = -3; z < 3; z++) {
						Location loc = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
						p.getWorld().getBlockAt(loc).setType(Material.AIR);
					}
				}
			}
		}
	}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		EquipmentSlot es = e.getHand();
	if(mob.get(p) != null) {
		if(mob.get(p).equalsIgnoreCase("zumbi")) {
			if(es.equals(EquipmentSlot.HAND)) {
				if(p.getInventory().getItemInMainHand().getType() != Material.GOLDEN_APPLE) {
				if(e.getClickedBlock() != null) {
				Location loc = new Location(p.getWorld(), e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ());
				p.getWorld().spawn(loc, Zombie.class);
				}
				}
			}
		}
		if(mob.get(p).equalsIgnoreCase("enderman")) {
			if(e.getAction() == Action.LEFT_CLICK_AIR) {
			Block bloco = p.getTargetBlock(null, 500);
			Location loc = new Location(p.getWorld(), bloco.getX(), bloco.getY()+1, bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
			p.teleport(loc);
			p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1F, 1F);
				}
			}
		if(mob.get(p).equalsIgnoreCase("ghast")) {
			if(e.getAction() == Action.LEFT_CLICK_AIR) {
				Location loc = new Location(p.getWorld(), p.getEyeLocation().getX()+1, p.getEyeLocation().getY(), p.getEyeLocation().getZ()+1, p.getEyeLocation().getYaw(), p.getEyeLocation().getPitch());
				p.getWorld().spawnEntity(loc, EntityType.FIREBALL);
			}
	}
		if(mob.get(p).equalsIgnoreCase("enderdragon")) {
			if(e.getAction() == Action.LEFT_CLICK_AIR) {
				Location loc = new Location(p.getWorld(), p.getEyeLocation().getX()+1, p.getEyeLocation().getY(), p.getEyeLocation().getZ()+1, p.getEyeLocation().getYaw(), p.getEyeLocation().getPitch());
				p.getWorld().spawnEntity(loc, EntityType.WITHER_SKULL);
				Block bloco = p.getTargetBlock(null, 500);
				Location loc2 = new Location(p.getWorld(), bloco.getX(), bloco.getY()+1, bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				p.getWorld().strikeLightning(loc2);
			}
		}
		
	}
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
	if(mob.get(p) != null) {
		if(mob.get(p).equalsIgnoreCase("aranha")) {
			if(e.isSneaking() == true) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 2, false, false), false);
			}else {
				p.removePotionEffect(PotionEffectType.LEVITATION);
			}
		}
		if(mob.get(p).equalsIgnoreCase("creeper")) {
			if(e.isSneaking() == true) {
				p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
				new BukkitRunnable() {
					int i = 10;
					@Override
					public void run() {
						i--;
						p.getWorld().spigot().playEffect(p.getLocation(), Effect.CLOUD, 0, 0, 0.5F, 1F, 0.5F, 0.002F, 15, 15);
						if(i <= 0) {
							cancel();
							i=10;
						}
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						p.getWorld().createExplosion(p.getLocation(), 5F);
					}
				}.runTaskLater(Main.getPlugin(Main.class), 3*20);
			}
		}
	}
	}
	
	@EventHandler
	public void aoLeite(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		EquipmentSlot es = e.getHand();
		if(e.getRightClicked() != null) {
			if(e.getRightClicked().getType() == EntityType.PLAYER) {
				Player j = (Player) e.getRightClicked();
			if(mob.get(j) != null) {
				if(mob.get(j).equalsIgnoreCase("vaca")) {
					if(p.getInventory().getItemInMainHand().getType() == Material.BUCKET) {
						if(es.equals(EquipmentSlot.HAND)) {
						p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
						p.getInventory().addItem(Mine.newItem(Material.MILK_BUCKET, null));
						p.playSound(p.getLocation(), Sound.ENTITY_COW_MILK, 1F, 1F);
					}
					}
				}
			}
			}
		}
	}
	
	@EventHandler
	public void onDano(EntityDamageEvent e) {
		
		if(e.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
			
			if(mob.get(p) != null) {
				if(mob.get(p).equalsIgnoreCase("creeper")) {
					if(e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION) {
						e.setCancelled(true);
					}
				}
				if(mob.get(p).equalsIgnoreCase("galinha")) {
					if(e.getCause() == DamageCause.FALL) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void seguir(EntityTargetEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			if(e.getTarget() != null) {
			if(e.getTarget().getType() == EntityType.PLAYER) {
				Player j = (Player) e.getTarget();
				if(mob.get(j) != null) {
				if(mob.get(j).equalsIgnoreCase("zumbi")) {
					e.setCancelled(true);
				}
				}
			}
			}
		}
	}

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(mob.get(p) != null) {
			if(mob.get(p).equalsIgnoreCase("villager")) {
				if(e.getBlock().getType() == Material.COAL_ORE) {
					e.getBlock().setType(Material.AIR);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EMERALD, Mine.getRandomInt(1, 3)));
						}
					}.runTaskLater(Main.getPlugin(Main.class), 5);
				}
			}
		}
	}
	
}
