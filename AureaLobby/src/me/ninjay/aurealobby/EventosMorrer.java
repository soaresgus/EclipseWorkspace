package me.ninjay.aurealobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventosMorrer implements Listener{
	
	@EventHandler
	public void Falecer(PlayerDeathEvent e) {
		 Player p = e.getEntity();
		 p.teleport(Main.config.getLocation("spawn"));
		 e.setDeathMessage(p.getName()+" §7morreu :(");
			p.setFoodLevel(999999999);
			Main.permission.playerAdd(p, "anti.drop");
	}

}
