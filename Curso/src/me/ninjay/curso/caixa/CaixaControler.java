package me.ninjay.curso.caixa;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.Mine;



public class CaixaControler implements Listener{
	
	@EventHandler
	public void aoInteragir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		for(Caixa caixa : CaixaAPI.manager.getCaixas()) {
			if(caixa.getIcone().isSimilar(p.getItemInHand())) {
				e.setCancelled(true);
				CaixaAPI.manager.abrir(p, caixa);
				ItemStack cbasica = Mine.newItem(Material.CHEST, "§eCaixa Básica", 1);
				p.getInventory().removeItem(cbasica);
			}
		}
	}

	
	
}
