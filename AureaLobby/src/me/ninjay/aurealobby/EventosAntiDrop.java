package me.ninjay.aurealobby;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


public class EventosAntiDrop implements Listener{
	
	@EventHandler
	public void invblock(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("anti.drop")) {
		e.setCancelled(true);
		if(!p.hasPermission("anti.drop")) {
			e.setCancelled(false);
		}
		}	
	}

}
