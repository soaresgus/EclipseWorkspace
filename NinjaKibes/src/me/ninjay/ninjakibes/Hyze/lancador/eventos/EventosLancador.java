package me.ninjay.ninjakibes.Hyze.lancador.eventos;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.ninjay.ninjakibes.estruturas.ItemAPI;
import me.ninjay.ninjakibes.utils.Mine;

public class EventosLancador implements Listener{
	
	public static ArrayList<Player> dano = new ArrayList<>();
	
	@EventHandler
	public static void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(p.getItemInHand().isSimilar(ItemAPI.lanca)) {
			if(!dano.contains(p)) {
			dano.add(p);
			e.setCancelled(true);
			p.setVelocity(new Vector(p.getVelocity().getX(), 60, p.getVelocity().getZ()));
		    Mine.remove(p.getInventory(), p.getItemInHand(), 1);
		}else {
			e.setCancelled(true);
			p.setVelocity(new Vector(p.getVelocity().getX(), 60, p.getVelocity().getZ()));
		    Mine.remove(p.getInventory(), p.getItemInHand(), 1);
		}
		}
	}
}
	@EventHandler
	public static void aoDano(EntityDamageEvent e) {
		if(e.getEntityType() == EntityType.PLAYER) {
		if(e.getCause() == DamageCause.FALL) {
			if(dano.contains(e.getEntity())) {
				dano.remove(e.getEntity());
				e.setCancelled(true);
				
			}
		}
		}
	}

}
