package me.ninjay.soulthmina.mina;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.soulthmina.main.Main;

public class EventosSetarMina implements Listener{
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack publica = Mine.newItem(Material.STONE_PICKAXE, "�9�lMina Ranks", 1, 0, "�fLiberada para �bTODOS"," ", "�fClique para setar.");
		ItemStack pvp = Mine.newItem(Material.STONE_SWORD, "�c�lMina PvP", 1, 0, "�fLiberada para �bTODOS"," ", "�fClique para setar.");
		ItemStack vip = Mine.newItem(Material.DIAMOND_PICKAXE, "�a�lMina Vip", 1, 0, "�fLiberada para �bVIPS"," ", "�fClique para setar.");
		
		if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(publica)) {
				p.sendMessage("�eMina P�blica setada com sucesso.");
				p.getOpenInventory().close();
				Main.locais.set("minapublica", p.getLocation());
				Main.locais.saveConfig();
				return;
			}
			if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
				e.setCancelled(true);
				if(e.getCurrentItem().isSimilar(pvp)) {
					p.sendMessage("�eMina PvP setada com sucesso.");
					p.getOpenInventory().close();
					Main.locais.set("minapvp", p.getLocation());
					Main.locais.saveConfig();
					return;
				}
				if(e.getInventory().getTitle().equals("Escolha uma mina para setar")) {
					e.setCancelled(true);
					if(e.getCurrentItem().isSimilar(vip )) {
						p.sendMessage("�eMina Vip setada com sucesso.");
						p.getOpenInventory().close();
						Main.locais.set("minavip", p.getLocation());
						Main.locais.saveConfig();
						return;
					}
					
				}
				
			}
		}
	}

}