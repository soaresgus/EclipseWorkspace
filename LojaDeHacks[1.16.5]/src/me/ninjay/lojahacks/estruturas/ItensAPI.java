package me.ninjay.lojahacks.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import me.ninjay.lojahacks.main.Main;
import me.ninjay.lojahacks.utils.Mine;

public class ItensAPI {
	
	public static ItemStack estagio1 = Mine.newItem(Material.RED_CONCRETE, "§c§kAAAAAAAAAA", 1, 0, " ", "  §7Error 404");
	public static ItemStack estagio2 = Mine.newItem(Material.BLUE_CONCRETE, "§9§kAAAAAAAAAA", 1, 0, " ", "  §7Reiniciando... Reiniciando...");
	public static ItemStack estagio3 = Mine.newItem(Material.YELLOW_CONCRETE, "§e§kAAAAAAAAAA", 1, 0, " ", "  §73.14159265359.NaN");
	
	public static void customCraft() {
		ShapedRecipe estagio1r = new ShapedRecipe(estagio1);
		
		estagio1r.shape("@@@", "@#@", "@@@");
		
		estagio1r.setIngredient('@', Material.REDSTONE);
		estagio1r.setIngredient('#', Material.CRAFTING_TABLE);
		Main.getPlugin(Main.class).getServer().addRecipe(estagio1r);
		
		ShapedRecipe estagio2r = new ShapedRecipe(estagio2);
		
		estagio2r.shape("@@@", "@#@", "@@@");
		
		estagio2r.setIngredient('@', Material.LAPIS_LAZULI);
		estagio2r.setIngredient('#', Material.RED_CONCRETE);
		Main.getPlugin(Main.class).getServer().addRecipe(estagio2r);
		
		ShapedRecipe estagio3r = new ShapedRecipe(estagio3);
		
		estagio3r.shape("@@@", "@#@", "@@@");
		
		estagio3r.setIngredient('@', Material.GOLD_INGOT);
		estagio3r.setIngredient('#', Material.BLUE_CONCRETE);
		Main.getPlugin(Main.class).getServer().addRecipe(estagio3r);
	}
	
}
