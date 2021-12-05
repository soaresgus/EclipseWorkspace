package me.ninjay.oneperfil.comandos;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventosPerfilDnv implements Listener{
	
	@EventHandler
	public static void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().startsWith("Perfil")) {
			e.setCancelled(true);
		}
	}

}
