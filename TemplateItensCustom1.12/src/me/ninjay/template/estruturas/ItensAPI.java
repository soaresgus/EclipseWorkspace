package me.ninjay.template.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.template.main.Main;
import me.ninjay.template.utils.Mine;

public class ItensAPI {
	
	public static ItemStack item() {
		ItemStack item = Mine.newItem(Material.CLAY_BALL, "§dItem", 1, 0, " ", "  §7Template");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(item());
		
		rrr.shape("@@@", "@@@", "@@@");
		
		rrr.setIngredient('@', Material.DIRT);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
