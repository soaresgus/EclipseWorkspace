package me.ninjay.almas.maquinas;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class MaquinaControler implements Listener{
	
	@EventHandler
	public void abrir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		for( Maquina maquina: MaquinaAPI.manager.getMaquinas()) {
			if(maquina.getIcone().isSimilar(p.getItemInHand())) {
				e.setCancelled(true);
				MaquinaAPI.manager.abrir(p, maquina);
			
			}
		}
	}
@EventHandler
public void ClicarNoAdicionar(InventoryClickEvent e) {

	Player p = (Player) e.getWhoClicked();
	
	if(e.getInventory().getTitle().equals("Máquina")) {
		e.setCancelled(true);
		   ItemStack adicionar = Mine.newItem(Material.EMERALD, "§eAdicionar Combustível");
		if(e.getCurrentItem().isSimilar(adicionar)) {
			Inventory menu = Mine.newInventory("Adicionar Combustível", 9*3);
			p.openInventory(menu);
		}
	}
}

@EventHandler
public void InventarioDoAdicionar(InventoryClickEvent e) {
	
}
}

