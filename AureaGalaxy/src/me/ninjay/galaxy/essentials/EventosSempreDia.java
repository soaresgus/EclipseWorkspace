package me.ninjay.galaxy.essentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventosSempreDia implements Listener{
	
	@EventHandler
	public void SempreDia(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		p.getWorld().setTime(1000);
		return;
	}

}
