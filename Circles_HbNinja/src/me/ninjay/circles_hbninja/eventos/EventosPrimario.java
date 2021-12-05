package me.ninjay.circles_hbninja.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.circles_hbninja.main.Main;
import me.ninjay.circles_hbninja.utils.Mine;

public class EventosPrimario implements Listener {

	private static HashMap<Player, Player> ninja_hit = new HashMap<>();
	private static ArrayList<Player> ninja_cooldown = new ArrayList<>();

	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();

		if (e.isSneaking() == false) {
			if (!ninja_cooldown.contains(p)) {
				if (ninja_hit.get(p) != null) {
					ninja_cooldown.add(p);

					Player j = ninja_hit.get(p);

					if (Mine.getPlayerAtRange(p.getLocation(), 20.0).contains(j)) {
						p.teleport(j.getLocation());
						p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1F, 1F);
					} else {
						ninja_hit.put(p, null);
						ninja_cooldown.remove(p);
					}

					if (ninja_cooldown.contains(p)) {
						new BukkitRunnable() {
							int i = 20;

							@Override
							public void run() {
								i--;
								Mine.sendActionBar(p, "§8Cooldown: §7" + i + " segundos!");
								if (i <= 0) {
									cancel();
									ninja_cooldown.remove(p);
									p.sendMessage("§aVocê pode utilizar a habilidade novamente!");
									p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
								}
							}
						}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20L, 20L);
					}
				}

			} else {
				p.sendMessage("§cAguarde para usar novamente!");
			}

		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {

		if (e.getEntity() != null) {
			if (e.getDamager() != null) {
				if (e.getDamager() instanceof Player) {
					if (e.getEntity() instanceof Player) {
						Player p = (Player) e.getDamager();
						Player j = (Player) e.getEntity();

						if (ninja_hit.get(p) == null) {
							if (ninja_hit.get(p) != j) {
								ninja_hit.put(p, j);
								new BukkitRunnable() {
									int i = 5;

									@Override
									public void run() {
										i--;
										if (i <= 0) {
											cancel();
											ninja_hit.put(p, null);
											p.sendMessage("§cHabilidade expirada!");
											p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 1F, 1F);
										}
									}
								}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20L, 20L);
							}
						}
					}
				}
			}
		}

	}

}
