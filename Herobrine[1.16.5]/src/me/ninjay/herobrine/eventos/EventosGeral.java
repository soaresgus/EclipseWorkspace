package me.ninjay.herobrine.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import me.ninjay.herobrine.estruturas.ItensAPI;
import me.ninjay.herobrine.main.Main;
import me.ninjay.herobrine.utils.Mine;

public class EventosGeral implements Listener{
	
	public static ArrayList<Player> usando = new ArrayList<>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(e.getBlock().getType().toString().contains("STAINED_GLASS_PANE")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) { 
			Player p = (Player) e.getEntity();
			
			if(usando.contains(p)) {
				e.setDamage(0);
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
	if(e.getBlock().getType() == Material.GOLD_BLOCK) {
		Bukkit.broadcastMessage("§e"+p.getName()+"brine entrou no jogo");
		usando.remove(p);
		usando.add(p);
		p.chat("/daritens");
		p.chat("/skin Luzs");
		
		new BukkitRunnable() {
			int i = 10;
			@Override
			public void run() {
				i--;
				p.getWorld().strikeLightningEffect(p.getLocation());
				p.playSound(p.getLocation(), Sound.ENTITY_GHAST_DEATH, 1F, 1F);
				p.playSound(p.getLocation(), Sound.ENTITY_GHAST_AMBIENT, 1F, 1F);
				if(i <= 0) {
					cancel();
				}
 			}
		}.runTaskTimer(Main.getPlugin(Main.class), 5, 5);
	}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.a)) {
			p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.DIRT);
			
			List<Player> area = Mine.getPlayerAtRange(p.getLocation(), 10);
			area.remove(p);
			
			for(Player todos : area) {
			if(todos.getInventory().getHelmet() == null || todos.getInventory().getHelmet().getType() != Material.LEATHER_HELMET) {
				todos.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
				todos.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				todos.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
				todos.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
				todos.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
			}
			}
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.c)) {
			p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.ICE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*20, 4));
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.e)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*20, 4));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*20, 2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5*20, 1));
			
			List<Player> area = Mine.getPlayerAtRange(p.getLocation(), 10);
			area.remove(p);
			
			for(Player todos : area) {
			if(todos.getInventory().getHelmet() == null || todos.getInventory().getHelmet().getType() != Material.DIAMOND_HELMET) {
				todos.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
				todos.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
				todos.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
				todos.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
				todos.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
				todos.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*20, 4));
				todos.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*20, 2));
				todos.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5*20, 1));
			}
			}
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.f)) {
			if(Mine.getChance(0.10)) {
				p.getWorld().spawn(p.getLocation().add(Mine.getRandomDouble(-3, 3), Mine.getRandomDouble(0, 3), Mine.getRandomDouble(-3, 3)), Blaze.class);
			}
			
			List<Player> area = Mine.getPlayerAtRange(p.getLocation(), 20);
			area.remove(p);
			
			for(Player todos : area) {
			if(todos.getInventory().getHelmet() == null || todos.getInventory().getHelmet().getType() != Material.DIAMOND_HELMET) {
				todos.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 5*20, Integer.MAX_VALUE, false, false));
			}
			}
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.g)) {
			p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.MAGMA_BLOCK);
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.i)) {
			p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).setType(Material.GOLD_BLOCK);
		}
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.b)) {
			if(e.getAction().toString().contains("RIGHT_CLICK")) {
				for(int x = -5; x <= 5; x++) {
					for(int z = -5; z <= 5; z++) {
						p.getWorld().spawnArrow(p.getLocation().add(x, 10, z), new Vector(0, 0.2, 0), 0.0F, 0.0F);
					}
				}
				
			}
			
			if(e.getAction().toString().contains("LEFT_CLICK")) {
				p.launchProjectile(Arrow.class);
			}
			
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.d)) {
			if(e.getAction().toString().contains("RIGHT_CLICK")) {
				p.teleport(new Location(p.getWorld(), p.getTargetBlock(null, 500).getLocation().getX(), p.getTargetBlock(null, 500).getLocation().getY()+1, p.getTargetBlock(null, 500).getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F);
				for(int x = (int)-1.5; x <= 1.5; x++) {
					for(int y = (int)-1.5; y <= 1.5; y++) {
						for(int z = (int)-1.5; z <= 1.5; z++) {
							p.spawnParticle(Particle.PORTAL, p.getLocation().add(x, y, z), 50, 0.1, 0.1, 0.1);
						}
					}
				}
			}
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.g)) {
			if(e.getAction().toString().contains("RIGHT_CLICK")) {
				if(e.getClickedBlock() != null) {
				e.getClickedBlock().setType(Material.COAL_BLOCK);
				p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
				e.setCancelled(true);
				}
			}
			
			if(e.getAction().toString().contains("LEFT_CLICK")) {
				if(e.getClickedBlock() != null) {
				e.getClickedBlock().setType(Material.COAL_BLOCK);
				p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
				e.setCancelled(true);
				}
			}
			
		}
		
		if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.i)) {
			
			if(e.getAction().toString().contains("RIGHT_CLICK")) {
				if(p.getWorld().getTime() >= 0 && p.getWorld().getTime() < 13500) {
					p.getWorld().setTime(13500);
				}else if(p.getWorld().getTime() >= 13500) {
					p.getWorld().setTime(0);
				}
			}
			
		}
	
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();

	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.d)) {
		if(e.isSneaking() == false) { 
			
			p.spawnParticle(Particle.SQUID_INK, p.getLocation().add(0, 1, 0), 50, 0.1, 0.1, 0.1);
			p.playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1F, 1F);
			
			for(Entity mobs : p.getWorld().getNearbyEntities(BoundingBox.of(p.getLocation().add(-15, -15, -15), p.getLocation().add(15, 15, 15)))) {
				if(mobs.getType() != EntityType.PLAYER) {
					if(mobs instanceof LivingEntity) {
						p.getWorld().strikeLightning(mobs.getLocation());
						((LivingEntity) mobs).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 30*20, 1));
						p.spawnParticle(Particle.SQUID_INK, mobs.getLocation().add(0, 1, 0), 5, 0.1, 0.1 , 0.1);
					}
				}
			}
		}
	}
	
	if(p.getInventory().getItemInMainHand().isSimilar(ItensAPI.h)) {
		if(e.isSneaking() == false) { 
			p.getWorld().createExplosion(p.getLocation(), 15F);
		}
	}
	
		
	}
	
	@EventHandler
	public void onBravo(EntityTargetLivingEntityEvent e) {
	
	if(e.getEntity() instanceof Blaze) {
		if(e.getTarget() instanceof Player) {
				Player p = (Player) e.getTarget();
				
				if(usando.contains(p)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
}
