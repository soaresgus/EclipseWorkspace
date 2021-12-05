package me.ninjay.safeclub.comandos.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.ninjay.safeclub.estruturas.api.cash.CashAPI;
import me.ninjay.safeclub.estruturas.api.kit.KitAPI;
import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.VaultAPI;

public class EventosKit implements Listener {

	@EventHandler
	public static void aoClicarGui(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(KitAPI.p4)) {
				KitAPI.openP4(p);
				return;
			}
			if (e.getCurrentItem().isSimilar(KitAPI.caixas)) {
				KitAPI.openCaixa(p);
				return;
			}
			if (e.getCurrentItem().isSimilar(KitAPI.vip)) {
				if (VaultAPI.getPermission().playerInGroup(p, "vipninja")) {
					KitAPI.openVip(p);
					return;
				}
			}
		}
		if (e.getCurrentItem().isSimilar(KitAPI.vip)) {
			if (VaultAPI.getPermission().playerInGroup(p, "vipsafe")) {
				KitAPI.openVip(p);
				return;
			}
		}
	}

	@EventHandler
	public static void aoClicarP4(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Sets")) {
			e.setCancelled(true);
			if (e.getClickedInventory().getTitle().equals("Sets")) {
				p.getInventory().addItem(e.getCurrentItem());
			}
		}

	}

	@EventHandler
	public static void aoClicarVip(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Kits Vip")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(KitAPI.ninja)) {
				if (VaultAPI.getPermission().playerInGroup(p, "vipninja")) {
					KitAPI.coletarNinja(p, Main.config);
					return;
				}
			}
			if (e.getCurrentItem().isSimilar(KitAPI.safe)) {
				if (VaultAPI.getPermission().playerInGroup(p, "vipsafe")) {
					KitAPI.coletarSafe(p, Main.config);
					return;
				}
			}
		}
	}

	@EventHandler
	public static void aoClicarCaixa(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equals("Caixas")) {
			e.setCancelled(true);
			if (e.getCurrentItem().isSimilar(KitAPI.tres)) {
				if (CashAPI.has(p, Main.cash, 1)) {
					p.getInventory().addItem(KitAPI.tres);
					CashAPI.remove(p, Main.cash, 1);
					return;

				}
			}
		}
		if(e.getInventory().getTitle().equals("Caixas")) {
			if(e.getCurrentItem().isSimilar(KitAPI.quatro)) {
				if(CashAPI.has(p, Main.cash, 1)) {
					p.getInventory().addItem(KitAPI.quatro);
					CashAPI.remove(p, Main.cash, 1);
					return;
				}
 			}
		}
	}
	
}
