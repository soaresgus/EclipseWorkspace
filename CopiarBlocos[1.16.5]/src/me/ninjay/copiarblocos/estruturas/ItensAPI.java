package me.ninjay.copiarblocos.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.copiarblocos.main.Main;
import me.ninjay.copiarblocos.utils.Mine;

public class ItensAPI {
	
	public static ItemStack copiadora() {
		ItemStack item = Mine.newItem(Material.GOLDEN_SWORD, "§d§lCopiadora", 1, 0, " ", "  §7Copie e cole qualquer coisa!... Enquanto houver tinta.");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(copiadora());
		
		rrr.shape("@@@", "$#$", " # ");
		
		rrr.setIngredient('@', Material.WHITE_WOOL);
		rrr.setIngredient('#', Material.STICK);
		rrr.setIngredient('$', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
