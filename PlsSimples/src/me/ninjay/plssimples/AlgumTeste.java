package me.ninjay.plssimples;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;


public class AlgumTeste implements Listener{
	
	@EventHandler
	public void bloco(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(p.isSneaking()) {
			p.chat("/vender");
		
	
	}
	}
}
