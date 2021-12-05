package me.ninjay.safemensagens.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventosTemplate implements Listener{
	
	@EventHandler
	public void Template(PlayerInteractEvent e) {
		Player p = e.getPlayer();
	}

}
