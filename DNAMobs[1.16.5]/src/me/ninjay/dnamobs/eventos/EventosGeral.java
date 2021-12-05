package me.ninjay.dnamobs.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.dnamobs.estruturas.ItensAPI;
import me.ninjay.dnamobs.main.Main;
import me.ninjay.dnamobs.utils.Mine;

public class EventosGeral implements Listener{
	
	public static ArrayList<Player> creeper = new ArrayList<>();
	public static ArrayList<String> dna = new ArrayList<>();
	
	public static boolean um = false;
	public static boolean dois = false;
	public static boolean tres = false;
	
	@EventHandler
	public void dropDNA(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getCustomName() == null) {
				if(!(e.getEntity() instanceof Player)) {
					if(e.getEntity() instanceof Enderman) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.enderman);
					}
					if(e.getEntity() instanceof Guardian) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.guardian);
					}
					if(e.getEntity() instanceof Pig) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.porco);
					}
					if(e.getEntity() instanceof Spider) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.aranha);
					}
					if(e.getEntity() instanceof Blaze) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.blaze);
					}
					if(e.getEntity() instanceof Skeleton) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.esqueleto);
					}
					if(e.getEntity() instanceof Creeper) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.creeper);
					}
					if(e.getEntity() instanceof Hoglin) {
						e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.hoglin);
					}
				}
			}
		}
		
	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getCustomName() != null) {
				if(e.getEntity().getCustomName().equalsIgnoreCase("§8guarderman")) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.endermanguardian);
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.HEART_OF_THE_SEA, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.ENDER_PEARL, Mine.getRandomInt(1, 5)));
					for(Entity entity : e.getEntity().getWorld().getEntitiesByClass(Guardian.class)) {
						if(entity.getCustomName() != null) {
							if(entity.getCustomName().equalsIgnoreCase("§8enderlaser")) {
								entity.remove();
							}
						}
					}
				}
				if(e.getEntity().getCustomName().equalsIgnoreCase("§8pigranha")) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.porcoaranha);
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.STRING, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.PORKCHOP, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_PIG_DEATH, 1F, 1F);
				}
				
				if(e.getEntity().getCustomName().equalsIgnoreCase("§8blazeleton")) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.blazeesqueleto);
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.BLAZE_ROD, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.BOW));
					for(Entity entity : e.getEntity().getWorld().getEntitiesByClass(Skeleton.class)) {
						if(entity.getCustomName() != null) {
							if(entity.getCustomName().equalsIgnoreCase("§8blazelaser")) {
								entity.remove();
							}
						}
					}
				}
				
				if(e.getEntity().getCustomName().equalsIgnoreCase("§8creglin")) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), ItensAPI.creeperhoglin);
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.ROTTEN_FLESH, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.GUNPOWDER, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.CREEPER_HEAD, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CREEPER_DEATH, 1F, 1F);
				}
				
				if(e.getEntity().getCustomName().equalsIgnoreCase("§8encreranhaglinleton")) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.STRING, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.ROTTEN_FLESH, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.BLAZE_ROD, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.GUNPOWDER, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLD_INGOT, Mine.getRandomInt(1, 5)));
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.ENDER_PEARL, Mine.getRandomInt(1, 5)));
					for(Entity entity : e.getEntity().getWorld().getEntitiesByClass(Skeleton.class)) {
						if(entity.getCustomName() != null) {
							if(entity.getCustomName().equalsIgnoreCase("§8um")) {
								entity.remove();
							}
						}
					}
					
					for(Entity entity : e.getEntity().getWorld().getEntitiesByClass(Blaze.class)) {
						if(entity.getCustomName() != null) {
							if(entity.getCustomName().equalsIgnoreCase("§8dois")) {
								entity.remove();
							}
						}
					}
					
					for(Entity entity : e.getEntity().getWorld().getEntitiesByClass(Guardian.class)) {
						if(entity.getCustomName() != null) {
							if(entity.getCustomName().equalsIgnoreCase("§8tres")) {
								entity.remove();
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getDamager() != null) {
			if(e.getDamager() instanceof Hoglin) {
				if(e.getDamager().getCustomName() != null) {
					if(e.getDamager().getCustomName().contains("§8creglin")) {
						if(e.getEntity() != null) {
							if(e.getEntity() instanceof Player) {
								Player p = (Player) e.getEntity();
								
							if(creeper == null || !creeper.contains(p)) {
								creeper.add(p);
								p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
								new BukkitRunnable() {
									
									@Override
									public void run() {
										p.getWorld().createExplosion(e.getEntity().getLocation(), 3F);
										e.getDamager().remove();
										creeper.remove(p);
									}
								}.runTaskLater(Main.getPlugin(Main.class), 5*20);
							}
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void useEgg(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock() != null) {
				if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.endermanguardianegg)) {
					e.setCancelled(true);
					p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
					
					p.spawnParticle(Particle.MOB_APPEARANCE, p.getLocation(), 100, 0.1, 0.1, 0.1, 0.1);
					p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 1F);
					
					Guardian laser = p.getWorld().spawn(e.getClickedBlock().getLocation(), Guardian.class);
					laser.setInvisible(true);
					laser.setInvulnerable(true);
					laser.setMaxHealth(2048.0);
					laser.setHealth(2048.0);
					laser.setAware(true);
					laser.setPersistent(true);
					laser.setTarget(p);
					laser.setCustomName("§8enderlaser");
					
					Enderman enderguard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Enderman.class);
					enderguard.setCustomNameVisible(false);
					enderguard.setCustomName("§8guarderman");
					enderguard.setMaxHealth(80.0);
					enderguard.setHealth(80.0);
					enderguard.setAware(true);
					enderguard.setPersistent(true);
					enderguard.setTarget(p);
					enderguard.setPassenger(laser);
				}
				
				if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.porcoaranhaegg)) {
					e.setCancelled(true);
					p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
				
					Spider enderguard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Spider.class);
					enderguard.setCustomNameVisible(false);
					enderguard.setCustomName("§8pigranha");
					enderguard.setMaxHealth(32.0);
					enderguard.setHealth(32.0);
					enderguard.setAware(true);
					enderguard.setPersistent(true);
					enderguard.setTarget(p);
				}
				
				if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.blazeesqueletoegg)) {
					e.setCancelled(true);
					p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
				
					Skeleton laser = p.getWorld().spawn(e.getClickedBlock().getLocation(), Skeleton.class);
					laser.setInvisible(true);
					laser.setMaxHealth(40.0);
					laser.setHealth(40.0);
					laser.setAware(true);
					laser.setPersistent(true);
					laser.setTarget(p);
					laser.setCustomName("§8blazelaser");
					
					Blaze enderguard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Blaze.class);
					enderguard.setCustomNameVisible(false);
					enderguard.setCustomName("§8blazeleton");
					enderguard.setMaxHealth(40.0);
					enderguard.setHealth(40.0);
					enderguard.setAware(true);
					enderguard.setPersistent(true);
					enderguard.setTarget(p);
					enderguard.setPassenger(laser);
					
				}
				
				if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.creeperhoglinegg)) {
					e.setCancelled(true);
					p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
				
					Hoglin enderguard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Hoglin.class);
					enderguard.setCustomNameVisible(false);
					enderguard.setCustomName("§8creglin");
					enderguard.setMaxHealth(80.0);
					enderguard.setHealth(80.0);
					enderguard.setAware(true);
					enderguard.setPersistent(true);
					enderguard.setTarget(p);
					enderguard.setAdult();
				}
				
				if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.eggfinal)) {
					e.setCancelled(true);
					p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
				
					Guardian guard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Guardian.class);
					guard.setCustomNameVisible(false);
					guard.setCustomName("§8tres");
					guard.setInvisible(true);
					guard.setInvulnerable(true);
					guard.setAware(true);
					guard.setPersistent(true);
					guard.setTarget(p);
					
					Blaze blaze = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Blaze.class);
					blaze.setCustomNameVisible(false);
					blaze.setCustomName("§8dois");
					blaze.setInvulnerable(true);
					blaze.setInvisible(true);
					blaze.setAware(true);
					blaze.setPersistent(true);
					blaze.setTarget(p);
					blaze.setPassenger(guard);
					
					Skeleton laser = p.getWorld().spawn(e.getClickedBlock().getLocation(), Skeleton.class);
					laser.setInvisible(true);
					laser.setInvulnerable(true);
					laser.setAware(true);
					laser.setPersistent(true);
					laser.setTarget(p);
					laser.setCustomName("§8um");
					laser.setPassenger(blaze);
					
					IronGolem enderguard = p.getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), IronGolem.class);
					enderguard.setCustomNameVisible(false);
					enderguard.setCustomName("§8encreranhaglinleton");
					enderguard.setMaxHealth(200.0);
					enderguard.setHealth(200.0);
					enderguard.setAware(true);
					enderguard.setPersistent(true);
					enderguard.setTarget(p);
					enderguard.setPassenger(laser);
					
				}
			}
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.enderman)) {
			if(!dna.contains("enderman")) {
				if(!dna.contains("guardiao")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("enderman");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §5§o'DNA de Enderman' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §3§o'DNA de Guardiao'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("enderman");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.endermanguardianegg);
										dna.remove("enderman");
										dna.remove("guardiao");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §5§o'DNA de Enderman' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.guardian)) {
			if(!dna.contains("guardiao")) {
				if(!dna.contains("enderman")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("guardiao");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §3§o'DNA de Guardiao' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §5§o'DNA de Enderman'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("guardiao");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.endermanguardianegg);
										dna.remove("enderman");
										dna.remove("guardiao");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §3§o'DNA de Guardiao' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.porco)) {
			if(!dna.contains("porco")) {
				if(!dna.contains("aranha")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("porco");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §d§o'DNA de Porco' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §4§o'DNA de Aranha'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("porco");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.porcoaranhaegg);
										dna.remove("porco");
										dna.remove("aranha");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §d§o'DNA de Porco' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.aranha)) {
			if(!dna.contains("aranha")) {
				if(!dna.contains("porco")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("aranha");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §4§o'DNA de Aranha' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §d§o'DNA de Porco'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("aranha");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.porcoaranhaegg);
										dna.remove("porco");
										dna.remove("aranha");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §4§o'DNA de Aranha' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.blaze)) {
			if(!dna.contains("blaze")) {
				if(!dna.contains("esqueleto")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("blaze");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §6§o'DNA de Blaze' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §7§o'DNA de Esqueleto'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("blaze");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SKELETON_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SKELETON_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.blazeesqueletoegg);
										dna.remove("blaze");
										dna.remove("esqueleto");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §6§o'DNA de Blaze' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.esqueleto)) {
			if(!dna.contains("esqueleto")) {
				if(!dna.contains("blaze")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("esqueleto");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §7§o'DNA de Esqueleto' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §6§o'DNA de Blaze'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("esqueleto");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SKELETON_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_SKELETON_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.blazeesqueletoegg);
										dna.remove("blaze");
										dna.remove("esqueleto");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §7§o'DNA de Esqueleto' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.creeper)) {
			if(!dna.contains("creeper")) {
				if(!dna.contains("hoglin")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("creeper");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §2§o'DNA de Creeper' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §e§o'DNA de Hoglin'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("creeper");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_HOGLIN_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_HOGLIN_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.creeperhoglinegg);
										dna.remove("creeper");
										dna.remove("hoglin");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §2§o'DNA de Creeper' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.hoglin)) {
			if(!dna.contains("hoglin")) {
				if(!dna.contains("creeper")) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("hoglin");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							Bukkit.broadcastMessage(" \n§aO §e§o'DNA de Hoglin' §afoi adicionado nas combinações!\nPara formar a combinação complete com um §2§o'DNA de Creeper'§a!\n ");
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}else {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							dna.add("hoglin");
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
							e.getItemDrop().remove();
							new BukkitRunnable() {
								int i = 10;
								@Override
								public void run() {
									i--;
									Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
									Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
									Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
									Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
									Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
									
									if(i == 9) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i == 7) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_HOGLIN_AMBIENT, 1F, 1F);
									}
									
									if(i == 5) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i == 3) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_HOGLIN_AMBIENT, 1F, 1F);
									}
									
									if(i == 1) {
										p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
										p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
									}
									
									if(i <= -2) {
										cancel();
										p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
										p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.creeperhoglinegg);
										dna.remove("creeper");
										dna.remove("hoglin");
									}
								}
							}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				}
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §e§o'DNA de Hoglin' §cjá está adicionado nas combinações!\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.endermanguardian)) {
			if(um == false) {
				new BukkitRunnable() {
					
					@Override
					public void run() {
						um=true;
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						e.getItemDrop().remove();
						Bukkit.broadcastMessage(" \n§aO §e'DNA de §5Enderman §3Guardian' §afoi adicionado nas combinações!\n ");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1*20);
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §e'DNA de §5Enderman §3Guardian' §cjá está adicionado nas combinações!\n ");
			}
		}else if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.porcoaranha) || e.getItemDrop().getItemStack().isSimilar(ItensAPI.blazeesqueleto) || e.getItemDrop().getItemStack().isSimilar(ItensAPI.creeperhoglin)) {
			if(um == false) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§aPara formar o mob final use a seguinte combinação:\n  1º §eDNA de §5Enderman §3Guardian\n  §a2º §eDNA de §dPorco §4Aranha\n  §a3º §eDNA de §6Blaze §7Esqueleto\n  §a4º §eDNA de §2Creeper §eHoglin\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.porcoaranha)) {
			if(um == true) {
				if(dois == false) {
				new BukkitRunnable() {
					
					@Override
					public void run() {
						dois=true;
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						e.getItemDrop().remove();
						Bukkit.broadcastMessage(" \n§aO §e'DNA de §dPorco §4Aranha' §afoi adicionado nas combinações!\n ");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1*20);
				
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §e'DNA de §dPorco §4Aranha' §cjá está adicionado nas combinações!\n ");
			}
		}
		}else if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.blazeesqueleto) || e.getItemDrop().getItemStack().isSimilar(ItensAPI.creeperhoglin)) {
			if(dois == false) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§aPara formar o mob final use a seguinte combinação:\n  1º §eDNA de §5Enderman §3Guardian\n  §a2º §eDNA de §dPorco §4Aranha\n  §a3º §eDNA de §6Blaze §7Esqueleto\n  §a4º §eDNA de §2Creeper §eHoglin\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.blazeesqueleto)) {
			if(um == true) {
				if(dois == true) {
					if(tres == false) {
				new BukkitRunnable() {
					
					@Override
					public void run() {
						tres=true;
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
						e.getItemDrop().remove();
						Bukkit.broadcastMessage(" \n§aO §e'DNA de §6Blaze §7Esqueleto' §afoi adicionado nas combinações!\n ");
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1*20);
			}else {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§cO §e'DNA de §6Blaze §7Esqueleto' §cjá está adicionado nas combinações!\n ");
			}
		}
		}
		}else if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.creeperhoglin)) {
			if(tres == false) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
				Bukkit.broadcastMessage(" \n§aPara formar o mob final use a seguinte combinação:\n  1º §eDNA de §5Enderman §3Guardian\n  §a2º §eDNA de §dPorco §4Aranha\n  §a3º §eDNA de §6Blaze §7Esqueleto\n  §a4º §eDNA de §2Creeper §eHoglin\n ");
			}
		}
		
		if(e.getItemDrop().getItemStack().isSimilar(ItensAPI.creeperhoglin)) {
			if(um == true) {
				if(dois == true) {
					if(tres == true) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								tres=false;
								dois=false;
								um=false;
								e.getItemDrop().remove();
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
								new BukkitRunnable() {
									int i = 10;
									@Override
									public void run() {
										i--;
										Particle.DustOptions dust = new Particle.DustOptions(Color.GREEN, 2);
										Particle.DustOptions dust2 = new Particle.DustOptions(Color.RED, 2);
										Particle.DustOptions dust3 = new Particle.DustOptions(Color.AQUA, 2);
										Particle.DustOptions dust4 = new Particle.DustOptions(Color.YELLOW, 2);
										Particle.DustOptions dust5 = new Particle.DustOptions(Color.FUCHSIA, 2);
										
										if(i == 9) {
											p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust);
											p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
										}
										
										if(i == 7) {
											p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust2);
											p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 1F, 1F);
										}
										
										if(i == 5) {
											p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust3);
											p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_PIG_AMBIENT, 1F, 1F);
										}
										
										if(i == 3) {
											p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust4);
											p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1F, 1F);
										}
										
										if(i == 1) {
											p.spawnParticle(Particle.REDSTONE, e.getItemDrop().getLocation(), 200, 2, 2, 2, 2, dust5);
											p.playSound(e.getItemDrop().getLocation(), Sound.ENTITY_HOGLIN_AMBIENT, 1F, 1F);
										}
										
										if(i <= -2) {
											cancel();
											p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
											p.getWorld().dropItemNaturally(e.getItemDrop().getLocation().add(0, 0.3, 0), ItensAPI.eggfinal);
										}
									}
								}.runTaskTimer(Main.getPlugin(Main.class), 10, 10);
							}
						}.runTaskLater(Main.getPlugin(Main.class), 1*20);
					}
				}
			}
		}
	}
	
}
