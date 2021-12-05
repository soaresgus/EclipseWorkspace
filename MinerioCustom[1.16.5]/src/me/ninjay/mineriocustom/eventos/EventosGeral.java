package me.ninjay.mineriocustom.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import me.ninjay.mineriocustom.estruturas.Minerio;
import me.ninjay.mineriocustom.estruturas.MinerioAPI;
import me.ninjay.mineriocustom.utils.Mine;

public class EventosGeral implements Listener{
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock() != null) {
			Minerio minerio = MinerioAPI.manager.getMinerioByType(e.getBlock().getType());
			
			if(minerio != null) {
				e.setDropItems(false);
				
			if(minerio.getPicareta().size() == 6) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0)) || (minerio.getPicareta().get(1) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(1)) || (minerio.getPicareta().get(2) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(2)) || (minerio.getPicareta().get(3) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(3)) || (minerio.getPicareta().get(4) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(4)) || (minerio.getPicareta().get(5) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(5))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
			
			if(minerio.getPicareta().size() == 5) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0)) || (minerio.getPicareta().get(1) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(1)) || (minerio.getPicareta().get(2) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(2)) || (minerio.getPicareta().get(3) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(3)) || (minerio.getPicareta().get(4) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(4))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
			
			if(minerio.getPicareta().size() == 4) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0)) || (minerio.getPicareta().get(1) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(1)) || (minerio.getPicareta().get(2) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(2)) || (minerio.getPicareta().get(3) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(3))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
			
			if(minerio.getPicareta().size() == 3) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0)) || (minerio.getPicareta().get(1) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(1)) || (minerio.getPicareta().get(2) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(2))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
			
			if(minerio.getPicareta().size() == 2) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0)) || (minerio.getPicareta().get(1) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(1))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
			
			if(minerio.getPicareta().size() == 1) {
				if((minerio.getPicareta().get(0) != null && p.getInventory().getItemInMainHand().getType() == minerio.getPicareta().get(0))) {
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), new ItemStack(minerio.getDrop(), Mine.getRandomInt(minerio.getMin(), minerio.getMax())));
				}else {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1F, 1F);
					p.sendMessage("§cEssa picareta não é o suficiente para quebrar esse bloco!");
				}
			}
				
			}else {
				if(e.getBlock().getType() == Material.GRAY_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.INVISIBILITY, true, false));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.LIME_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.JUMP, false, true));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.YELLOW_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.LIGHT_BLUE_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.MAGENTA_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.REGEN, false, true));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				
				if(e.getBlock().getType() == Material.ORANGE_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				
				if(e.getBlock().getType() == Material.WHITE_CONCRETE) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.SLOW_FALLING, false, false));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				
				if(e.getBlock().getType() == Material.BLACK_TERRACOTTA) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, true, false));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.RED_TERRACOTTA) {
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.POTION, null, 1, 0);
					PotionMeta am = (PotionMeta) a.getItemMeta();
					am.setBasePotionData(new PotionData(PotionType.LUCK, false, false));
					a.setItemMeta(am);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				if(e.getBlock().getType() == Material.MAGENTA_WOOL) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack c = Mine.newItem(Material.ENCHANTED_BOOK, null, 1, 0);
					EnchantmentStorageMeta cm = (EnchantmentStorageMeta) c.getItemMeta();
					cm.addEnchant(Enchantment.values()[(int)Mine.getRandomInt(0, Enchantment.values().length)], Mine.getRandomInt(1, 3), false);
					c.setItemMeta(cm);
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), c);
				}
				
				if(e.getBlock().getType() == Material.DARK_PRISMARINE) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack a = Mine.newItem(Material.NETHERITE_HELMET, "§dRainbow Helmet", 1 ,0, " ", "  §7Nível de item: §6EXTREMAMENTE RARO!");
					Mine.addEnchant(a, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					Mine.addEnchant(a, Enchantment.PROTECTION_EXPLOSIONS, 10);
					Mine.addEnchant(a, Enchantment.PROTECTION_FIRE, 10);
					Mine.addEnchant(a, Enchantment.DURABILITY, 10);
					
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), a);
				}
				
				if(e.getBlock().getType() == Material.PRISMARINE_BRICKS) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack b = Mine.newItem(Material.NETHERITE_CHESTPLATE, "§dRainbow Chestplate", 1 ,0, " ", "  §7Nível de item: §6EXTREMAMENTE RARO!");
					Mine.addEnchant(b, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					Mine.addEnchant(b, Enchantment.PROTECTION_EXPLOSIONS, 10);
					Mine.addEnchant(b, Enchantment.PROTECTION_FIRE, 10);
					Mine.addEnchant(b, Enchantment.DURABILITY, 10);
					
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), b);
				}
				
				if(e.getBlock().getType() == Material.PRISMARINE) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack c = Mine.newItem(Material.NETHERITE_LEGGINGS, "§dRainbow Leggings", 1 ,0, " ", "  §7Nível de item: §6EXTREMAMENTE RARO!");
					Mine.addEnchant(c, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					Mine.addEnchant(c, Enchantment.PROTECTION_EXPLOSIONS, 10);
					Mine.addEnchant(c, Enchantment.PROTECTION_FIRE, 10);
					Mine.addEnchant(c, Enchantment.DURABILITY, 10);
					
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), c);
				}
				
				if(e.getBlock().getType() == Material.SEA_LANTERN) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack d = Mine.newItem(Material.NETHERITE_BOOTS, "§dRainbow Boots", 1 ,0, " ", "  §7Nível de item: §6EXTREMAMENTE RARO!");
					Mine.addEnchant(d, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
					Mine.addEnchant(d, Enchantment.PROTECTION_EXPLOSIONS, 10);
					Mine.addEnchant(d, Enchantment.PROTECTION_FIRE, 10);
					Mine.addEnchant(d, Enchantment.PROTECTION_FALL, 10);
					Mine.addEnchant(d, Enchantment.DURABILITY, 10);
					
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), d);
				}
				
				if(e.getBlock().getType() == Material.BRICKS) {
					e.setCancelled(false);
					e.setDropItems(false);
					ItemStack ee = Mine.newItem(Material.NETHERITE_SWORD, "§dRainbow Sword", 1 ,0, " ", "  §7Nível de item: §6EXTREMAMENTE RARO!");
					Mine.addEnchant(ee, Enchantment.DAMAGE_ALL, 10);
					Mine.addEnchant(ee, Enchantment.DURABILITY, 10);		
					Mine.addEnchant(ee, Enchantment.FIRE_ASPECT, 10);
					
					p.getWorld().dropItem(e.getBlock().getLocation().add(0, 0.3, 0), ee);
				}
			}
		}
	}

}
