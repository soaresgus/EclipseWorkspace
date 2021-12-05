package me.ninjay.fashmining.eventos;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.ninjay.fashmining.main.Main;
import me.ninjay.fashmining.utils.Mine;

public class EventosMinerios implements Listener {

	public static void quebrar(Player p, Material material, Block b, String nome) {
		if (b.getType() == material) {
			Main.config.set(p.getName() + "." + nome, Main.config.getInt(p.getName() + "." + nome) + 1);
			Main.config.saveConfig();
		}

	}

	public static void coletar(Player p, String nome, Material material) {
		if (Main.config.getInt(p.getName() + "." + nome) <= 0) {
			p.getOpenInventory().close();
			p.sendMessage("§cVocê não possuí esse tipo de minério.");
			return;
		} else {
			p.getOpenInventory().close();
			p.getInventory().addItem(Mine.newItem(material, null, Main.config.getInt(p.getName() + "." + nome)));
			Main.config.set(p.getName() + "." + nome, 0);
			Main.config.saveConfig();
		}

	}

	@EventHandler
	public void aoQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();

			
		
		quebrar(p, Material.COAL_ORE, b, "coal");
		quebrar(p, Material.IRON_ORE, b, "iron");
		quebrar(p, Material.REDSTONE_ORE, b, "redstone");
		quebrar(p, Material.GOLD_ORE, b, "gold");
		quebrar(p, Material.DIAMOND_ORE, b, "diamond");
		quebrar(p, Material.LAPIS_ORE, b, "lapis");
		quebrar(p, Material.EMERALD_ORE, b, "emerald");

	}

	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory i = e.getInventory();
		
			if(i.getTitle().equalsIgnoreCase("seus minérios")) {
				if(e.getCurrentItem() == null) {
					return;
				}
				if(e.getCurrentItem().getType() == Material.COAL) {
					coletar(p, "coal", Material.COAL);
				}
				if(e.getCurrentItem().getType() == Material.IRON_INGOT) {
					coletar(p, "iron", Material.IRON_INGOT);
				}
				if(e.getCurrentItem().getType() == Material.REDSTONE) {
					coletar(p, "redstone", Material.REDSTONE);
				}
				if(e.getCurrentItem().getType() == Material.GOLD_INGOT) {
					coletar(p, "gold", Material.GOLD_INGOT);
				}
				if(e.getCurrentItem().getType() == Material.DIAMOND) {
					coletar(p, "diamond", Material.DIAMOND);
				}
				if(e.getCurrentItem().getType() == Material.INK_SACK) {
					coletar(p, "lapis", Material.INK_SACK);
				}
				if(e.getCurrentItem().getType() == Material.EMERALD) {
					coletar(p, "emerald", Material.EMERALD);
				}
				
			}
			
		
	}

}
