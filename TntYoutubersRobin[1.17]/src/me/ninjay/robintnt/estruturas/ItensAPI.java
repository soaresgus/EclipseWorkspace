package me.ninjay.robintnt.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import me.ninjay.robintnt.main.Main;
import me.ninjay.robintnt.utils.Mine;

public class ItensAPI {
	
	public static ItemStack robin = Mine.newItem(Material.LIME_CONCRETE, "§2TnT do Robin Hood", 1, 0, " ", "  §7Espero que você tenha um guarda-chuva!");
	public static ItemStack davi = Mine.newItem(Material.RED_CONCRETE, "§6TnT do HeyDavi", 1, 0, " ", "  §7Ei mine, corre aqui...");
	public static ItemStack beto = Mine.newItem(Material.YELLOW_CONCRETE, "§bTnT do Beto", 1, 0, " ", "  §7Não deixem os villagers acharem isso!");
	public static ItemStack faisca = Mine.newItem(Material.ORANGE_CONCRETE, "§5TnT do Faisca", 1, 0, " ", "  §7Hm... Eu ouvi? peixes?");
	public static ItemStack jhow = Mine.newItem(Material.PINK_CONCRETE, "§7TnT do Jhow", 1, 0, " ", "  §7O sonho de todo cachorro bonzinho!");
	
	public static void customCraft() {
		ShapedRecipe robinr = new ShapedRecipe(robin);
		
		robinr.shape("@#@", "#$#", "@#@");
		
		robinr.setIngredient('@', Material.BOW);
		robinr.setIngredient('#', Material.ARROW);
		robinr.setIngredient('$', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(robinr);
		
		ShapedRecipe davir = new ShapedRecipe(davi);
		
		davir.shape("@@@", "#$#", "@@@");
		
		davir.setIngredient('@', Material.COPPER_INGOT);
		davir.setIngredient('#', Material.TNT);
		davir.setIngredient('$', Material.IRON_PICKAXE);
		Main.getPlugin(Main.class).getServer().addRecipe(davir);
		
		ShapedRecipe betor = new ShapedRecipe(beto);
		
		betor.shape("###", "$$$", "@@@");
		
		betor.setIngredient('@', Material.WHEAT);
		betor.setIngredient('#', Material.TNT);
		betor.setIngredient('$', Material.BREAD);
		Main.getPlugin(Main.class).getServer().addRecipe(betor);
		
		ShapedRecipe faiscar = new ShapedRecipe(faisca);
		
		faiscar.shape("$", "#", "@");
		
		faiscar.setIngredient('@', Material.WATER_BUCKET);
		faiscar.setIngredient('#', Material.TNT);
		faiscar.setIngredient('$', Material.MILK_BUCKET);
		Main.getPlugin(Main.class).getServer().addRecipe(faiscar);
		
		ShapedRecipe jhowr = new ShapedRecipe(jhow);
		
		jhowr.shape("@@@", "###", "$$$");
		
		jhowr.setIngredient('@', Material.BONE);
		jhowr.setIngredient('#', Material.TNT);
		jhowr.setIngredient('$', Material.ROTTEN_FLESH);
		Main.getPlugin(Main.class).getServer().addRecipe(jhowr);
	}
	
}
