package me.ninjay.safestaff.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.safecore.main.Main;

public class ComandoV implements CommandExecutor, Listener {

	private static ArrayList<Player> stats = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;


			if (p.hasPermission("vanish.admin")) {
				if (!stats.contains(p)) {
					p.sendMessage("§aModo vanish ativado!");
					p.setAllowFlight(true);
					p.setFlying(true);
					
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}
					
					new BukkitRunnable() {

						@Override
						public void run() {
							stats.add(p);
						}
					}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
				}
				if (stats.contains(p)) {
					p.sendMessage("§cModo vanish desativado!");
					p.setAllowFlight(true);
					p.setFlying(false);
					
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
					}
					
					new BukkitRunnable() {

						@Override
						public void run() {
							stats.remove(p);
						}
					}.runTaskLaterAsynchronously(Main.getPlugin(Main.class), 5);
				}
			} else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}
	
	@EventHandler
	public void aoDano(EntityDamageByEntityEvent e) {
		if(stats.contains(e.getDamager())) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void aoInteragir(PlayerInteractEvent e) {
		if(stats.contains(e.getPlayer())) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}

}
