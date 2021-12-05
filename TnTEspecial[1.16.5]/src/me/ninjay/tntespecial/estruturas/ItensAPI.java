package me.ninjay.tntespecial.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import me.ninjay.tntespecial.main.Main;
import me.ninjay.tntespecial.utils.Mine;

public class ItensAPI {

	public static ItemStack esticada = Mine.newItem(Material.ORANGE_CONCRETE, "§d§lTnT Esticada");
	public static ItemStack abelha = Mine.newItem(Material.MAGENTA_CONCRETE, "§d§lTnT de Abelhas");
	public static ItemStack esmagadora = Mine.newItem(Material.YELLOW_CONCRETE, "§d§lTnT Esmagadora");
	public static ItemStack espelhada = Mine.newItem(Material.LIME_CONCRETE, "§d§lTnT Espelhada");
	public static ItemStack meteoro = Mine.newItem(Material.GREEN_CONCRETE, "§d§lTnT de Meteoro");
	public static ItemStack gravidade = Mine.newItem(Material.PINK_CONCRETE, "§d§lTnT de Gravidade");
	public static ItemStack sorte = Mine.newItem(Material.BLUE_CONCRETE, "§d§lTnT de Sorte");
	public static ItemStack bedrock = Mine.newItem(Material.BROWN_CONCRETE, "§d§lTnT de Bedrock Espelhada");
	public static ItemStack espiral = Mine.newItem(Material.RED_CONCRETE, "§d§lMega TnT de Laser Espiral");
	
	public static void customCraft() {
		ShapedRecipe esticadar = new ShapedRecipe(esticada);
			
		esticadar.shape("@#@", "@#@", "@#@");
			
		esticadar.setIngredient('@', Material.GRASS);
		esticadar.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(esticadar);
		
		ShapedRecipe abelhar = new ShapedRecipe(abelha);
		
		abelhar.shape("@@@", "@#@", "@@@");
			
		abelhar.setIngredient('@', Material.BEE_NEST);
		abelhar.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(abelhar);
		
		ShapedRecipe esmagadorar = new ShapedRecipe(esmagadora);
		
		esmagadorar.shape("@@@", "###", "@@@");
			
		esmagadorar.setIngredient('@', Material.ANVIL);
		esmagadorar.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(esmagadorar);
		
		ShapedRecipe espelhadar = new ShapedRecipe(espelhada);
		
		espelhadar.shape("@@@", "@#@", "@@@");
			
		espelhadar.setIngredient('@', Material.GLASS);
		espelhadar.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(espelhadar);
		
		ShapedRecipe meteoror = new ShapedRecipe(meteoro);
		
		meteoror.shape("$$$", "@#@", "@@@");
			
		meteoror.setIngredient('@', Material.BLAZE_POWDER);
		meteoror.setIngredient('$', Material.GUNPOWDER);
		meteoror.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(meteoror);
		
		ShapedRecipe gravidader = new ShapedRecipe(gravidade);
		
		gravidader.shape("$$$", "$#$", "@@@");
		
		gravidader.setIngredient('@', Material.SLIME_BLOCK);
		gravidader.setIngredient('$', Material.FEATHER);
		gravidader.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(gravidader);
		
		ShapedRecipe sorter = new ShapedRecipe(sorte);
		
		sorter.shape("@%@", "$#$", "@%@");
			
		sorter.setIngredient('@', Material.GOLD_INGOT);
		sorter.setIngredient('$', Material.IRON_INGOT);
		sorter.setIngredient('%', Material.TOTEM_OF_UNDYING);
		sorter.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(sorter);
		
		ShapedRecipe bedrockr = new ShapedRecipe(bedrock);
		
		bedrockr.shape("$$$", "@#@", "@@@");
			
		bedrockr.setIngredient('@', Material.BEDROCK);
		bedrockr.setIngredient('$', Material.GLASS);
		bedrockr.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(bedrockr);
		
		ShapedRecipe laserr = new ShapedRecipe(espiral);
		
		laserr.shape("@$%", "&#*", "(((");
			
		laserr.setIngredient('@', Material.NETHERITE_SCRAP);
		laserr.setIngredient('$', Material.FIREWORK_ROCKET);
		laserr.setIngredient('%', Material.BEACON);
		laserr.setIngredient('&', Material.WITHER_SKELETON_SKULL);
		laserr.setIngredient('*', Material.NETHER_STAR);
		laserr.setIngredient('(', Material.LAVA_BUCKET);
		laserr.setIngredient('#', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(laserr);
	}
	
	
	
}
