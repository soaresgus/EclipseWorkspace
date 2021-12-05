package me.ninjay.curso.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventosScore implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		SimplesScore.setScore(p);
		return;
	}

}
