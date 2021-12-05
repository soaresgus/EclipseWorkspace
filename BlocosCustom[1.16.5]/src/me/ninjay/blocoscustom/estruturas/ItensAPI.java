package me.ninjay.blocoscustom.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.blocoscustom.main.Main;
import me.ninjay.blocoscustom.utils.Mine;


public class ItensAPI {
	
	public static ItemStack terra() {
		ItemStack item = Mine.newItem(Material.WHITE_CONCRETE, "§dBloco de Terra");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pedra() {
		ItemStack item = Mine.newItem(Material.ORANGE_CONCRETE, "§dBloco de Pedregulho");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack areia() {
		ItemStack item = Mine.newItem(Material.MAGENTA_CONCRETE, "§dBloco de Areia");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack obsidian() {
		ItemStack item = Mine.newItem(Material.LIGHT_BLUE_CONCRETE, "§dBloco de Obsidian");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack netherack() {
		ItemStack item = Mine.newItem(Material.YELLOW_CONCRETE, "§dBloco de Netherack");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack tnt() {
		ItemStack item = Mine.newItem(Material.LIME_CONCRETE, "§dBloco de TnT");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack feno() {
		ItemStack item = Mine.newItem(Material.PINK_CONCRETE, "§dBloco de Feno");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pao() {
		ItemStack item = Mine.newItem(Material.GRAY_CONCRETE, "§dBloco de Pao");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack golden() {
		ItemStack item = Mine.newItem(Material.LIGHT_GRAY_CONCRETE, "§dBloco de Maca Dourada");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack cenoura() {
		ItemStack item = Mine.newItem(Material.CYAN_CONCRETE, "§dBloco de Cenoura");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack lava() {
		ItemStack item = Mine.newItem(Material.PURPLE_CONCRETE, "§dBloco de Lava");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack agua() {
		ItemStack item = Mine.newItem(Material.BLUE_CONCRETE, "§dBloco de Agua");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada() {
		ItemStack item = Mine.newItem(Material.BROWN_CONCRETE, "§dBloco de Espada");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack arco() {
		ItemStack item = Mine.newItem(Material.GREEN_CONCRETE, "§dBloco de Arco");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack carvao() {
		ItemStack item = Mine.newItem(Material.RED_CONCRETE, "§dBloco de Carvao");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack ferro() {
		ItemStack item = Mine.newItem(Material.BLACK_CONCRETE, "§dBloco de Ferro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack ouro() {
		ItemStack item = Mine.newItem(Material.WHITE_CONCRETE_POWDER, "§dBloco de Ouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack diamante() {
		ItemStack item = Mine.newItem(Material.ORANGE_CONCRETE_POWDER, "§dBloco de Diamante");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe terrar = new ShapedRecipe(terra());
		
		terrar.shape("@@@", "@@@", "@@@");
		
		terrar.setIngredient('@', Material.DIRT);
		Main.getPlugin(Main.class).getServer().addRecipe(terrar);
		
		ShapedRecipe pedrar = new ShapedRecipe(pedra());
		
		pedrar.shape("@@@", "@@@", "@@@");
		
		pedrar.setIngredient('@', Material.COBBLESTONE);
		Main.getPlugin(Main.class).getServer().addRecipe(pedrar);
		
		ShapedRecipe areiar = new ShapedRecipe(areia());
		
		areiar.shape("@@@", "@@@", "@@@");
		
		areiar.setIngredient('@', Material.SAND);
		Main.getPlugin(Main.class).getServer().addRecipe(areiar);
		
		ShapedRecipe obsir = new ShapedRecipe(obsidian());
		
		obsir.shape("@@@", "@@@", "@@@");
		
		obsir.setIngredient('@', Material.OBSIDIAN);
		Main.getPlugin(Main.class).getServer().addRecipe(obsir);
		
		ShapedRecipe nether = new ShapedRecipe(netherack());
		
		nether.shape("@@@", "@@@", "@@@");
		
		nether.setIngredient('@', Material.NETHERRACK);
		Main.getPlugin(Main.class).getServer().addRecipe(nether);
		
		ShapedRecipe tntr = new ShapedRecipe(tnt());
		
		tntr.shape("@@@", "@@@", "@@@");
		
		tntr.setIngredient('@', Material.TNT);
		Main.getPlugin(Main.class).getServer().addRecipe(tntr);
		
		ShapedRecipe fenor = new ShapedRecipe(feno());
		
		fenor.shape("@@@", "@@@", "@@@");
		
		fenor.setIngredient('@', Material.HAY_BLOCK);
		Main.getPlugin(Main.class).getServer().addRecipe(fenor);
		
		ShapedRecipe paor = new ShapedRecipe(pao());
		
		paor.shape("@@@", "@@@", "@@@");
		
		paor.setIngredient('@', Material.BREAD);
		Main.getPlugin(Main.class).getServer().addRecipe(paor);
		
		ShapedRecipe goldenr = new ShapedRecipe(golden());
		
		goldenr.shape("@@@", "@@@", "@@@");
		
		goldenr.setIngredient('@', Material.GOLDEN_APPLE);
		Main.getPlugin(Main.class).getServer().addRecipe(goldenr);
		
		ShapedRecipe cenourar = new ShapedRecipe(cenoura());
		
		cenourar.shape("@@@", "@@@", "@@@");
		
		cenourar.setIngredient('@', Material.CARROT);
		Main.getPlugin(Main.class).getServer().addRecipe(cenourar);
		
		ShapedRecipe lavar = new ShapedRecipe(lava());
		
		lavar.shape("@@@", "@@@", "@@@");
		
		lavar.setIngredient('@', Material.LAVA_BUCKET);
		Main.getPlugin(Main.class).getServer().addRecipe(lavar);
		
		ShapedRecipe aguar = new ShapedRecipe(agua());
		
		aguar.shape("@@@", "@@@", "@@@");
		
		aguar.setIngredient('@', Material.WATER_BUCKET);
		Main.getPlugin(Main.class).getServer().addRecipe(aguar);
		
		ShapedRecipe arcor = new ShapedRecipe(arco());
		
		arcor.shape("@@@", "@@@", "@@@");
		
		arcor.setIngredient('@', Material.BOW);
		Main.getPlugin(Main.class).getServer().addRecipe(arcor);
		
		ShapedRecipe carvaor = new ShapedRecipe(carvao());
		
		carvaor.shape("@@@", "@@@", "@@@");
		
		carvaor.setIngredient('@', Material.COAL_BLOCK);
		Main.getPlugin(Main.class).getServer().addRecipe(carvaor);
		
		ShapedRecipe ferror = new ShapedRecipe(ferro());
		
		ferror.shape("@@@", "@ @", "@@@");
		
		ferror.setIngredient('@', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(ferror);
		
		ShapedRecipe ouror = new ShapedRecipe(ouro());
		
		ouror.shape("@@@", "@ @", "@@@");
		
		ouror.setIngredient('@', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(ouror);
		
		ShapedRecipe dimar = new ShapedRecipe(diamante());
		
		dimar.shape("@@@", "@ @", "@@@");
		
		dimar.setIngredient('@', Material.DIAMOND);
		Main.getPlugin(Main.class).getServer().addRecipe(dimar);
		
		ShapedRecipe espadar = new ShapedRecipe(espada());
		
		espadar.shape("@#@", "#$#", "@#@");
		
		espadar.setIngredient('@', Material.STONE_SWORD);
		espadar.setIngredient('#', Material.GOLDEN_SWORD);
		espadar.setIngredient('$', Material.DIAMOND_SWORD);
		Main.getPlugin(Main.class).getServer().addRecipe(espadar);
	}
	
	
	
}
