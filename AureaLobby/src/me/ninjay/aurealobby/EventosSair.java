package me.ninjay.aurealobby;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventosSair implements Listener{
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		
		
		e.setQuitMessage(null);
	}

}
