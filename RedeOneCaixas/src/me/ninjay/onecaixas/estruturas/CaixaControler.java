package me.ninjay.onecaixas.estruturas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class CaixaControler implements Listener {

	@EventHandler
	public void aoAbrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		for (Caixa caixa : CaixaAPI.manager.getCaixas()) {
			if (caixa.getIcone().isSimilar(p.getItemInHand())) {
				e.setCancelled(true);
				CaixaAPI.manager.abrir(p, caixa);
				p.getInventory().removeItem(caixa.getIcone());
			}
		}
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if(e.getInventory().getTitle().equals("Abrindo...")) {
			e.setCancelled(true);
		}
	}
	
}