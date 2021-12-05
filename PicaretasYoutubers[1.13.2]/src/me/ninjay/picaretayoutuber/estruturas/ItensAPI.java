package me.ninjay.picaretayoutuber.estruturas;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import me.ninjay.picaretayoutuber.main.Main;
import me.ninjay.picaretayoutuber.utils.Mine;

public class ItensAPI implements Listener{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public static ItemStack minguado = Mine.newItem(Material.DIAMOND_PICKAXE, "§cPicareta do Minguado");
	public static ItemStack moon = Mine.newItem(Material.GOLDEN_PICKAXE, "§ePicareta da Moonkase");
	public static ItemStack lua = Mine.newItem(Material.IRON_PICKAXE, "§9Picareta da Lua");
	public static ItemStack jeredy = Mine.newItem(Material.STONE_PICKAXE, "§1Picareta do Jeredy");
	public static ItemStack robin = Mine.newItem(Material.WOODEN_PICKAXE, "§2Picareta do RobinHood");
	public static ItemStack tazer = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Picareta do TazerCraft");
	
	public static ItemStack tnt = Mine.newItem(Material.BLAZE_ROD, "§cGraveto de TnT");
	public static ItemStack lapis = Mine.newItem(Material.MAGMA_CREAM, "§9Graveto de Lapis");
	public static ItemStack pedra = Mine.newItem(Material.FEATHER, "§7Graveto de Pedra");
	public static ItemStack ouro = Mine.newItem(Material.FERMENTED_SPIDER_EYE, "§6Graveto de Ouro");
	
	public static ItemStack minguadoh = Mine.newHead("§fCabeça de Minguado", "Minguado", 1);
	public static ItemStack moonh = Mine.newHead("§fCabeça de Moonkase", "Moonkase", 1);
	public static ItemStack luah = Mine.newHead("§fCabeça de Lua99", "Lua99", 1);
	public static ItemStack jeredyh = Mine.newHead("§fCabeça de _Jeredy_", "_Jeredy_", 1);
	public static ItemStack robinh = Mine.newHead("§fCabeça de RobinHoodGamer", "RobinHoodGamer", 1);
	public static ItemStack patwh = Mine.newHead("§fCabeça de pactw", "pactw", 1);
	public static ItemStack mikeh = Mine.newHead("§fCabeça de mikethelink", "mikethelink", 1);
	
	public void customRecipe() {
		ShapedRecipe minguador = new ShapedRecipe(minguado);
		
		minguador.shape("!@#", " $@", "% !");
		
		minguador.setIngredient('!', Material.EMERALD_BLOCK);
		minguador.setIngredient('@', Material.DIAMOND_BLOCK);
		minguador.setIngredient('#', Material.PLAYER_HEAD);
		minguador.setIngredient('$', Material.BLAZE_ROD);
		minguador.setIngredient('%', Material.TNT);
		
		plugin.getServer().addRecipe(minguador);
		
		ShapedRecipe moonr = new ShapedRecipe(moon);
		
		moonr.shape("!@#", " $@", "$ !");
		
		moonr.setIngredient('!', Material.GOLD_INGOT);
		moonr.setIngredient('@', Material.SMOOTH_QUARTZ);
		moonr.setIngredient('#', Material.PLAYER_HEAD);
		moonr.setIngredient('$', Material.MAGMA_CREAM);
		
		plugin.getServer().addRecipe(moonr);
		
		ShapedRecipe luar = new ShapedRecipe(lua);
		
		luar.shape("!@#", " $@", "$ !");
		
		luar.setIngredient('!', Material.CYAN_DYE, 6);
		luar.setIngredient('@', Material.STONE_BRICKS);
		luar.setIngredient('#', Material.PLAYER_HEAD);
		luar.setIngredient('$', Material.FEATHER);
		
		plugin.getServer().addRecipe(luar);
		
		ShapedRecipe jeredyr = new ShapedRecipe(jeredy);
		
		jeredyr.shape("!@#", " $@", "$ !");
		
		jeredyr.setIngredient('!', Material.CLOCK);
		jeredyr.setIngredient('@', Material.LIGHT_BLUE_BED);
		jeredyr.setIngredient('#', Material.PLAYER_HEAD);
		jeredyr.setIngredient('$', Material.FEATHER);
		
		plugin.getServer().addRecipe(jeredyr);
		
		ShapedRecipe robinr = new ShapedRecipe(robin);
		
		robinr.shape("!@#", " $@", "% !");
		
		robinr.setIngredient('!', Material.STRING);
		robinr.setIngredient('@', Material.OAK_PLANKS);
		robinr.setIngredient('#', Material.PLAYER_HEAD);
		robinr.setIngredient('$', Material.ARROW);
		robinr.setIngredient('%', Material.OAK_LOG);
		
		plugin.getServer().addRecipe(robinr);
		
		ShapedRecipe tazerr = new ShapedRecipe(tazer);
		
		tazerr.shape("!#%", " $#", "$ @");
		
		tazerr.setIngredient('!', Material.EMERALD_BLOCK);
		tazerr.setIngredient('@', Material.DIAMOND_BLOCK);
		tazerr.setIngredient('#', Material.PLAYER_HEAD);
		tazerr.setIngredient('$', Material.FERMENTED_SPIDER_EYE);
		tazerr.setIngredient('%', Material.ENCHANTED_GOLDEN_APPLE);
		
		plugin.getServer().addRecipe(tazerr);
		
		ShapedRecipe tntr = new ShapedRecipe(tnt);
		
		tntr.shape(" @ ", " ! ", " @ ");
		
		tntr.setIngredient('!', Material.ROSE_RED, 1);
		tntr.setIngredient('@', Material.TNT);
		
		plugin.getServer().addRecipe(tntr);
		
		ShapedRecipe lapisr = new ShapedRecipe(lapis);
		
		lapisr.shape(" @ ", " ! ", " @ ");
		
		lapisr.setIngredient('!', Material.LAPIS_LAZULI);
		lapisr.setIngredient('@', Material.LAPIS_BLOCK);
		
		plugin.getServer().addRecipe(lapisr);
		
		ShapedRecipe stoner = new ShapedRecipe(pedra);
		
		stoner.shape(" @ ", " @ ", " @ ");
		
		stoner.setIngredient('@', Material.STONE_BRICKS);
		
		plugin.getServer().addRecipe(stoner);
		
		ShapedRecipe ouror = new ShapedRecipe(ouro);
		
		ouror.shape(" @ ", " @ ", " @ ");
		
		ouror.setIngredient('@', Material.GOLD_INGOT);
		
		plugin.getServer().addRecipe(ouror);
	}
}
