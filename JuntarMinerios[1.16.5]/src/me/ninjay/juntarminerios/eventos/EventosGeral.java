package me.ninjay.juntarminerios.eventos;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.juntarminerios.estruturas.ItensAPI;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock() != null) {
			if(e.getBlock().getType() == Material.RED_CONCRETE) {
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
				Particle.DustOptions dust1 = new Particle.DustOptions(Color.YELLOW, 2);
				Particle.DustOptions dust2 = new Particle.DustOptions(Color.WHITE, 2);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust2);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
				Particle.DustOptions dust1 = new Particle.DustOptions(Color.YELLOW, 2);
				Particle.DustOptions dust2 = new Particle.DustOptions(Color.BLUE, 2);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust2);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
				Particle.DustOptions dust1 = new Particle.DustOptions(Color.GREEN, 2);
				Particle.DustOptions dust2 = new Particle.DustOptions(Color.BLUE, 2);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust2);
			    	}
			    }
			}
			if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1F, 1F);
				Particle.DustOptions dust1 = new Particle.DustOptions(Color.GRAY, 2);
				Particle.DustOptions dust2 = new Particle.DustOptions(Color.GREEN, 2);
				for(int x = 0; x < 3; x++) {
			    	for(int z = 0; z < 3; z++) {
			    		Location loc1 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		Location loc2 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc3 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()+x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()-z);
			    		Location loc4 = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX()-x, e.getBlock().getLocation().getY()+0.3, e.getBlock().getLocation().getZ()+z);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust1);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc1, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc2, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc3, 5, 0.1, 0.1, 0.1, dust2);
			    		e.getBlock().getWorld().spawnParticle(Particle.REDSTONE, loc4, 5, 0.1, 0.1, 0.1, dust2);
			    	}
			    }
			}
		}
	}

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock() != null) {
			if(e.getBlock().getType() == Material.RED_CONCRETE) {
				e.getBlock().setType(Material.AIR);
				for(int i = 1; i <= 9; i++) {
					e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.5, 0), ItensAPI.feuroi);
				}
			}
			if(e.getBlock().getType() == Material.BLUE_CONCRETE) {
				e.getBlock().setType(Material.AIR);
				for(int i = 1; i <= 9; i++) {
					e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.5, 0), ItensAPI.diamouroi);
				}
			}
			if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
				e.getBlock().setType(Material.AIR);
				for(int i = 1; i <= 9; i++) {
					e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.5, 0), ItensAPI.esmeldimai);
				}
			}
			if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
				e.getBlock().setType(Material.AIR);
				for(int i = 1; i <= 9; i++) {
					e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0, 0.5, 0), ItensAPI.netheraldai);
				}
			}
		}
	}
	
	@EventHandler
	public void onBreakItem(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand() != null) {
			if(p.getInventory().getItemInMainHand().getItemMeta() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Netheralda") || p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("netheralda")) {
					e.setCancelled(true);
				}
				}
			}
		}
		for(ItemStack armor : p.getInventory().getArmorContents()) {
			if(armor != null) {
				if(armor.getItemMeta() != null) {
					if(armor.getItemMeta().getDisplayName() != null) {
						if(armor.getItemMeta().getDisplayName().contains("Netheralda") || armor.getItemMeta().getDisplayName().contains("netheralda")) {
							e.setCancelled(true);
						}
					}
				}
			}
		}
	}
	
}
