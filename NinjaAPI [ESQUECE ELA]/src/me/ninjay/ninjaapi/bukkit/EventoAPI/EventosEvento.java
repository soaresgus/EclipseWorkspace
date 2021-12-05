package me.ninjay.ninjaapi.bukkit.EventoAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventosEvento implements Listener{
	
	@EventHandler
	public static void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		if(e.getEntity() instanceof Player) {
			EventoManager.morrer(p);
		}
	}

}
