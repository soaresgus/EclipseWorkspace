package me.ninjay.youtubertrade.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.youtubertrade.main.Main;
import me.ninjay.youtubertrade.utils.Mine;

public class ItensAPI {
	
	public static ItemStack geleia() {
		ItemStack item = Mine.newItem(Material.SLIME_BLOCK, "§dGeleia do Geleia do Geleia...");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack mato() {
		ItemStack item = Mine.newItem(Material.GRASS, "§dMatinho sagrado");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack cash(Integer amount) {
		ItemStack item = Mine.newItem(Material.PAPER, "§aCash", amount, 0, " ", " §7Use como moeda de troca com youtubers.");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack caixa() {
		ItemStack item = Mine.newItem(Material.ORANGE_CONCRETE, "§eCaixa de Youtubers");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(caixa());
		
		rrr.shape("@@@", "@@@", "@@@");
		
		rrr.setIngredient('@', Material.PAPER);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
