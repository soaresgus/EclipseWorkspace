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
	public static ItemStack moon = Mine.newItem(Material.GOLD_PICKAXE, "§ePicareta da Moonkase");
	public static ItemStack lua = Mine.newItem(Material.IRON_PICKAXE, "§9Picareta da Lua");
	public static ItemStack jeredy = Mine.newItem(Material.STONE_PICKAXE, "§1Picareta do Jeredy");
	public static ItemStack robin = Mine.newItem(Material.WOOD_PICKAXE, "§2Picareta do RobinHood");
	public static ItemStack tazer = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Picareta do TazerCraft");
	
	public static ItemStack tnt = Mine.newItem(Material.STICK, "§cGraveto de TnT");
	public static ItemStack lapis = Mine.newItem(Material.STICK, "§9Graveto de Lapis");
	public static ItemStack pedra = Mine.newItem(Material.STICK, "§7Graveto de Pedra");
	public static ItemStack ouro = Mine.newItem(Material.STICK, "§6Graveto de Ouro");
	
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
		minguador.setIngredient('#', Material.SKULL_ITEM, 3);
		minguador.setIngredient('$', Material.STICK);
		minguador.setIngredient('%', Material.TNT);
		
		plugin.getServer().addRecipe(minguador);
		
		ShapedRecipe moonr = new ShapedRecipe(moon);
		
		moonr.shape("!@#", " $@", "$ !");
		
		moonr.setIngredient('!', Material.GOLD_INGOT);
		moonr.setIngredient('@', Material.QUARTZ_BLOCK);
		moonr.setIngredient('#', Material.SKULL_ITEM, 3);
		moonr.setIngredient('$', Material.STICK);
		
		plugin.getServer().addRecipe(moonr);
		
		ShapedRecipe luar = new ShapedRecipe(lua);
		
		luar.shape("!@#", " $@", "$ !");
		
		luar.setIngredient('!', Material.INK_SACK, 6);
		luar.setIngredient('@', Material.SMOOTH_BRICK);
		luar.setIngredient('#', Material.SKULL_ITEM, 3);
		luar.setIngredient('$', Material.STICK);
		
		plugin.getServer().addRecipe(luar);
		
		ShapedRecipe jeredyr = new ShapedRecipe(jeredy);
		
		jeredyr.shape("!@#", " $@", "$ !");
		
		jeredyr.setIngredient('!', Material.WATCH);
		jeredyr.setIngredient('@', Material.BED, 3);
		jeredyr.setIngredient('#', Material.SKULL_ITEM, 3);
		jeredyr.setIngredient('$', Material.STICK);
		
		plugin.getServer().addRecipe(jeredyr);
		
		ShapedRecipe robinr = new ShapedRecipe(robin);
		
		robinr.shape("!@#", " $@", "% !");
		
		robinr.setIngredient('!', Material.STRING);
		robinr.setIngredient('@', Material.WOOD);
		robinr.setIngredient('#', Material.SKULL_ITEM, 3);
		robinr.setIngredient('$', Material.ARROW);
		robinr.setIngredient('%', Material.LOG);
		
		plugin.getServer().addRecipe(robinr);
		
		ShapedRecipe tazerr = new ShapedRecipe(tazer);
		
		tazerr.shape("!#%", " $#", "$ @");
		
		tazerr.setIngredient('!', Material.EMERALD_BLOCK);
		tazerr.setIngredient('@', Material.DIAMOND_BLOCK);
		tazerr.setIngredient('#', Material.SKULL_ITEM, 3);
		tazerr.setIngredient('$', Material.STICK);
		tazerr.setIngredient('%', Material.GOLDEN_APPLE, 1);
		
		plugin.getServer().addRecipe(tazerr);
		
		ShapedRecipe tntr = new ShapedRecipe(tnt);
		
		tntr.shape(" @ ", " ! ", " @ ");
		
		tntr.setIngredient('!', Material.INK_SACK, 1);
		tntr.setIngredient('@', Material.TNT);
		
		plugin.getServer().addRecipe(tntr);
		
		ShapedRecipe lapisr = new ShapedRecipe(lapis);
		
		lapisr.shape(" @ ", " ! ", " @ ");
		
		lapisr.setIngredient('!', Material.INK_SACK, 4);
		lapisr.setIngredient('@', Material.LAPIS_BLOCK);
		
		plugin.getServer().addRecipe(lapisr);
		
		ShapedRecipe stoner = new ShapedRecipe(pedra);
		
		stoner.shape(" @ ", " @ ", " @ ");
		
		stoner.setIngredient('@', Material.SMOOTH_BRICK);
		
		plugin.getServer().addRecipe(stoner);
		
		ShapedRecipe ouror = new ShapedRecipe(ouro);
		
		ouror.shape(" @ ", " @ ", " @ ");
		
		ouror.setIngredient('@', Material.GOLD_INGOT);
		
		plugin.getServer().addRecipe(ouror);
	}
}
