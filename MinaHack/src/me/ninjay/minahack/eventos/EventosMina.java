package me.ninjay.minahack.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventosMina implements Listener{
	
	@EventHandler
	public void Template(PlayerInteractEvent e) {
		Player p = e.getPlayer();
	}

}
