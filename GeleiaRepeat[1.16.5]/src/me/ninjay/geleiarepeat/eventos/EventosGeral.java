package me.ninjay.geleiarepeat.eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onClick(PlayerBucketEmptyEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getLocation().getBlockX() > 0 && e.getBlock().getLocation().getBlockZ() > 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()*-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()*-1);
			if(e.getBucket() == Material.LAVA_BUCKET) {
				p.getWorld().getBlockAt(loc).setType(Material.LAVA);
			}
			if(e.getBucket() == Material.WATER_BUCKET) {
				p.getWorld().getBlockAt(loc).setType(Material.WATER);
			}
		}
		
		if(e.getBlock().getLocation().getBlockX() < 0 && e.getBlock().getLocation().getBlockZ() < 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()/-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()/-1);
			if(e.getBucket() == Material.LAVA_BUCKET) {
				p.getWorld().getBlockAt(loc).setType(Material.LAVA);
			}
			if(e.getBucket() == Material.WATER_BUCKET) {
				p.getWorld().getBlockAt(loc).setType(Material.WATER);
			}
		}
		
	}
	
	@EventHandler
	public void aoTntAtivar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getItemInMainHand().getType() == Material.FLINT_AND_STEEL) {
			if(e.getClickedBlock().getType() == Material.TNT) {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if(e.getClickedBlock().getLocation().getBlockX() > 0 && e.getClickedBlock().getLocation().getBlockZ() > 0 ) {
						Location loc = new Location(e.getClickedBlock().getWorld(), (e.getClickedBlock().getLocation().getBlockX()*-1)+0.5, e.getClickedBlock().getLocation().getBlockY(), (e.getClickedBlock().getLocation().getBlockZ()*-1)+0.5);
						e.getClickedBlock().getWorld().getBlockAt(loc).setType(Material.AIR);
						e.getClickedBlock().getWorld().spawn(loc, TNTPrimed.class);
					}
					
					if(e.getClickedBlock().getLocation().getBlockX() < 0 && e.getClickedBlock().getLocation().getBlockZ() < 0 ) {
						Location loc = new Location(e.getClickedBlock().getWorld(), (e.getClickedBlock().getLocation().getBlockX()/-1)+0.5, e.getClickedBlock().getLocation().getBlockY(), (e.getClickedBlock().getLocation().getBlockZ()/-1)+0.5);
						e.getClickedBlock().getWorld().getBlockAt(loc).setType(Material.AIR);
						e.getClickedBlock().getWorld().spawn(loc, TNTPrimed.class);
					}
				}
			}
		}
	}
	
	
	//@EventHandler
//	public void aoExplodir(EntityExplodeEvent e) {
//		if(e.getEntity() != null) {
//			if(e.getEntity().getType() == EntityType.PRIMED_TNT) {
//				if(e.getEntity().getLocation().getBlockX() > 0 && e.getEntity().getLocation().getBlockZ() > 0 ) {
//					Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getBlockX()*-1, e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ()*-1);
//					e.getEntity().getWorld().createExplosion(loc, 5F);
//				}
//				
//				if(e.getEntity().getLocation().getBlockX() < 0 && e.getEntity().getLocation().getBlockZ() < 0 ) {
//					Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getBlockX()/-1, e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ()/-1);
//					e.getEntity().getWorld().createExplosion(loc, 5F);
//				}
//			}
//		}
//	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getLocation().getBlockX() > 0 && e.getBlock().getLocation().getBlockZ() > 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()*-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()*-1);
			p.getWorld().getBlockAt(loc).breakNaturally();
		}
		
		if(e.getBlock().getLocation().getBlockX() < 0 && e.getBlock().getLocation().getBlockZ() < 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()/-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()/-1);
			p.getWorld().getBlockAt(loc).breakNaturally();
		}
	}
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getLocation().getBlockX() > 0 && e.getBlock().getLocation().getBlockZ() > 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()*-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()*-1);
			p.getWorld().getBlockAt(loc).setType(e.getBlock().getType());
		}
		
		if(e.getBlock().getLocation().getBlockX() < 0 && e.getBlock().getLocation().getBlockZ() < 0 ) {
			Location loc = new Location(p.getWorld(), e.getBlock().getLocation().getBlockX()/-1, e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()/-1);
			p.getWorld().getBlockAt(loc).setType(e.getBlock().getType());
		}
	}

}
