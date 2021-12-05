package me.ninjay.olhodedeus.eventos;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import me.ninjay.olhodedeus.comandos.ComandoDarOlho;
import me.ninjay.olhodedeus.main.Main;
import me.ninjay.olhodedeus.utils.Mine;

public class EventosOlho implements Listener {

	@EventHandler
	public void aoUsar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if(p.getItemInHand() != null) {
		if (p.getItemInHand().isSimilar(ComandoDarOlho.olho)) {
			p.getInventory().removeItem(ComandoDarOlho.olho);
			e.setCancelled(true);
			if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
				Mine.sendTitle(p, "§4Olho de Deus", "", 5, 30, 5);
				p.setGameMode(GameMode.SPECTATOR);
				p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				

			}
		}
		}
		new BukkitRunnable() {
			int i = 10;
			@Override
			public void run() {
				i--;
				if (i == 0) {
					cancel();
					p.sendMessage("§cSeu tempo de olho de deus acabou e por isto foi levado ao spawn!");
					p.teleport(p.getWorld().getSpawnLocation());
					p.setGameMode(GameMode.CREATIVE);
				}
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);

	}
}
