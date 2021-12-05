package me.ninjay.upsoulth.captcha;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class EventosCaptcha implements Listener {
    private static boolean ativado;
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		
	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Clique no(a) Diamante")) {
			e.setCancelled(true);
			ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto");
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().isSimilar(dima)) {
					p.sendMessage("§a§lCAPTCHA §aconfirmado, tenha um bom jogo !");
					ativado = true;
					for (int d = 0; d < 5; d++) {
						p.getOpenInventory().close();

					}

				}
			}

		}
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto");
		ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto");
		if (e.getCurrentItem().isSimilar(bau)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
		if (e.getCurrentItem().isSimilar(abobora)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
		if (e.getCurrentItem().isSimilar(craft)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
	}
	@EventHandler
	public void aoClicarCRAFT(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("Clique no(a) Craft")) {
			e.setCancelled(true);
			ItemStack craft = Mine.newItem(Material.WORKBENCH, "§eClique no correto",1,0,"");
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().isSimilar(craft)) {
					p.sendMessage("§a§lCAPTCHA §aconfirmado, tenha um bom jogo !");
					ativado = false;
					for (int d = 0; d < 5; d++) {
						p.getOpenInventory().close();

					}

				}
			}

		}
		ItemStack bau = Mine.newItem(Material.CHEST, "§eClique no correto",1,0,"");
		ItemStack dima = Mine.newItem(Material.DIAMOND, "§eClique no correto",1,0,"");
		ItemStack abobora = Mine.newItem(Material.JACK_O_LANTERN, "§eClique no correto",1,0,"");
		if (e.getCurrentItem().isSimilar(bau)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
		if (e.getCurrentItem().isSimilar(abobora)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
		if (e.getCurrentItem().isSimilar(dima)) {
			p.kickPlayer("§b§lSoulthNetwork\n \n§cVocê foi kickado por: §eCONSOLE\n§cMotivo: §eVocê errou o captcha.");
			return;
		}
	}

	@EventHandler
	public void aoFechar(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		Inventory um = Mine.newInventory("Clique no(a) Diamante", 9 * 3);
		if(e.getInventory().getTitle().equals("Clique no(a) Diamante")) {
			if(ativado == false) {
			EstruturaGlobal.abrirapido(p, um);
		}
		}
		Inventory dois = Mine.newInventory("Clique no(a) Craft", 9 * 3);
		if(e.getInventory().getTitle().equals("Clique no(a) Craft")) {
			if(ativado == true) {
			EstruturaGlobal.abrir2rapido(p, dois);
		}
		}
	}
}
