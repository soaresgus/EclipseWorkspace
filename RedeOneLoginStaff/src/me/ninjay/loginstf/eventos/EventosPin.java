package me.ninjay.loginstf.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.loginstf.comandos.ComandoPin;
import me.ninjay.loginstf.main.Main;

public class EventosPin implements Listener {

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("login.admin")) {
			ComandoPin.lista.add(p);
			new BukkitRunnable() {

				@Override
				public void run() {
					p.sendMessage("§cBem vindo staffer, utilize /pin <código>.");
				}
			}.runTaskLater(Main.getPlugin(Main.class), 2);
		}else {
			return;
		}

		if (p.hasPermission("login.mod")) {
			ComandoPin.lista.add(p);
			new BukkitRunnable() {

				@Override
				public void run() {
					p.sendMessage("§cBem vindo staffer, utilize /pin <código>.");
				}
				
			}.runTaskLater(Main.getPlugin(Main.class), 8);
		}else {
			return;
		}
	}

	@EventHandler
	public void aoFalar(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ComandoPin.lista.contains(p)) {
			e.setCancelled(true);
			p.sendMessage("§cInsira seu pin para poder falar no chat.");
		} else {
			return;
		}
	}

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (ComandoPin.lista.contains(p)) {
			if (e.getMessage().contains("/pin")) {
				e.setCancelled(false);
			}else {
				e.setCancelled(true);
				p.sendMessage("§cInsira seu pin para poder usar comandos.");
			}
		}
	}
	@EventHandler
	public void aoAndar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(ComandoPin.lista.contains(p)) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}

}
