package me.ninjay.circles_geradores.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.circles_geradores.main.Main;
import me.ninjay.circles_geradores.utils.Mine;


public class ItensAPI {
	
	public static ItemStack gerador() {
		ItemStack item = Mine.newItem(Material.PISTON_BASE, "§eGerador de Blocos", 1, 0, " ", "  §7Utilize para gerar seus blocos de proteção!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack obsidian() {
		ItemStack item = Mine.newItem(Material.WOOL, "§7Obsidian Reforcada", 1, 0, " ", "  §7Durabilidade: §8??/??");
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe obr = new ShapedRecipe(obsidian());
		
		obr.shape("@@", "@@");
		
		obr.setIngredient('@', Material.OBSIDIAN);
		Main.getPlugin(Main.class).getServer().addRecipe(obr);
	}
	
}
