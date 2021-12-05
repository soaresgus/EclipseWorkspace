package me.ninjay.ninjahomes.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.ninjahomes.estruturas.HomesAPI;
import me.ninjay.ninjahomes.main.Main;

public class EventosFirstJoin implements Listener{
	
	@EventHandler
	public static void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!Main.homeconf.contains(p.getName())) {
			HomesAPI.setarFirstHome(p);
		}else {
			return;
		}
		
	}

}
