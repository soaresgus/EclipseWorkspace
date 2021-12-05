package me.ninjay.aurealobby;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class EventosSopa implements Listener {

	@EventHandler
	public void sopa(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		ItemStack sopa = Mine.newItem(Material.MUSHROOM_SOUP, "§eSopa");
		if (!p.getItemInHand().isSimilar(sopa)) {
			return;
		}
		if (p.getItemInHand().isSimilar(sopa) && a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
			if (20-p.getHealth() < 3.5) {
				p.setHealth(p.getHealth() + 3.5);
				p.getItemInHand().setType(Material.BOWL);
				return;

			}
			
			if (p.getItemInHand().isSimilar(sopa) && a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
				if (20-p.getHealth() > 3.5) {
					p.setHealth(p.getHealth() + 3.5);
					p.getItemInHand().setType(Material.BOWL);
					return;

				}

			}
		}
	
	if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP && a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
		if (20-p.getHealth() < 3.5) {
			p.setHealth(p.getHealth() + 3.5);
			p.getItemInHand().setType(Material.BOWL);
			return;

		}
		
		if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP && a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
			if (20-p.getHealth() > 3.5) {
				p.setHealth(p.getHealth() + 3.5);
				p.getItemInHand().setType(Material.BOWL);
				return;

			}

		}
	}
}
}
