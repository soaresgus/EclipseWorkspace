package me.ninjay.caixas;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.Mine;


public class CaixaControler implements Listener{
	
	@EventHandler
	public void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		e.setCancelled(true);
		for(Caixa caixa : CaixaAPI.manager.getCaixas()) {
			if(caixa.getIcone().isSimilar(p.getItemInHand())) {
				CaixaAPI.manager.abrir(p, caixa);
				ItemStack cbasica = Mine.newItem(Material.CHEST, "§eCaixa Básica", 1);
				p.getInventory().removeItem(cbasica);
			}
		}
	}
@EventHandler
public void aoClicar(InventoryClickEvent e) {
if(e.getInventory().getTitle().equals("Caixa Básica")) {
	e.setCancelled(true);
}
	
}
	
	
}
