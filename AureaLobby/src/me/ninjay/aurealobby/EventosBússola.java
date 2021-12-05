package me.ninjay.aurealobby;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class EventosBússola implements Listener{

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		org.bukkit.event.block.Action a = e.getAction();
		
		ItemStack bus = new ItemStack(Material.COMPASS);
		ItemMeta busm = bus.getItemMeta();
		busm.setDisplayName("§eServidores");
		busm.setLore(Arrays.asList(" ", "§e§lBússola de navegação",
				" §7Utilize essa bússola para entrar em nossos servidores"));
		bus.setItemMeta(busm);
		
		ItemStack gal = new ItemStack(Material.STAINED_CLAY, 1, (short) 11);
		ItemMeta galm = gal.getItemMeta();
		galm.setDisplayName("§f§lRankUp §5§lGalaxy");
		galm.addEnchant(Enchantment.DURABILITY, 1, false);
		galm.setLore(Arrays.asList("§6§lNovidades"," "," §7» Vários ranks diferentes"," §7» Mapas únicos", " §7» Tema espacial"," §7» Sistema de máquinas"," §7» Sistema de exploração espacial"," §7» Sistema de árvore de habilidades"));
		gal.setItemMeta(galm);
		
		if(!p.getItemInHand().isSimilar(bus)) {
			
			return;
		}
	
		if(p.getItemInHand().isSimilar(bus) && a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
			Inventory menu = Bukkit.createInventory(null, 9*3, "Servidores");
			menu.setItem(13, gal);
			p.openInventory(menu);
			return;
	
		}
		
			
		}
	@EventHandler
	public void clicardentro(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack gal = new ItemStack(Material.STAINED_CLAY, 1, (short) 11);
		ItemMeta galm = gal.getItemMeta();
		galm.setDisplayName("§f§lRankUp §5§lGalaxy");
		galm.addEnchant(Enchantment.DURABILITY, 1, false);
		galm.setLore(Arrays.asList("§6§lNovidades"," "," §7» Vários ranks diferentes"," §7» Mapas únicos", " §7» Tema espacial"," §7» Sistema de máquinas"," §7» Sistema de exploração espacial"," §7» Sistema de árvore de habilidades"));
		gal.setItemMeta(galm);
		
		if(e.getWhoClicked() instanceof Player) {
			if(e.getInventory().getTitle().equals("Servidores")) {
				if(e.getCurrentItem().isSimilar(gal)) {
					p.chat("/server rankup");
					p.sendMessage("§aConectando ao §f§lRankUp §5§lGalaxy§a...");
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}
