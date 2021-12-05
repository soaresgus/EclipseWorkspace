package me.ninjay.geleialuneta.eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onLuneta(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
	if(p.getInventory().getItemInMainHand() != null) {
		if(p.getInventory().getItemInMainHand().getType() == Material.SPYGLASS) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR) {
				Block bloco = p.getTargetBlock(null, 5000);
				Location loc = new Location(p.getWorld(), bloco.getX(), bloco.getY(), bloco.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
				p.getInventory().addItem(new ItemStack(p.getWorld().getBlockAt(loc).getType()));
				p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
			}
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock() != null) {
					p.getInventory().addItem(new ItemStack(e.getClickedBlock().getType()));
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 1F);
				}
			}
		}
	}
	}

}
