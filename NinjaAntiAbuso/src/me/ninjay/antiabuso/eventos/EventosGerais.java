package me.ninjay.antiabuso.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.antiabuso.comandos.ComandoModReq;
import me.ninjay.antiabuso.comandos.ComandoTeleportar;


public class EventosGerais implements Listener{
	
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("/tp")) {
			e.setCancelled(true);
			p.sendMessage("Comando bloqueado. Utilize /teleportar.");
		}
		if(ComandoTeleportar.espectando.contains(p)) {
			if(!e.getMessage().equalsIgnoreCase("/teleportar")) {
			e.setCancelled(true);
			p.sendMessage("§cApenas comandos de teleporte e punição são liberados durante o espectador");
			}
		}
	}
	
	@EventHandler
	public void aoEntar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ComandoModReq.dado.put(p.getName(), 0);
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		if(ComandoTeleportar.espectando.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		if(ComandoTeleportar.espectando.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	
}
