package me.ninjay.kust2fa.eventos;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.ninjay.kust2fa.main.Main;

public class EventosGeral implements Listener{
	
	public static HashMap<Player, Boolean> auth = new HashMap<>();
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	if(p.hasPermission("pin.staff")) {
		auth.put(p, false);
		if(auth.get(p) == null || auth.get(p) == false) {
			new BukkitRunnable() {
				int i = 60;
				@Override
				public void run() {
					i--;
					if(i == 59) {
					if(auth.get(p) == false) {
						p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
					}
					}
					if(i == 40) {
						if(auth.get(p) == false) {
							p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
						}
					}
					if(i == 30) {
						if(auth.get(p) == false) {
							p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
						}
					}
					if(i == 20) {
						if(auth.get(p) == false) {
							p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
						}
					}
					if(i == 10) {
						if(auth.get(p) == false) {
							p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
						}
					}
					if(i == 1) {
						if(auth.get(p) == false) {
							p.sendMessage(" \n§cPara se autentificar digite seu pin! /pin [chave]\n ");
						}
					}
					if(i <= 0) {
						cancel();
						if(auth.get(p) == false) {
							p.kickPlayer("       §cVocê demorou muito para se autentificar!      ");
						}
					}
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		}
	}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(auth.get(p) == false) {
			if(p.hasPermission("pin.staff")) {
			e.setCancelled(true);
			}
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(auth.get(p) == false) {
			if(p.hasPermission("pin.staff")) {
				e.setCancelled(true);
			}
		}else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(auth.get(p) == false) {
			if(p.hasPermission("pin.staff")) {
				if(!e.getMessage().contains("/pin")) {
					e.setCancelled(true);
				}
			}
		}else {
			e.setCancelled(false);
		}
	}

}
