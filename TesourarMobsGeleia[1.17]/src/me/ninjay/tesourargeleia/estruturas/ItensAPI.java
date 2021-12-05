package me.ninjay.tesourargeleia.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.tesourargeleia.main.Main;
import me.ninjay.tesourargeleia.utils.Mine;

public class ItensAPI {
	
	public static ItemStack tesoura() {
		ItemStack item = Mine.newItem(Material.SHEARS, "§6Tesoura Magica", 1, 0, " ", "  §7Atenção, tenha muito cuidado ao", "  §7usar este poderoso artefato!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack create(Armardura armor, String tipo, String mob) {
		if(armor == Armardura.CAPACETE) {
			return Mine.newItem(Material.matchMaterial(tipo+"_HELMET"), "§eCapacete de "+mob);
		}
		
		if(armor == Armardura.PEITORAL) {
			return Mine.newItem(Material.matchMaterial(tipo+"_CHESTPLATE"), "§ePeitoral de "+mob);
		}
		
		if(armor == Armardura.CALÇA) {
			return Mine.newItem(Material.matchMaterial(tipo+"_LEGGINGS"), "§eCalca de "+mob);
		}
		
		if(armor == Armardura.BOTA) {
			return Mine.newItem(Material.matchMaterial(tipo+"_BOOTS"), "§eBotas de "+mob);
		}
		return null;
	}
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(tesoura());
		
		rrr.shape(" @@", "#%@", "&$ ");
		
		rrr.setIngredient('@', Material.GOLD_INGOT);
		rrr.setIngredient('#', Material.BONE_MEAL);
		rrr.setIngredient('$', Material.STRING);
		rrr.setIngredient('%', Material.POPPY);
		rrr.setIngredient('&', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
