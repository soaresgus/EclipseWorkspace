package me.ninjay.fashmining.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.fashmining.utils.Mine;

public class ItemAPI {

	public static ItemStack ferro = Mine.newItem(Material.IRON_INGOT, "§aFerros", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack coal = Mine.newItem(Material.COAL, "§aCarvões", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack red = Mine.newItem(Material.REDSTONE, "§aRedstones", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack ouro = Mine.newItem(Material.GOLD_INGOT, "§aOuros", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack diamante = Mine.newItem(Material.DIAMOND, "§aDiamantes", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack lapis = Mine.newItem(Material.INK_SACK, "§aLapis", 1, 4, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");
	
	public static ItemStack emerald = Mine.newItem(Material.EMERALD, "§aEsmeralda", 1, 0, " ", " §7Quantidade: x",
			" ", " §fBotão esquerdo: §7Coletar tudo.");

}
