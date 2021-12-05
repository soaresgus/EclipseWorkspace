package me.ninjay.geleianether.eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Strider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import me.ninjay.geleianether.main.Main;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(e.getTo().getBlockX() > e.getFrom().getBlockX() || e.getTo().getBlockX() < e.getFrom().getBlockX() || e.getTo().getBlockZ() > e.getFrom().getBlockZ() || e.getTo().getBlockZ() < e.getFrom().getBlockZ() || e.getTo().getBlockY() > e.getFrom().getBlockY() || e.getTo().getBlockY() < e.getFrom().getBlockY()) {
			Location loc11 = new Location(p.getWorld(), p.getLocation().getX()+8, p.getLocation().getY()+8, p.getLocation().getZ()+8);
			Location loc22 = new Location(p.getWorld(), p.getLocation().getX()-8, p.getLocation().getY()-8, p.getLocation().getZ()-8);
			for(Entity entity : p.getWorld().getNearbyEntities(BoundingBox.of(loc11, loc22))) {
				if(entity != null) {
					if(entity.getType() == EntityType.PIG) {
						p.getWorld().spawn(entity.getLocation(), Hoglin.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.CHICKEN) {
						p.getWorld().spawn(entity.getLocation(), Ghast.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.SHEEP) {
						p.getWorld().spawn(entity.getLocation(), MagmaCube.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.SKELETON) {
						p.getWorld().spawn(entity.getLocation(), WitherSkeleton.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.ZOMBIE) {
						p.getWorld().spawn(entity.getLocation(), Blaze.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.CREEPER) {
						p.getWorld().spawn(entity.getLocation(), Piglin.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.COW) {
						p.getWorld().spawn(entity.getLocation(), Strider.class);
						entity.remove();
					}
					if(entity.getType() == EntityType.SPIDER) {
						p.getWorld().spawn(entity.getLocation(), Piglin.class);
						entity.remove();
					}
					
				}
			}
			
			
		for(int x = -8; x <= 8; x++) {
			for(int y = -8; y <= 8; y++) {
				for(int z = -8; z <= 8; z++) {
					Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
					Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
					Location loc3 = new Location(p.getWorld(), p.getLocation().getX()+x, p.getLocation().getY()+y, p.getLocation().getZ()-z);
					Location loc4 = new Location(p.getWorld(), p.getLocation().getX()-x, p.getLocation().getY()+y, p.getLocation().getZ()+z);
					
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GRASS) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_ROOTS);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.GRASS) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_ROOTS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GRASS) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_ROOTS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GRASS) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_ROOTS);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.ORANGE_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.ORANGE_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.ORANGE_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.COAL_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.ORANGE_CONCRETE);
						}
					}
					//
					
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.MAGENTA_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.MAGENTA_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.MAGENTA_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.IRON_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.MAGENTA_CONCRETE);
						}
					}
					//
					
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.LIGHT_BLUE_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.LIGHT_BLUE_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.LIGHT_BLUE_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GOLD_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.LIGHT_BLUE_CONCRETE);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.YELLOW_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.YELLOW_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.YELLOW_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.LAPIS_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.YELLOW_CONCRETE);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.LIME_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.LIME_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.LIME_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.REDSTONE_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.LIME_CONCRETE);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.PINK_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.PINK_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.PINK_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DIAMOND_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.PINK_CONCRETE);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.EMERALD_ORE) {
							p.getWorld().getBlockAt(loc1).setType(Material.GRAY_CONCRETE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.EMERALD_ORE) {
							p.getWorld().getBlockAt(loc2).setType(Material.GRAY_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.EMERALD_ORE) {
							p.getWorld().getBlockAt(loc3).setType(Material.GRAY_CONCRETE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.EMERALD_ORE) {
							p.getWorld().getBlockAt(loc4).setType(Material.GRAY_CONCRETE);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DIRT) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHERRACK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.DIRT) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DIRT) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DIRT) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHERRACK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.COARSE_DIRT) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHERRACK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.COARSE_DIRT) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.COARSE_DIRT) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.COARSE_DIRT) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHERRACK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.STONE) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHERRACK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.STONE) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.STONE) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.STONE) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHERRACK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.WATER) {
							p.getWorld().getBlockAt(loc1).setType(Material.LAVA);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.WATER) {
							p.getWorld().getBlockAt(loc2).setType(Material.LAVA);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.WATER) {
							p.getWorld().getBlockAt(loc3).setType(Material.LAVA);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.WATER) {
							p.getWorld().getBlockAt(loc4).setType(Material.LAVA);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.FIRE) {
							p.getWorld().getBlockAt(loc1).setType(Material.SOUL_FIRE);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.FIRE) {
							p.getWorld().getBlockAt(loc2).setType(Material.SOUL_FIRE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.FIRE) {
							p.getWorld().getBlockAt(loc3).setType(Material.SOUL_FIRE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.FIRE) {
							p.getWorld().getBlockAt(loc4).setType(Material.SOUL_FIRE);
						}
					}
					
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_FUNGUS);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_FUNGUS);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_FUNGUS);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.RED_MUSHROOM) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_FUNGUS);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.BROWN_MUSHROOM) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_FUNGUS);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.BROWN_MUSHROOM) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.BROWN_MUSHROOM) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_FUNGUS);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.BROWN_MUSHROOM) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_FUNGUS);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.BIRCH_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.BIRCH_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.BIRCH_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.BIRCH_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.ACACIA_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.ACACIA_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.ACACIA_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.ACACIA_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.OAK_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.OAK_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.OAK_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.OAK_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.SPRUCE_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.SPRUCE_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.SPRUCE_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.SPRUCE_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DARK_OAK_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.DARK_OAK_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DARK_OAK_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DARK_OAK_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.JUNGLE_LOG) {
							p.getWorld().getBlockAt(loc1).setType(Material.CRIMSON_STEM);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.JUNGLE_LOG) {
							p.getWorld().getBlockAt(loc2).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.JUNGLE_LOG) {
							p.getWorld().getBlockAt(loc3).setType(Material.CRIMSON_STEM);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.JUNGLE_LOG) {
							p.getWorld().getBlockAt(loc4).setType(Material.CRIMSON_STEM);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.ACACIA_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.ACACIA_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.ACACIA_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.ACACIA_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_WART_BLOCK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.BIRCH_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.BIRCH_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.BIRCH_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.BIRCH_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_WART_BLOCK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.OAK_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.WARPED_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.OAK_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.OAK_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.WARPED_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.OAK_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.WARPED_WART_BLOCK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.JUNGLE_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHER_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.JUNGLE_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.JUNGLE_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.JUNGLE_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHER_WART_BLOCK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DARK_OAK_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHER_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.DARK_OAK_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DARK_OAK_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DARK_OAK_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHER_WART_BLOCK);
						}
					}
					//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.SPRUCE_LEAVES) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHER_WART_BLOCK);
						}
					}
				
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.SPRUCE_LEAVES) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.SPRUCE_LEAVES) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHER_WART_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.SPRUCE_LEAVES) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHER_WART_BLOCK);
						}
					}
					//
					
				//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GRASS_BLOCK) {
							p.getWorld().getBlockAt(loc1).setType(Material.NETHERRACK);
						}
					}	
						
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.GRASS_BLOCK) {
							p.getWorld().getBlockAt(loc2).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GRASS_BLOCK) {
							p.getWorld().getBlockAt(loc3).setType(Material.NETHERRACK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GRASS_BLOCK) {
							p.getWorld().getBlockAt(loc4).setType(Material.NETHERRACK);
						}
					}
				//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.DIORITE) {
							p.getWorld().getBlockAt(loc1).setType(Material.BLACKSTONE);
						}
					}	
						
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.DIORITE) {
							p.getWorld().getBlockAt(loc2).setType(Material.BLACKSTONE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.DIORITE) {
							p.getWorld().getBlockAt(loc3).setType(Material.BLACKSTONE);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.DIORITE) {
							p.getWorld().getBlockAt(loc4).setType(Material.BLACKSTONE);
						}
					}
				//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.ANDESITE) {
							p.getWorld().getBlockAt(loc1).setType(Material.BASALT);
						}
					}	
						
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.ANDESITE) {
							p.getWorld().getBlockAt(loc2).setType(Material.BASALT);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.ANDESITE) {
							p.getWorld().getBlockAt(loc3).setType(Material.BASALT);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.ANDESITE) {
							p.getWorld().getBlockAt(loc4).setType(Material.BASALT);
						}
					}
				//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GRANITE) {
							p.getWorld().getBlockAt(loc1).setType(Material.MAGMA_BLOCK);
						}
					}	
						
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.GRANITE) {
							p.getWorld().getBlockAt(loc2).setType(Material.MAGMA_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GRANITE) {
							p.getWorld().getBlockAt(loc3).setType(Material.MAGMA_BLOCK);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GRANITE) {
							p.getWorld().getBlockAt(loc4).setType(Material.MAGMA_BLOCK);
						}
					}
				//
					
					//
					if(p.getWorld().getBlockAt(loc1) != null) {
						if(p.getWorld().getBlockAt(loc1).getType() == Material.GRAVEL) {
							p.getWorld().getBlockAt(loc1).setType(Material.SOUL_SAND);
						}
					}	
						
					if(p.getWorld().getBlockAt(loc2) != null) {
						if(p.getWorld().getBlockAt(loc2).getType() == Material.GRAVEL) {
							p.getWorld().getBlockAt(loc2).setType(Material.SOUL_SAND);
						}
					}
					
					if(p.getWorld().getBlockAt(loc3) != null) {
						if(p.getWorld().getBlockAt(loc3).getType() == Material.GRAVEL) {
							p.getWorld().getBlockAt(loc3).setType(Material.SOUL_SAND);
						}
					}
					
					if(p.getWorld().getBlockAt(loc4) != null) {
						if(p.getWorld().getBlockAt(loc4).getType() == Material.GRAVEL) {
							p.getWorld().getBlockAt(loc4).setType(Material.SOUL_SAND);
						}
					}
				//
					
				}
			}
		}
	}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.COAL));
		}
		
		if(e.getBlock().getType() == Material.MAGENTA_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.IRON_ORE));
		}
		
		if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_ORE));
		}
		
		if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.LAPIS_LAZULI));
		}
		
		if(e.getBlock().getType() == Material.LIME_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.REDSTONE));
		}
		
		if(e.getBlock().getType() == Material.PINK_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.DIAMOND));
		}
		
		if(e.getBlock().getType() == Material.GRAY_CONCRETE) {
			e.getBlock().setType(Material.AIR);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.EMERALD));
		}
	}
	
}
