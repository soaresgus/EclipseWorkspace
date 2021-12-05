package me.ninjay.juntarminerios.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.juntarminerios.main.Main;
import me.ninjay.juntarminerios.utils.Mine;

public class ItensAPI {
	
	public static ItemStack feurob = Mine.newItem(Material.RED_CONCRETE, "§fBloco de §7Fe§6uro");
	public static ItemStack feuroi = Mine.newItem(Material.BRICK, "§fBarra de §7Fe§6uro");
	public static ItemStack diamourob = Mine.newItem(Material.BLUE_CONCRETE, "§fBloco de §bDiam§6ouro");
	public static ItemStack diamouroi = Mine.newItem(Material.NETHER_BRICK, "§fBarra de §bDiam§6ouro");
	public static ItemStack esmeldimab = Mine.newItem(Material.YELLOW_CONCRETE, "§fBloco de §aEsmel§bdima");
	public static ItemStack esmeldimai = Mine.newItem(Material.CHARCOAL, "§fBarra de §aEsmel§bdima");
	public static ItemStack netheraldab = Mine.newItem(Material.ORANGE_CONCRETE, "§fBloco de §8Nether§aalda");
	public static ItemStack netheraldai = Mine.newItem(Material.PRISMARINE_SHARD, "§fBarra de §8Nether§aalda");
	
	public static ItemStack feuropa() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SHOVEL, "§6Pa de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feuromachado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§6Machado de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feuropicareta() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Picareta de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feuroespada() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§6Espada de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feurocapacete() {
		ItemStack item = Mine.newItem(Material.DIAMOND_HELMET, "§6Capacete de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feuropeitoral() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§6Peitoral de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feurocalca() {
		ItemStack item = Mine.newItem(Material.DIAMOND_LEGGINGS, "§6Calcas de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack feurobotas() {
		ItemStack item = Mine.newItem(Material.DIAMOND_BOOTS, "§6Botas de Feuro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	//DIAMOURO
	
	public static ItemStack diamouropa() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SHOVEL, "§bPa de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamouromachado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§bMachado de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamouropicareta() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§bPicareta de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamouroespada() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§bEspada de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamourocapacete() {
		ItemStack item = Mine.newItem(Material.DIAMOND_HELMET, "§bCapacete de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamouropeitoral() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§bPeitoral de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamourocalca() {
		ItemStack item = Mine.newItem(Material.DIAMOND_LEGGINGS, "§bCalcas de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack diamourobotas() {
		ItemStack item = Mine.newItem(Material.DIAMOND_BOOTS, "§bBotas de Diamouro");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	//ESMELDIMA
	
	public static ItemStack esmeldimapa() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SHOVEL, "§aPa de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimamachado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§aMachado de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimapicareta() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§aPicareta de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimaespada() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§aEspada de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimacapacete() {
		ItemStack item = Mine.newItem(Material.DIAMOND_HELMET, "§aCapacete de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimapeitoral() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§aPeitoral de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimacalca() {
		ItemStack item = Mine.newItem(Material.DIAMOND_LEGGINGS, "§aCalcas de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack esmeldimabotas() {
		ItemStack item = Mine.newItem(Material.DIAMOND_BOOTS, "§aBotas de Esmeldima");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	//NETHERALDA
	
	public static ItemStack netheraldapa() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SHOVEL, "§4Pa de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldamachado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§4Machado de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldapicareta() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§4Picareta de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldaespada() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§4Espada de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldacapacete() {
		ItemStack item = Mine.newItem(Material.DIAMOND_HELMET, "§4Capacete de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldapeitoral() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§4Peitoral de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldacalca() {
		ItemStack item = Mine.newItem(Material.DIAMOND_LEGGINGS, "§4Calcas de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack netheraldabotas() {
		ItemStack item = Mine.newItem(Material.DIAMOND_BOOTS, "§4Botas de Netheralda", 1, 0, "§7Indestrutível");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		//meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe feuror = new ShapedRecipe(feurob);
		
		feuror.shape("@#@", "#@#", "@#@");
		
		feuror.setIngredient('@', Material.IRON_INGOT);
		feuror.setIngredient('#', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(feuror);
		
		ShapedRecipe diamouror = new ShapedRecipe(diamourob);
		
		diamouror.shape("@#@", "#@#", "@#@");
		
		diamouror.setIngredient('@', Material.GOLD_INGOT);
		diamouror.setIngredient('#', Material.DIAMOND);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouror);
		
		ShapedRecipe esmeldimar = new ShapedRecipe(esmeldimab);
		
		esmeldimar.shape("@#@", "#@#", "@#@");
		
		esmeldimar.setIngredient('@', Material.DIAMOND);
		esmeldimar.setIngredient('#', Material.EMERALD);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimar);
		
		ShapedRecipe netheralda = new ShapedRecipe(netheraldab);
		
		netheralda.shape("@#@", "#@#", "@#@");
		
		netheralda.setIngredient('@', Material.EMERALD);
		netheralda.setIngredient('#', Material.NETHERITE_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(netheralda);
		
		//FEURO
		
		ShapedRecipe feuropar = new ShapedRecipe(feuropa());
		
		feuropar.shape("@", "#", "#");
		
		feuropar.setIngredient('@', Material.BRICK);
		feuropar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feuropar);
		
		ShapedRecipe feuroaxer = new ShapedRecipe(feuromachado());
		
		feuroaxer.shape("@@ ", "@# ", " # ");
		
		feuroaxer.setIngredient('@', Material.BRICK);
		feuroaxer.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feuroaxer);
		
		ShapedRecipe feuropicr = new ShapedRecipe(feuropicareta());
		
		feuropicr.shape("@@@", " # ", " # ");
		
		feuropicr.setIngredient('@', Material.BRICK);
		feuropicr.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feuropicr);
		
		ShapedRecipe feuroespadar = new ShapedRecipe(feuroespada());
		
		feuroespadar.shape("@", "@", "#");
		
		feuroespadar.setIngredient('@', Material.BRICK);
		feuroespadar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feuroespadar);
		
		ShapedRecipe feurocapar = new ShapedRecipe(feurocapacete());
		
		feurocapar.shape("@@@", "@ @");
		
		feurocapar.setIngredient('@', Material.BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feurocapar);
		
		ShapedRecipe feuropeitor = new ShapedRecipe(feuropeitoral());
		
		feuropeitor.shape("@ @", "@@@", "@@@");
		
		feuropeitor.setIngredient('@', Material.BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feuropeitor);
		
		ShapedRecipe feurocalcar = new ShapedRecipe(feurocalca());
		
		feurocalcar.shape("@@@", "@ @", "@ @");
		
		feurocalcar.setIngredient('@', Material.BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feurocalcar);
		
		ShapedRecipe feurobotasr = new ShapedRecipe(feurobotas());
		
		feurobotasr.shape("@ @", "@ @");
		
		feurobotasr.setIngredient('@', Material.BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(feurobotasr);
		
		//DIAMOURO
		
		ShapedRecipe diamouropar = new ShapedRecipe(diamouropa());
		
		diamouropar.shape("@", "#", "#");
		
		diamouropar.setIngredient('@', Material.NETHER_BRICK);
		diamouropar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouropar);
		
		ShapedRecipe diamouroaxer = new ShapedRecipe(diamouromachado());
		
		diamouroaxer.shape("@@ ", "@# ", " # ");
		
		diamouroaxer.setIngredient('@', Material.NETHER_BRICK);
		diamouroaxer.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouroaxer);
		
		ShapedRecipe diamouropicr = new ShapedRecipe(diamouropicareta());
		
		diamouropicr.shape("@@@", " # ", " # ");
		
		diamouropicr.setIngredient('@', Material.NETHER_BRICK);
		diamouropicr.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouropicr);
		
		ShapedRecipe diamouroespadar = new ShapedRecipe(diamouroespada());
		
		diamouroespadar.shape("@", "@", "#");
		
		diamouroespadar.setIngredient('@', Material.NETHER_BRICK);
		diamouroespadar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouroespadar);
		
		ShapedRecipe diamourocapar = new ShapedRecipe(diamourocapacete());
		
		diamourocapar.shape("@@@", "@ @");
		
		diamourocapar.setIngredient('@', Material.NETHER_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamourocapar);
		
		ShapedRecipe diamouropeitor = new ShapedRecipe(diamouropeitoral());
		
		diamouropeitor.shape("@ @", "@@@", "@@@");
		
		diamouropeitor.setIngredient('@', Material.NETHER_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamouropeitor);
		
		ShapedRecipe diamourocalcar = new ShapedRecipe(diamourocalca());
		
		diamourocalcar.shape("@@@", "@ @", "@ @");
		
		diamourocalcar.setIngredient('@', Material.NETHER_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamourocalcar);
		
		ShapedRecipe diamourobotasr = new ShapedRecipe(diamourobotas());
		
		diamourobotasr.shape("@ @", "@ @");
		
		diamourobotasr.setIngredient('@', Material.NETHER_BRICK);
		Main.getPlugin(Main.class).getServer().addRecipe(diamourobotasr);
		
		//ESMELDIMA
		
		
		ShapedRecipe esmeldimapar = new ShapedRecipe(esmeldimapa());
		
		esmeldimapar.shape("@", "#", "#");
		
		esmeldimapar.setIngredient('@', Material.CHARCOAL);
		esmeldimapar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimapar);
		
		ShapedRecipe esmeldimaaxer = new ShapedRecipe(esmeldimamachado());
		
		esmeldimaaxer.shape("@@ ", "@# ", " # ");
		
		esmeldimaaxer.setIngredient('@', Material.CHARCOAL);
		esmeldimaaxer.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimaaxer);
		
		ShapedRecipe esmeldimapicr = new ShapedRecipe(esmeldimapicareta());
		
		esmeldimapicr.shape("@@@", " # ", " # ");
		
		esmeldimapicr.setIngredient('@', Material.CHARCOAL);
		esmeldimapicr.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimapicr);
		
		ShapedRecipe esmeldimaespadar = new ShapedRecipe(esmeldimaespada());
		
		esmeldimaespadar.shape("@", "@", "#");
		
		esmeldimaespadar.setIngredient('@', Material.CHARCOAL);
		esmeldimaespadar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimaespadar);
		
		ShapedRecipe esmeldimacapar = new ShapedRecipe(esmeldimacapacete());
		
		esmeldimacapar.shape("@@@", "@ @");
		
		esmeldimacapar.setIngredient('@', Material.CHARCOAL);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimacapar);
		
		ShapedRecipe esmeldimapeitor = new ShapedRecipe(esmeldimapeitoral());
		
		esmeldimapeitor.shape("@ @", "@@@", "@@@");
		
		esmeldimapeitor.setIngredient('@', Material.CHARCOAL);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimapeitor);
		
		ShapedRecipe esmeldimacalcar = new ShapedRecipe(esmeldimacalca());
		
		esmeldimacalcar.shape("@@@", "@ @", "@ @");
		
		esmeldimacalcar.setIngredient('@', Material.CHARCOAL);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimacalcar);
		
		ShapedRecipe esmeldimabotasr = new ShapedRecipe(esmeldimabotas());
		
		esmeldimabotasr.shape("@ @", "@ @");
		
		esmeldimabotasr.setIngredient('@', Material.CHARCOAL);
		Main.getPlugin(Main.class).getServer().addRecipe(esmeldimabotasr);
		
		//NETHERALDA
		
		ShapedRecipe netheraldapar = new ShapedRecipe(netheraldapa());
		
		netheraldapar.shape("@", "#", "#");
		
		netheraldapar.setIngredient('@', Material.PRISMARINE_SHARD);
		netheraldapar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldapar);
		
		ShapedRecipe netheraldaaxer = new ShapedRecipe(netheraldamachado());
		
		netheraldaaxer.shape("@@ ", "@# ", " # ");
		
		netheraldaaxer.setIngredient('@', Material.PRISMARINE_SHARD);
		netheraldaaxer.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldaaxer);
		
		ShapedRecipe netheraldapicr = new ShapedRecipe(netheraldapicareta());
		
		netheraldapicr.shape("@@@", " # ", " # ");
		
		netheraldapicr.setIngredient('@', Material.PRISMARINE_SHARD);
		netheraldapicr.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldapicr);
		
		ShapedRecipe netheraldaespadar = new ShapedRecipe(netheraldaespada());
		
		netheraldaespadar.shape("@", "@", "#");
		
		netheraldaespadar.setIngredient('@', Material.PRISMARINE_SHARD);
		netheraldaespadar.setIngredient('#', Material.STICK);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldaespadar);
		
		ShapedRecipe netheraldacapar = new ShapedRecipe(netheraldacapacete());
		
		netheraldacapar.shape("@@@", "@ @");
		
		netheraldacapar.setIngredient('@', Material.PRISMARINE_SHARD);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldacapar);
		
		ShapedRecipe netheraldapeitor = new ShapedRecipe(netheraldapeitoral());
		
		netheraldapeitor.shape("@ @", "@@@", "@@@");
		
		netheraldapeitor.setIngredient('@', Material.PRISMARINE_SHARD);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldapeitor);
		
		ShapedRecipe netheraldacalcar = new ShapedRecipe(netheraldacalca());
		
		netheraldacalcar.shape("@@@", "@ @", "@ @");
		
		netheraldacalcar.setIngredient('@', Material.PRISMARINE_SHARD);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldacalcar);
		
		ShapedRecipe netheraldabotasr = new ShapedRecipe(netheraldabotas());
		
		netheraldabotasr.shape("@ @", "@ @");
		
		netheraldabotasr.setIngredient('@', Material.PRISMARINE_SHARD);
		Main.getPlugin(Main.class).getServer().addRecipe(netheraldabotasr);
		
	}
	
}
