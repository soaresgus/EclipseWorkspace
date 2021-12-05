package me.ninjay.magic;


import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
	
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		ItemMeta imeta = item.getItemMeta();
		imeta.setDisplayName("§eCajado de mago");
		imeta.setLore(Arrays.asList("§7Clique esquerdo para mudar a magia","§7Clique direito para usar a magia"," ", "§cAtenção o cajado só pode ser utilizado §c§luma §cvez."));
		imeta.addEnchant(Enchantment.DURABILITY, 1, false);
		item.setItemMeta(imeta);
		
		ShapedRecipe craft = new ShapedRecipe(item);
		craft.shape("BBB","AAA","CCC");
		craft.setIngredient('A', Material.BLAZE_ROD);
		craft.setIngredient('B', Material.STICK);
		craft.setIngredient('C', Material.OBSIDIAN);
		Bukkit.addRecipe(craft);
		
		Bukkit.getPluginManager().registerEvents(new Habilidade(), this);
	}
}
