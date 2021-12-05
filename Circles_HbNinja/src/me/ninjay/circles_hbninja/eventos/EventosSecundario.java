package me.ninjay.circles_hbninja.eventos;

import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.circles_hbninja.main.Main;

public class EventosSecundario implements Listener{
	
	private static HashMap<Player, Integer> hits = new HashMap<>();
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() != null) {
			if(e.getDamager() != null) {
				if(e.getEntity() instanceof Player) {
					if(e.getDamager() instanceof Player) {
						Player p = (Player) e.getDamager();
						Player j = (Player) e.getEntity();
						
						if(hits.get(p) != null && hits.get(p) < 3) {
							hits.put(p, hits.get(p)+1);
						}else if(hits.get(p) == null) {
							hits.put(p, 1);
						}
						
						if(hits.get(p) != null && hits.get(p) >= 3) {
							hits.remove(p);
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
							if(!p.hasPotionEffect(PotionEffectType.SPEED)) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2*20, 2));
							}else {
							for(PotionEffect pot : p.getActivePotionEffects()) {
								if(pot.getType().equals(PotionEffectType.SPEED)) {
									if(pot.getAmplifier() < 2) {
										HashMap<Player, PotionEffect> data = new HashMap<>();
										
										data.put(p, pot);
										p.removePotionEffect(PotionEffectType.SPEED);
										p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2*20, 2));
										
										new BukkitRunnable() {
											
											@Override
											public void run() {
												p.addPotionEffect(pot);
											}
										}.runTaskLater(Main.getPlugin(Main.class), 2*20);
									}
								}
							}
						}
					}
						if(hits.containsKey(j)) {
							hits.remove(j);
						}
					}
				}
			}
		}
	}

}
