package me.ninjay.minguadocriativo.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.minguadocriativo.main.Main;
import me.ninjay.minguadocriativo.utils.Mine;

public class ItensAPI {
	
	public static ItemStack comando() {
		ItemStack item = Mine.newItem(Material.YELLOW_CONCRETE, "§eBloco de Comando", 1, 0, " ", "  §7Error404");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack fragmento() {
		ItemStack item = Mine.newItem(Material.PAPER, "§dFragmento de Modo Criativo", 1, 0, " ", "  §7Processando...");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack mesa() {
		ItemStack item = Mine.newItem(Material.ORANGE_CONCRETE, "§bMesa de Trabalho Criativa", 1, 0, " ", "  §7Use esta incrível mesa de trabalho para", "  §7criar os itens mais criativos do minecraft!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Picareta Criativa", 1, 0, " ", "  §7Nível de raridade: §4EXTREMO!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada() {
		ItemStack item = Mine.newItem(Material.NETHERITE_SWORD, "§5Espada Criativa", 1, 0, " ", "  §7Nível de raridade: §4EXTREMO!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe comandor = new ShapedRecipe(comando());
		
		comandor.shape(" @ ", "@#@", " @ ");
		
		comandor.setIngredient('@', Material.COPPER_INGOT);
		comandor.setIngredient('#', Material.REDSTONE);
		Main.getPlugin(Main.class).getServer().addRecipe(comandor);
		
		ShapedRecipe fragmentor = new ShapedRecipe(fragmento());
		
		fragmentor.shape(" @ ", "@#@", " @ ");
		
		fragmentor.setIngredient('@', Material.YELLOW_CONCRETE);
		fragmentor.setIngredient('#', Material.REDSTONE);
		Main.getPlugin(Main.class).getServer().addRecipe(fragmentor);
		
		ShapedRecipe mesar = new ShapedRecipe(mesa());
		
		mesar.shape("@@", "@@");
		
		mesar.setIngredient('@', Material.PAPER);
		Main.getPlugin(Main.class).getServer().addRecipe(mesar);
		
		ShapedRecipe picaretar = new ShapedRecipe(picareta());
		
		picaretar.shape("@@@", " # ", " # ");
		
		picaretar.setIngredient('@', Material.PAPER);
		picaretar.setIngredient('#', Material.YELLOW_CONCRETE);
		Main.getPlugin(Main.class).getServer().addRecipe(picaretar);
		
		ShapedRecipe espadar = new ShapedRecipe(espada());
		
		espadar.shape("@", "@", "#");
		
		espadar.setIngredient('@', Material.PAPER);
		espadar.setIngredient('#', Material.YELLOW_CONCRETE);
		Main.getPlugin(Main.class).getServer().addRecipe(espadar);
		
		
	}
	
}
