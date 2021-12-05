package me.ninjay.ninjakitpvp.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjay.ninjakitpvp.estruturas.ItemAPI;
import me.ninjay.ninjakitpvp.main.Main;

public class EventosWarps implements Listener{
	
	@EventHandler
	public static void aoAbrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() != Material.AIR) {
			if(p.getItemInHand().isSimilar(ItemAPI.warps)) {
				p.chat("/warps");
			}
		}
	}
	
	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("warps")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(ItemAPI.wlava)) {
				if(Main.locations.contains("lava")) {
					p.sendMessage("§aTeleportado");
					p.teleport(Main.locations.getLocation("lava"));
				}else {
					p.sendMessage("§cWarp não foi setada.");
				}
			}
			if(e.getCurrentItem().isSimilar(ItemAPI.w1v1)) {
				if(Main.locations.contains("1v1")) {
					p.sendMessage("§aTeleportado");
					p.teleport(Main.locations.getLocation("1v1"));
				}else {
					p.sendMessage("§cWarp não foi setada.");
				}
			}
			if(e.getCurrentItem().isSimilar(ItemAPI.wfps)) {
				if(Main.locations.contains("fps")) {
					p.sendMessage("§aTeleportado");
					p.teleport(Main.locations.getLocation("fps"));
				}else {
					p.sendMessage("§cWarp não foi setada.");
				}
			}
			if(e.getCurrentItem().isSimilar(ItemAPI.wsumo)) {
				if(Main.locations.contains("sumo")) {
					p.sendMessage("§aTeleportado");
					p.teleport(Main.locations.getLocation("sumo"));
				}else {
					p.sendMessage("§cWarp não foi setada.");
				}
			}
		}
		
	}
}
