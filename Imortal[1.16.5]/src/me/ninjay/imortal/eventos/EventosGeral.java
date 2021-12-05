package me.ninjay.imortal.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.imortal.comandos.ComandoImortal;
import me.ninjay.imortal.estruturas.ItensAPI;
import me.ninjay.imortal.main.Main;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
			if(e.getItem().getItemMeta() != null) {
				if(e.getItem().getItemMeta().getDisplayName().contains("Deuses")) {
				p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, (15*60)*20, 100));
				//p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (15*60)*20, 255));
				}
			}
			}
		}.runTaskLater(Main.getPlugin(Main.class), 1);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if(ComandoImortal.usando != null && ComandoImortal.usando.contains(p)) {
			e.setDamage(0.0);
			}
			
			if(ComandoImortal.usando != null && !ComandoImortal.usando.contains(p)) {
				e.setDamage(e.getDamage());
			}
		}
	}
}
