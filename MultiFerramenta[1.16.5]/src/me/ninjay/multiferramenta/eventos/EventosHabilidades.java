package me.ninjay.multiferramenta.eventos;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.multiferramenta.main.Main;
import me.ninjay.multiferramenta.utils.Mine;


public class EventosHabilidades implements Listener{
	
/*
	if(p.getInventory().getItemInMainHand() != null) {
		if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Iniciante")) {
				}
			}
		}
	}
*/
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onBreak(BlockBreakEvent e) {

		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")  || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
						if(e.getBlock().getType() == Material.SAND || e.getBlock().getType() == Material.DIRT) {
							if(Mine.getChance(0.20)) {
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.BONE));
							}
						}
					}
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().
							contains("Especialista") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
						if(e.getBlock().getType() == Material.OAK_LEAVES || e.getBlock().getType() == Material.BIRCH_LEAVES || e.getBlock().getType() == Material.ACACIA_LEAVES || e.getBlock().getType() == Material.DARK_OAK_LEAVES || e.getBlock().getType() == Material.JUNGLE_LEAVES || e.getBlock().getType() == Material.SPRUCE_LEAVES) {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLDEN_APPLE));
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onBreakArea(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Iniciante")) {
						for(int x = (int)-1.5; x <= 1.5; x++) {
							for(int y = (int)-1.5; y <= 1.5; y++) {
								for(int z = (int)-1.5; z <= 1.5; z++) {
									p.getWorld().getBlockAt(e.getBlock().getLocation().add(x, y, z)).breakNaturally();
								}
							}
						}
					}
					new BukkitRunnable() {
						
						@Override
						public void run() {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario")) {
							for(int x = 0; x < 1.5; x++) {
								for(int y = 0; y < 1.5; y++) {
									for(int z = 0; z < 1.5; z++) {
										Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
										Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
										Location loc3 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
										Location loc4 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
										Location loc5 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
										Location loc6 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
										Location loc7 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
										Location loc8 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
									
											
										if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
									if(p.getWorld().getBlockAt(loc1).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc1).breakNaturally();
									}	
									
									if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
										
										if(p.getWorld().getBlockAt(loc2).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc2).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc3).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc4).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc5).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc6).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc7).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() == Material.IRON_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_INGOT));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
										p.getWorld().getBlockAt(loc8).breakNaturally();
										}
										if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
									if(p.getWorld().getBlockAt(loc1).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc1).breakNaturally();
									}	
									
									if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
										
										if(p.getWorld().getBlockAt(loc2).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc2).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc3).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc4).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc5).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc5).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc6).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc6).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc7).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc7).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.COAL));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc8).getType() == Material.LAPIS_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.LAPIS_ORE ) {
										p.getWorld().getBlockAt(loc8).breakNaturally();
										}
										if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc1).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
									if(p.getWorld().getBlockAt(loc1).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc1).breakNaturally();
									}	
									
									if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc2).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
										
										if(p.getWorld().getBlockAt(loc2).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc2).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc3).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc3).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc3).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc4).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc4).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc4).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc5).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc5).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc5).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc5).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc6).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc6).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc6).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc6).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc7).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc7).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc7).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc7).breakNaturally();
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() == Material.DIAMOND_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.DIAMOND));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										if(p.getWorld().getBlockAt(loc8).getType() == Material.REDSTONE_ORE) {
											p.getWorld().getBlockAt(loc8).setType(Material.AIR);
											new BukkitRunnable() {
												
												@Override
												public void run() {
													p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.REDSTONE));
												}
											}.runTaskLater(Main.getPlugin(Main.class), 3);
										}
										
										if(p.getWorld().getBlockAt(loc8).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.REDSTONE_ORE ) {
										p.getWorld().getBlockAt(loc8).breakNaturally();
										}
									}
							}
						}
					}
						}
					}.runTaskLater(Main.getPlugin(Main.class), 1);
					
				new BukkitRunnable() {
					
					@Override
					public void run() {
						
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")  || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista")) {
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
								
									if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_INGOT));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_INGOT));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.COAL));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.COAL));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.LAPIS_LAZULI));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.DIAMOND));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.REDSTONE));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.DIAMOND));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.REDSTONE));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
								}
						}
					}
				}
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch")) {
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
								
									if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_INGOT, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.COAL, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.COAL, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.DIAMOND, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.REDSTONE, 4));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.DIAMOND, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.REDSTONE, 4));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
								}
						}
					}
				}
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
						for(int x = 0; x < 5; x++) {
							for(int y = 0; y < 5; y++) {
								for(int z = 0; z < 5; z++) {
									Location loc1 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
									Location loc2 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
									Location loc3 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()-z);
									Location loc4 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()+y, e.getBlock().getZ()+z);
									Location loc5 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
									Location loc6 = new Location(p.getWorld(), e.getBlock().getX()+x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
									Location loc7 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()-z);
									Location loc8 = new Location(p.getWorld(), e.getBlock().getX()-x, e.getBlock().getY()-y, e.getBlock().getZ()+z);
								
									if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.IRON_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.IRON_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.GOLD_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.GOLD_INGOT, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.IRON_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.GOLD_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.COAL, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.COAL_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.COAL, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.LAPIS_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.LAPIS_LAZULI, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.COAL_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.LAPIS_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc1).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc1).getWorld().dropItem(p.getWorld().getBlockAt(loc1).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
								if(p.getWorld().getBlockAt(loc1).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc1).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc1).breakNaturally();
								}	
								
								if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.DIAMOND, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
								if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
									p.getWorld().getBlockAt(loc2).setType(Material.AIR);
									new BukkitRunnable() {
										
										@Override
										public void run() {
											p.getWorld().getBlockAt(loc2).getWorld().dropItem(p.getWorld().getBlockAt(loc2).getLocation(), new ItemStack(Material.REDSTONE, 16));
										}
									}.runTaskLater(Main.getPlugin(Main.class), 3);
								}
									
									if(p.getWorld().getBlockAt(loc2).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc2).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc2).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc3).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc3).getWorld().dropItem(p.getWorld().getBlockAt(loc3).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc3).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc3).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc3).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc4).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc4).getWorld().dropItem(p.getWorld().getBlockAt(loc4).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc4).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc4).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc4).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc5).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc5).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc5).getWorld().dropItem(p.getWorld().getBlockAt(loc5).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc5).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc5).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc5).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc6).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc6).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc6).getWorld().dropItem(p.getWorld().getBlockAt(loc6).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc6).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc6).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc6).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc7).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc7).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc7).getWorld().dropItem(p.getWorld().getBlockAt(loc7).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc7).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc7).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc7).breakNaturally();
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() == Material.DIAMOND_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.DIAMOND, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									if(p.getWorld().getBlockAt(loc8).getType() == Material.REDSTONE_ORE) {
										p.getWorld().getBlockAt(loc8).setType(Material.AIR);
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.getWorld().getBlockAt(loc8).getWorld().dropItem(p.getWorld().getBlockAt(loc8).getLocation(), new ItemStack(Material.REDSTONE, 16));
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
									}
									
									if(p.getWorld().getBlockAt(loc8).getType() != Material.DIAMOND_ORE || p.getWorld().getBlockAt(loc8).getType() != Material.REDSTONE_ORE ) {
									p.getWorld().getBlockAt(loc8).breakNaturally();
									}
								}
						}
					}
				}
					}
				}.runTaskLater(Main.getPlugin(Main.class), 1);
				}
			}
		}
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getEntity().getKiller() != null) {
			if(e.getEntity().getKiller().getType() == EntityType.PLAYER) {
				Player p = e.getEntity().getKiller();
				
				if(p.getInventory().getItemInMainHand() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Intermediario") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")  || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
								e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation().add(0, 0.3, 0), new ItemStack(Material.GOLDEN_APPLE));
							}
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Avancado") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Profissional")  || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Especialista") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Elite") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
								for(ItemStack drops : e.getDrops()) {
									if(drops != null) {
										drops.setAmount(drops.getAmount()*2);
									}
								}
							}
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch")) {
								for(ItemStack drops : e.getDrops()) {
									if(drops != null) {
										for(int i = 1; i <= 8; i++) {
											e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(drops.getType(), drops.getAmount()));
										}
									}
								}
							}
							
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
								for(ItemStack drops : e.getDrops()) {
									if(drops != null) {
										for(int i = 1; i <= 16; i++) {
											e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(drops.getType(), drops.getAmount()));
										}
									}
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
	public void onHit(EntityDamageByEntityEvent e) {

		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getDamager().getType() == EntityType.PLAYER) {
					Player p = (Player) e.getDamager();
					
					if(p.getInventory().getItemInMainHand() != null) {
						if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
							if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
								if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Notch") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
									if(e.getEntity() instanceof LivingEntity) {
										LivingEntity l = (LivingEntity) e.getEntity();
										new BukkitRunnable() {
											
											@Override
											public void run() {
												l.damage(Integer.MAX_VALUE);
											}
										}.runTaskLater(Main.getPlugin(Main.class), 3);
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
	public void onPick(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		
	new BukkitRunnable() {
		
		@Override
		public void run() {
			
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Deus")) {
						if(p.getGameMode() == GameMode.SURVIVAL) {
							p.setAllowFlight(true);
							p.setFlying(true);
						}
					}else if(p.getGameMode() != GameMode.CREATIVE){
						p.setAllowFlight(false);
						p.setFlying(false);
					}
				}else if(p.getGameMode() != GameMode.CREATIVE){
					p.setAllowFlight(false);
					p.setFlying(false);
				}
			}else if(p.getGameMode() != GameMode.CREATIVE){
				p.setAllowFlight(false);
				p.setFlying(false);
			}
		}else if(p.getGameMode() != GameMode.CREATIVE){
			p.setAllowFlight(false);
			p.setFlying(false);
		}
		}
		}.runTaskLater(Main.getPlugin(Main.class), 3);
	}
}
