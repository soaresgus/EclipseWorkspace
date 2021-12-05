package me.ninjay.salvavidas.eventos;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.ninjay.salvavidas.comandos.ComandoGive;


public class EventosGeral implements Listener {

	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
		if(((HumanEntity) e.getEntity()).getInventory().getHelmet() != null) {
			if (((HumanEntity) e.getEntity()).getInventory().getHelmet().getItemMeta().getDisplayName().contains("§cSalva-vida")) {
				if (e.getCause() == DamageCause.ENTITY_EXPLOSION || e.getCause() == DamageCause.BLOCK_EXPLOSION) {
					e.setCancelled(true);
				}
			}else {
				return;
			}
			}
			}
		}
	
	@EventHandler
	public void aoBatar(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getEntity();
		if(e.getDamager() instanceof Player) {
			if(e.getEntity() instanceof Player) {
				if(p.getInventory().getHelmet() != null) {
				if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f(§a5§f) §cSalva-vida")) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 10);
					p.getInventory().setHelmet(ComandoGive.salvavidas4);
					return;
				}
				}
				if(p.getInventory().getHelmet() != null) {
				if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f(§a4§f) §cSalva-vida")) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 10);
					p.getInventory().setHelmet(ComandoGive.salvavidas3);
					return;
				}
				}
				if(p.getInventory().getHelmet() != null) {
				if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f(§a3§f) §cSalva-vida")) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 10);
					p.getInventory().setHelmet(ComandoGive.salvavidas2);
					return;
				}
				}
				if(p.getInventory().getHelmet() != null) {
				if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f(§a2§f) §cSalva-vida")) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 10);
					p.getInventory().setHelmet(ComandoGive.salvavidas1);
					return;
				}
				}
				if(p.getInventory().getHelmet() != null) {
				if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f(§a1§f) §cSalva-vida")) {
					e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 10);
					p.getInventory().setHelmet(null);
					return;
				}
				}
			}
		}
	}
	
}
