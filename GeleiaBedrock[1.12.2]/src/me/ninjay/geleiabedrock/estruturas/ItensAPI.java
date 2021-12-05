package me.ninjay.geleiabedrock.estruturas;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.geleiabedrock.main.Main;
import me.ninjay.geleiabedrock.utils.Mine;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;

public class ItensAPI {
	
	public static ItemStack addGlow(ItemStack item){
        net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }
	
	public static ItemStack fragmento() {
		ItemStack item = Mine.newItem(Material.CLAY_BALL, "§dFragmento de Bedrock", 1, 0, " ", "  §7Como... Como você fez isso?");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		item = addGlow(item);
		return item;
	}
	public static ItemStack barras() { 
		ItemStack item = Mine.newItem(Material.CLAY_BRICK, "§dBarra de Bedrock", 1, 0, " ", "  §7Use essa barra para fazer itens imagináveis!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		item = addGlow(item);
		return item;
	}
	public static ItemStack espada() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§dEspada de Bedrock", 1, 0, "§7Afiação 30", "§7Indestrutível", " ", "  §7Por mais que eu ande pelo vale das sombras...");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 30, true);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack picareta() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§dPicareta de Bedrock", 1, 0, "§7Indestrutível", " ", "  §7Quebre tudo e todos!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack machado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§dMachado de Bedrock", 1, 0, "§7Indestrutível", " ", "  §7Madeiraaaaa!!!");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack arco() {
		ItemStack item = Mine.newItem(Material.BOW, "§dArco de Bedrock", 1, 0, "§7Infinidade", "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack ender() {
		ItemStack item = Mine.newItem(Material.ENDER_PEARL, "§dEnderpearl de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack flint() {
		ItemStack item = Mine.newItem(Material.FLINT_AND_STEEL, "§dIsqueiro de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack tnt() {
		ItemStack item = Mine.newItem(Material.TNT, "§dTnT de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack balde() {
		ItemStack item = Mine.newItem(Material.MILK_BUCKET, "§dBalde de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack golem() {
		ItemStack item = Mine.newItem(Material.MONSTER_EGG, "§dSpawn Bedrock Golem", 1, 65, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack capa() {
		ItemStack item = Mine.newItem(Material.DIAMOND_HELMET, "§dCapacete de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack peito() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§dPeitoral de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack calca() {
		ItemStack item = Mine.newItem(Material.DIAMOND_LEGGINGS, "§dCalcas de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack bota() {
		ItemStack item = Mine.newItem(Material.DIAMOND_BOOTS, "§dBotas de Bedrock", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe espadar = new ShapedRecipe(espada());
		
		espadar.shape(" @ ", " @ ", " # ");
		
		espadar.setIngredient('@', Material.CLAY_BRICK);
		espadar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(espadar);
		
		ShapedRecipe picaretar = new ShapedRecipe(picareta());
		
		picaretar.shape("@@@", " # ", " # ");
		
		picaretar.setIngredient('@', Material.CLAY_BRICK);
		picaretar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(picaretar);
		
		ShapedRecipe machador = new ShapedRecipe(machado());
		
		machador.shape("@@ ", "@# ", " # ");
		
		machador.setIngredient('@', Material.CLAY_BRICK);
		machador.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(machador);
		
		ShapedRecipe arcor = new ShapedRecipe(arco());
		
		arcor.shape("#@ ", "# @", "#@ ");
		
		arcor.setIngredient('@', Material.CLAY_BRICK);
		arcor.setIngredient('#', Material.STRING);
		Main.getPlugin(Main.class).getServer().addRecipe(arcor);
		
		ShapedRecipe enderr = new ShapedRecipe(ender());
		
		enderr.shape("@@@", "@#@", "@@@");
		
		enderr.setIngredient('@', Material.CLAY_BRICK);
		enderr.setIngredient('#', Material.ENDER_PEARL);
		Main.getPlugin(Main.class).getServer().addRecipe(enderr);
		
		ShapedRecipe flintr = new ShapedRecipe(flint());
		
		flintr.shape("  #", " @ ");
		
		flintr.setIngredient('@', Material.CLAY_BRICK);
		flintr.setIngredient('#', Material.FLINT);
		Main.getPlugin(Main.class).getServer().addRecipe(flintr);
		
		ShapedRecipe tntr = new ShapedRecipe(tnt());
		
		tntr.shape("#@#", "@#@", "#@#");
		
		tntr.setIngredient('@', Material.CLAY_BRICK);
		tntr.setIngredient('#', Material.SULPHUR);
		Main.getPlugin(Main.class).getServer().addRecipe(tntr);
		
		ShapedRecipe balder = new ShapedRecipe(balde());
		
		balder.shape("@#@", " @ ");
		
		balder.setIngredient('@', Material.CLAY_BRICK);
		balder.setIngredient('#', Material.WATER_BUCKET);
		Main.getPlugin(Main.class).getServer().addRecipe(balder);
		
		ShapedRecipe golemr = new ShapedRecipe(golem());
		
		golemr.shape("@$@", "@#@", "@@@");
		
		golemr.setIngredient('@', Material.CLAY_BRICK);
		golemr.setIngredient('#', Material.EGG);
		golemr.setIngredient('$', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(golemr);
		
		ShapedRecipe capar = new ShapedRecipe(capa());
		
		capar.shape("@@@", "@ @");
		
		capar.setIngredient('@', Material.CLAY_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(capar);
		
		ShapedRecipe peitor = new ShapedRecipe(peito());
		
		peitor.shape("@ @", "@@@", "@@@");
		
		peitor.setIngredient('@', Material.CLAY_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(peitor);
		
		ShapedRecipe calcar = new ShapedRecipe(calca());
		
		calcar.shape("@@@", "@ @", "@ @");
		
		calcar.setIngredient('@', Material.CLAY_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(calcar);
		
		ShapedRecipe botar = new ShapedRecipe(bota());
		
		botar.shape("@ @", "@ @");
		
		botar.setIngredient('@', Material.CLAY_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(botar);
	}
	
}
