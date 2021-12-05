package me.ninjay.kustespeciais.eventos;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustespeciais.utils.Mine;

public class EventosGeral implements Listener {

	private static HashMap<Integer, ItemStack> save = new HashMap<>();
	
	@EventHandler
	public void removeSkills(InventoryOpenEvent e) {
		if(e.getInventory().getTitle().contains("Habilidades")) {
			e.getInventory().setItem(Mine.getPosition(4, 4), Mine.newItem(Material.AIR, null));
			e.getInventory().setItem(Mine.getPosition(4, 6), Mine.newItem(Material.AIR, null));
		}
		if(e.getInventory().getTitle().contains("Escolha a habilidade:")) {
		if(e.getInventory().getItem(Mine.getPosition(2, 4)) != null && e.getInventory().getItem(Mine.getPosition(2, 6)) != null) {
			ItemStack mining = e.getInventory().getItem(Mine.getPosition(2, 4));
			ItemStack pa = e.getInventory().getItem(Mine.getPosition(2, 6));
			
			save.put(Mine.getPosition(2, 4), mining);
			save.put(Mine.getPosition(2, 6), pa);
		}
			ItemStack ar = Mine.newItem(Material.AIR, null);
			e.getInventory().setItem(Mine.getPosition(2, 5), save.get(Mine.getPosition(2, 4)));
			e.getInventory().setItem(Mine.getPosition(2, 4), ar);
			e.getInventory().setItem(Mine.getPosition(2, 7), ar);
			e.getInventory().setItem(Mine.getPosition(2, 7), save.get(Mine.getPosition(2, 6)));
			e.getInventory().setItem(Mine.getPosition(2, 6), ar);
			
		}
	}
}
