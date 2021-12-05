package me.ninjay.kustproteger.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.ninjay.kustproteger.main.Main;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(e.getMessage().equalsIgnoreCase("/f proteger")) {
			if(Main.config.getBoolean("ativado") == false) {
				e.setCancelled(true);
				p.sendMessage(Main.config.getString("msg-off").replace("&", "§"));
			}else {
				e.setCancelled(false);
			}
		}
	}
	

}
