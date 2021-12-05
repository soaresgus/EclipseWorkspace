package me.ninjay.tesourarmoon.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.tesourarmoon.main.Main;
import me.ninjay.tesourarmoon.utils.Mine;

public class ItensAPI {
	
	public static ItemStack tesoura() {
		ItemStack item = Mine.newItem(Material.SHEARS, "§bTesoura Mistica", 1, 0, " ", "  §7Finja que está tosando seu gato,", "  §7só tome cuidado para não se cortar!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack create(Armardura armor, String tipo, String mob) {
		if(armor == Armardura.CAPACETE) {
			return Mine.newItem(Material.matchMaterial(tipo+"_HELMET"), "§dCapacete de "+mob);
		}
		
		if(armor == Armardura.PEITORAL) {
			return Mine.newItem(Material.matchMaterial(tipo+"_CHESTPLATE"), "§dPeitoral de "+mob);
		}
		
		if(armor == Armardura.CALÇA) {
			return Mine.newItem(Material.matchMaterial(tipo+"_LEGGINGS"), "§dCalca de "+mob);
		}
		
		if(armor == Armardura.BOTA) {
			return Mine.newItem(Material.matchMaterial(tipo+"_BOOTS"), "§dBotas de "+mob);
		}
		return null;
	}
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(tesoura());
		
		rrr.shape(" &%", "$#&", " $ ");
		
		rrr.setIngredient('#', Material.SHEARS);
		rrr.setIngredient('$', Material.STICK);
		rrr.setIngredient('%', Material.FEATHER);
		rrr.setIngredient('&', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
