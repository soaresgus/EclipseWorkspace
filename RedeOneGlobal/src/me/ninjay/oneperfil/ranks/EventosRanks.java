package me.ninjay.oneperfil.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventosRanks implements Listener{
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().equals("Ranks")) {
			e.setCancelled(true);
		}
	}
}