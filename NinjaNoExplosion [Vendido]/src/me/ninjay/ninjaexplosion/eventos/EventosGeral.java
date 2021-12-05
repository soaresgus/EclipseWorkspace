package me.ninjay.ninjaexplosion.eventos;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class EventosGeral implements Listener{
	@EventHandler
	public void aoNascer(ExplosionPrimeEvent e) {
		if(e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
		}else {
			return;
		}
	}

}
