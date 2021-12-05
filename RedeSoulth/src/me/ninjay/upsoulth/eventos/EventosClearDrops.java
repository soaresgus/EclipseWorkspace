package me.ninjay.upsoulth.eventos;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.upsoulth.main.Main;

public class EventosClearDrops implements Listener {

	@EventHandler
	public void aoDropar(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		Item d = e.getItemDrop();
		if (p.hasPermission("drops.clear")) {
			p.sendMessage("§e§l[Soulth Drops] §eVocê dropou um item, e o mesmo será excluido em 3 minutos !");
			new BukkitRunnable() {
				int contagem = 180;

				@Override
				public void run() {
					contagem--;
					if (contagem == 0) {
						d.remove();
						
					}
				}
			}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 20, 20);

		}

	}
}
