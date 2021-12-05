package me.ninjay.oneperfil.almas.eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.ninjaapi.utils.Mine;
import me.ninjay.oneperfil.almas.estruturas.AlmasAPI;
import me.ninjay.oneperfil.almas.estruturas.EstruturaJogador;
import me.ninjay.oneperfil.main.Main;

public class EventosAlmas implements Listener {

	@EventHandler
	public void aoClicar(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if(e.getRightClicked() instanceof Villager ) {
			Villager vil = (Villager) e.getRightClicked();
			e.setCancelled(true);
			if(vil.getCustomName().contains("§eMercado de Almas")) {
			Inventory inv = Mine.newInventory("Mercado de Almas", 9*3);
			ItemStack p41 = Mine.newItem(Material.DIAMOND_HELMET, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
			
			ItemMeta p41m = p41.getItemMeta();
			p41m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			p41.setItemMeta(p41m);
			
			ItemStack p42 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
			
			ItemMeta p42m = p42.getItemMeta();
			p42m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			p42.setItemMeta(p42m);
			
			ItemStack p43 = Mine.newItem(Material.DIAMOND_LEGGINGS, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
			
			ItemMeta p43m = p43.getItemMeta();
			p43m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			p43.setItemMeta(p43m);
			
			ItemStack p44 = Mine.newItem(Material.DIAMOND_BOOTS, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
			
			ItemMeta p44m = p44.getItemMeta();
			p44m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			p44.setItemMeta(p44m);
			
			ItemStack espada1 = Mine.newItem(Material.DIAMOND_SWORD, "§6Espada §e[Comprado com almas]",1,0,"§6Valor: §e[20 Almas]");
			
			ItemMeta espada1m = espada1.getItemMeta();
			espada1m.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
			espada1m.addEnchant(Enchantment.DURABILITY, 3, true);
			espada1.setItemMeta(espada1m);
			
	        ItemStack espada2 = Mine.newItem(Material.DIAMOND_SWORD, "§6Espada §e[Comprado com almas]",1,0,"§6Valor: §e[15 Almas]");
			
			ItemMeta espada2m = espada2.getItemMeta();
			espada2m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
			espada2m.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
			espada2.setItemMeta(espada2m);
			
			EstruturaJogador.mercadoNegro(p, inv, p41, Mine.getPosition(2, 2), p42, Mine.getPosition(2, 3), p43, Mine.getPosition(2, 4), p44, Mine.getPosition(2, 5), espada1,Mine.getPosition(2, 6), espada2,Mine.getPosition(2, 7));
			}
 		}
	}

	@EventHandler
	public void aoMatar(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Villager) {
			Villager vil = (Villager) e.getEntity();
			if (vil.getCustomName().contains("§eMercado de Almas")) {
				if (e.getDamager() instanceof Player) {
					Player p = (Player) e.getDamager();
					ItemStack vara = Mine.newItem(Material.CARROT_STICK, "§eMatar NPC", 1, 0, " ", "§e§lMatar NPC",
							"§e Hite o NPC com a varinha para mata-lo.");
					ItemMeta varam = vara.getItemMeta();
					varam.addEnchant(Enchantment.DURABILITY, 5, false);
					vara.setItemMeta(varam);
					if (p.hasPermission("almas.admin") && p.getItemInHand().isSimilar(vara)) {
						vil.setHealth(0.0);
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void aoMatarPlayer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player d = (Player) e.getEntity().getKiller();

		if (p instanceof Player) {
			if (d instanceof Player) {
				AlmasAPI.addAlmas(d, Main.almas, (long) 1);
				AlmasAPI.removeAlmas(p, Main.almas, (long) 1);

			}
		}
	}
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack p41 = Mine.newItem(Material.DIAMOND_HELMET, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
		
		ItemMeta p41m = p41.getItemMeta();
		p41m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		p41.setItemMeta(p41m);
		
		ItemStack p42 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
		
		ItemMeta p42m = p42.getItemMeta();
		p42m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		p42.setItemMeta(p42m);
		
		ItemStack p43 = Mine.newItem(Material.DIAMOND_LEGGINGS, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
		
		ItemMeta p43m = p43.getItemMeta();
		p43m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		p43.setItemMeta(p43m);
		
		ItemStack p44 = Mine.newItem(Material.DIAMOND_BOOTS, "§6P4 §e[Comprado com almas]",1,0,"§6Valor: §e[25 Almas]");
		
		ItemMeta p44m = p44.getItemMeta();
		p44m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		p44.setItemMeta(p44m);
		
		ItemStack espada1 = Mine.newItem(Material.DIAMOND_SWORD, "§6Espada §e[Comprado com almas]",1,0,"§6Valor: §e[20 Almas]");
		
		ItemMeta espada1m = espada1.getItemMeta();
		espada1m.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
		espada1m.addEnchant(Enchantment.DURABILITY, 3, true);
		espada1.setItemMeta(espada1m);
		
        ItemStack espada2 = Mine.newItem(Material.DIAMOND_SWORD, "§6Espada §e[Comprado com almas]",1,0,"§6Valor: §e[15 Almas]");
		
		ItemMeta espada2m = espada2.getItemMeta();
		espada2m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		espada2m.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
		espada2.setItemMeta(espada2m);
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(p41)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 25) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(p41);
					AlmasAPI.removeAlmas(p, Main.almas, (long)25); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(p42)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 25) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(p42);
					AlmasAPI.removeAlmas(p, Main.almas, (long)25); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(p43)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 25) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(p43);
					AlmasAPI.removeAlmas(p, Main.almas, (long)25); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(p44)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 25) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(p44);
					AlmasAPI.removeAlmas(p, Main.almas, (long)25); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(espada1)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 20) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(espada1);
					AlmasAPI.removeAlmas(p, Main.almas, (long)20); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
		if(e.getInventory().getTitle().equals("Mercado de Almas")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(espada2)) {
				if(AlmasAPI.getAlmas(p, Main.almas) >= 15) {
					p.getOpenInventory().close();
					p.sendMessage("§6Você comprou um item com almas.");
					p.getInventory().addItem(espada2);
					AlmasAPI.removeAlmas(p, Main.almas, (long)15); 
				}else {
					p.getOpenInventory().close();
					p.sendMessage("§cVocê não tem almas o suficiente.");
				}
 			}
		}
	}
	
	
}