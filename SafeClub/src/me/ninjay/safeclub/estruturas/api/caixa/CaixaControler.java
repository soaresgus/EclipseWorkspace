package me.ninjay.safeclub.estruturas.api.caixa;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CaixaControler implements Listener{
	
	@EventHandler
	public static void aoClicar(InventoryClickEvent  e) {
		if(e.getInventory().getTitle().equals("Caixa Misteriosa")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void aoAbrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		for(Caixa caixa : CaixaAPI.manager.getCaixas()) {
			if(caixa.getIcone().isSimilar(p.getItemInHand())) {
				CaixaAPI.manager.abrir(p, caixa);
				caixa.getIcone().setAmount(1);
				p.getInventory().removeItem(caixa.getIcone());
				e.setCancelled(true);
			}
			
		}
	}

}
