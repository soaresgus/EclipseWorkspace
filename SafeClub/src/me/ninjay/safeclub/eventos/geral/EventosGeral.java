package me.ninjay.safeclub.eventos.geral;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.safeclub.estruturas.api.recompensa.RecompensaAPI;
import me.ninjay.safeclub.estruturas.score.SimplesScore;
import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.Mine;


public class EventosGeral implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		Mine.sendTitle(p, "§6§lSafe Club", "§f>> P4 Free <<", 20, 100, 20);
		RecompensaAPI.avisar(p, Main.cooldowns);
	    SimplesScore.setScore(p);
		}
	@EventHandler
	public void aoChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		e.setCancelled(true);
		p.sendMessage("§cUtilize '/g' para falar no chat");
		}
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("Recompensa Diaria")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(RecompensaAPI.caixa)) {
				RecompensaAPI.coletar(p, Main.cooldowns);
			}else {
				return;
			}
		}
	}
	
	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void aoColocar(BlockPlaceEvent e) {
		e.setCancelled(true);
	}

}
