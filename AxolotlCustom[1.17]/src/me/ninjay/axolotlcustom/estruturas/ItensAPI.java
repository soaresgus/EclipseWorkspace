package me.ninjay.axolotlcustom.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.axolotlcustom.main.Main;
import me.ninjay.axolotlcustom.utils.Mine;


public class ItensAPI {
	
	public static ItemStack obsidian = Mine.newItem(Material.PURPLE_DYE, "§5Balde com Obsidian");
	public static ItemStack cobre = Mine.newItem(Material.CYAN_DYE, "§eBalde com Cobre");
	public static ItemStack redstone = Mine.newItem(Material.LIME_DYE, "§cBalde com Redstone");
	public static ItemStack ouro = Mine.newItem(Material.YELLOW_DYE, "§6Balde com Ouro");
	public static ItemStack diamante = Mine.newItem(Material.RED_DYE, "§bBalde com Diamante");
	
	public static ItemStack capaobsi() { 
		ItemStack item =
					Mine.newItem(Material.DIAMOND_HELMET, "§5Capacete de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	public static ItemStack peitoobsi() { 
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§5Peitoral de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	public static ItemStack calcaobsi() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_LEGGINGS, "§5Calca de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	public static ItemStack botaobsi() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_BOOTS, "§5Botas de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	
	public static ItemStack espadaobsi() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_SWORD, "§5Espada de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	public static ItemStack picaretaobsi() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_PICKAXE, "§5Picareta de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	public static ItemStack machadobsi() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_AXE, "§5Machado de Obsidian", 1, 0);
		Mine.addEnchant(item, Enchantment.DURABILITY, 10);
		return item;
	}
	
	public static ItemStack capacobre() { 
		ItemStack item =
					Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack peitocobre() { 
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack calcacobre() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalca de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack botacobre() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_BOOTS, "§eBotas de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	
	public static ItemStack espadacobre() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_SWORD, "§eEspada de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.DAMAGE_ALL, 5);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack picaretacobre() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_PICKAXE, "§ePicareta de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 3);
		Mine.addEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, 3);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack machadcobre() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_AXE, "§eMachado de Cobre", 1, 0);
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 3);
		Mine.addEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, 3);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	
	public static ItemStack pistao() {
		ItemStack item =
		Mine.newItem(Material.PISTON, "§dPistão Mágico", 1, 0, " ", " §7Use esse pistão para ser", " §7lançado às alturas!");
		Mine.addEnchant(item, Enchantment.DURABILITY, 1);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack capadima() { 
		ItemStack item =
					Mine.newItem(Material.DIAMOND_HELMET, null, 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack peitodima() { 
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, null, 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack calcadima() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_LEGGINGS, null, 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack botadima() { 
		ItemStack item =
		Mine.newItem(Material.DIAMOND_BOOTS, null, 1, 0);
		Mine.addEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	
	public static ItemStack espadadima() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_SWORD, null, 1, 0);
		Mine.addEnchant(item, Enchantment.DAMAGE_ALL, 5);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack picaretadima() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_PICKAXE, null, 1, 0);
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 3);
		Mine.addEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, 3);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	public static ItemStack machaddima() {
		ItemStack item =
		Mine.newItem(Material.DIAMOND_AXE, null, 1, 0);
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 3);
		Mine.addEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, 3);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe obsidianr = new ShapedRecipe(obsidian);
		
		obsidianr.shape("#", "@");
		
		obsidianr.setIngredient('@', Material.WATER_BUCKET);
		obsidianr.setIngredient('#', Material.OBSIDIAN);
		Main.getPlugin(Main.class).getServer().addRecipe(obsidianr);
		
		ShapedRecipe cobrer = new ShapedRecipe(cobre);
		
		cobrer.shape("#", "@");
		
		cobrer.setIngredient('@', Material.WATER_BUCKET);
		cobrer.setIngredient('#', Material.COPPER_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(cobrer);
		
		ShapedRecipe redstoner = new ShapedRecipe(redstone);
		
		redstoner.shape("#", "@");
		
		redstoner.setIngredient('@', Material.WATER_BUCKET);
		redstoner.setIngredient('#', Material.REDSTONE);
		Main.getPlugin(Main.class).getServer().addRecipe(redstoner);
		
		ShapedRecipe ouror = new ShapedRecipe(ouro);
		
		ouror.shape("#", "@");
		
		ouror.setIngredient('@', Material.WATER_BUCKET);
		ouror.setIngredient('#', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(ouror);
		
		ShapedRecipe diamanter = new ShapedRecipe(diamante);
		
		diamanter.shape("#", "@");
		
		diamanter.setIngredient('@', Material.WATER_BUCKET);
		diamanter.setIngredient('#', Material.DIAMOND);
		Main.getPlugin(Main.class).getServer().addRecipe(diamanter);
	}
	
}
