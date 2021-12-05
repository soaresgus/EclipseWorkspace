package me.ninjay.curso.outros;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ninjay.curso.caixa.Caixa;
import me.ninjay.curso.caixa.CaixaAPI;

public class EventoJoin implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		Caixa basica = CaixaAPI.manager.getcaixa("basica");
		p.getInventory().addItem(basica.getIcone());
		
		
	}


@EventHandler
public void inventario(InventoryClickEvent e) {
	if(e.getInventory().getTitle().equals("Caixa Básica")) {
		e.setCancelled(true);
	}
}
}
