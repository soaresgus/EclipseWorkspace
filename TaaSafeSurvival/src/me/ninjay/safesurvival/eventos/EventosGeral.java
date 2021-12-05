package me.ninjay.safesurvival.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		e.setJoinMessage("§a"+p.getName()+" §aentrou no servidor.");
		p.sendTitle("§6§lSurvival", "§fFique em casa e jogue survival", 5, 100, 5);
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage("§c"+p.getName()+" §csaiu do servidor.");
	}

}
