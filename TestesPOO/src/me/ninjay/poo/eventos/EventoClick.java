package me.ninjay.poo.eventos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class EventoClick implements Listener {
	public static void abrir(Player p, int i) {
		ArrayList<ItemStack> itens = new ArrayList<>();
		itens.add(Mine.newItem(Material.BONE, "Opa"));
		itens.add(Mine.newItem(Material.BONE, "Opa2"));
		itens.add(Mine.newItem(Material.BONE, "Opa3"));
		itens.add(Mine.newItem(Material.BONE, "Opa4"));
		
		opa.put(p, i);
		Mine.openGui(p, itens, 2, 2, "§7Itens do tipo", 3, 10, 0, 8);

	}

	public static HashMap<Player, Integer> opa = new HashMap<>();

	@EventHandler
	public void clicar2(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if (event.getInventory().getName().startsWith("§7Itens do tipo")) {
			event.setCancelled(true);
			if (event.getRawSlot() == 0) {
				Integer pagina = opa.get(player);
				if (pagina == 1) {
					return;
				}
				abrir(player, pagina - 1);
				return;
			}
			if (event.getRawSlot() == 8) {
				Integer pagina = opa.get(player);
				abrir(player, pagina + 1);
				return;
			}
		}
	}
}