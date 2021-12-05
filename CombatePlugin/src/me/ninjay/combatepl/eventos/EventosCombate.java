package me.ninjay.combatepl.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.combatepl.main.Main;
import me.ninjay.combatepl.utils.Mine;

public class EventosCombate implements Listener {

	public static ArrayList<Player> combate = new ArrayList<>();
	public static int b = 0;

	@EventHandler
	public void aoHitar(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getDamager();
		Player d = (Player) e.getEntity();

		if (p instanceof Player) {
			if (d instanceof Player) {
				if (b == 0) {
					combate.add(d);
					combate.add(p);
					Mine.sendActionBar(d, "§cVocê entrou em combate.");
					d.sendMessage("§cVocê entrou em combate.");
					Mine.sendActionBar(p, "§cVocê entrou em combate.");
					p.sendMessage("§cVocê entrou em combate.");
					b++;
				} else {
					return;
				}
				new BukkitRunnable() {
					Integer i = Main.config.getInt("TempoDeCombate");

					@Override
					public void run() {
						i--;
						if (i == 0) {
							cancel();
							b--;
							if (b == 0) {
								combate.remove(d);
								combate.remove(p);
								Mine.sendActionBar(d, "§aVocê saiu de combate.");
								d.sendMessage("§aVocê saiu de combate.");
								Mine.sendActionBar(p, "§aVocê saiu de combate.");
								p.sendMessage("§aVocê saiu de combate.");
							} else {
								return;
							}
						}
					}
				}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
			}
		}
	}

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();

		if (combate.contains(p)) {
			if (e.getMessage().contains("tell")) {
				e.setCancelled(false);
			} else if (combate.contains(p)) {
				e.setCancelled(true);
				p.sendMessage("§cNão é possível usar comandos em combate.");
			}
		}
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(combate.contains(p)) {
			p.setHealth(0);
			Mine.sendAll(p, "§c"+p.getName()+" saiu em combate.");
		}
	}

}
