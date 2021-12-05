package me.ninjay.soulthmina.mina;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthmina.main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventosMina implements Listener {

	@EventHandler
	public void aoClicarNoPublica(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack publica = Mine.newItem(Material.STONE_PICKAXE, "§9§lMina Ranks", 1, 0, "§fLiberada para §bTODOS"," ", "§fClique para ir.");
	

		if (e.getInventory().getTitle().equals("Escolha uma mina para ir")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(publica)) {
				if (Main.locais.contains("minapublica")) {
					p.sendMessage("§eVocê foi teleportado com sucesso.");
					p.getOpenInventory().close();
					p.teleport(Main.locais.getLocation("minapublica"));
					return;
				} else {
					p.sendMessage("§eEssa mina não foi setada ainda.");
				}
			}
		}
	}

	@EventHandler
	public void aoClicarNoPvP(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack pvp = Mine.newItem(Material.STONE_SWORD, "§c§lMina PvP", 1, 0, "§fLiberada para §bTODOS"," ", "§fClique para ir.");
		if (e.getInventory().getTitle().equals("Escolha uma mina para ir")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(pvp)) {
				if (Main.locais.contains("minapvp")) {
					p.sendMessage("§eVocê foi teleportado com sucesso.");
					p.getOpenInventory().close();
					p.teleport(Main.locais.getLocation("minapvp"));
					return;
				}else {
					p.sendMessage("§eEssa mina não foi setada ainda.");
				}

			}
		}
	}
	@EventHandler
	public void aoClicarNaVip(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack vip = Mine.newItem(Material.DIAMOND_PICKAXE, "§a§lMina Vip", 1, 0, "§fLiberada para §bVIPS"," ", "§fClique para ir.");
		if (e.getInventory().getTitle().equals("Escolha uma mina para ir")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(vip)) {
				if (Main.locais.contains("minavip")) {
					p.sendMessage("§eVocê foi teleportado com sucesso.");
					p.getOpenInventory().close();
					p.teleport(Main.locais.getLocation("minavip"));
					return;
				}else {
					p.sendMessage("§eEssa mina não foi setada ainda.");
				}

			}
		}
	}
}