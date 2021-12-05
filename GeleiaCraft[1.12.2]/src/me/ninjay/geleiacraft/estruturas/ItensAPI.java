package me.ninjay.geleiacraft.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.geleiacraft.main.Main;
import me.ninjay.geleiacraft.utils.Mine;

public class ItensAPI {
	
	public static ItemStack multi = Mine.newItem(Material.OBSERVER, "§eMultiplicadora", 1, 0, " ", "  §7Multiplica qualquer item do minecraft!");
	public static ItemStack woodpic = Mine.newItem(Material.WOOD_PICKAXE, "§dWooden Pick Pick Pick", 1, 0, " ", "  §7Uma picareta é para os fracos, vamos usar três!");
	public static ItemStack stonepic = Mine.newItem(Material.STONE_PICKAXE, "§dStone Pick Pick Pick", 1, 0, " ", "  §7Ok, você já entendeu que isso não faz sentido algum...");
	public static ItemStack ironpic = Mine.newItem(Material.IRON_PICKAXE, "§dIron Pick Pick Pick", 1, 0, " ", "  §7Era melhor ter feito 3 baldes...");
	public static ItemStack dimapic() { 
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Diamond Pick Pick Pick", 1, 0, " ", "  §7Chega de amadorismo, vamos quebrar o minecraft!");
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 5);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return item;
	}
	
	public static ItemStack dimaaxe() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§6Diamond Axe Axe Axe", 1, 0, " ", "  §7O Thor o invejaria agora!");
		Mine.addEnchant(item, Enchantment.DIG_SPEED, 5);
		Mine.addEnchant(item, Enchantment.DURABILITY, 3);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return item;
	}
	public static ItemStack bowbow(){ 
		ItemStack item =Mine.newItem(Material.BOW, "§6Bow Bow Bow", 1, 0, " ", "  §7Deveria ter oferecido um destes ao RobinWood.");
		Mine.addEnchant(item, Enchantment.ARROW_DAMAGE, 3);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return item;
	}
	
	public static ItemStack dimaespada(){ 
		ItemStack item =Mine.newItem(Material.DIAMOND_SWORD, "§6Diamond Sword Sword Sword", 1, 0, " ", "  §7OK, talvez estejamos indo longe demais com isso...");
		Mine.addEnchant(item, Enchantment.DAMAGE_ALL, 10);
		Mine.addEnchant(item, Enchantment.FIRE_ASPECT, 2);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return item;
	}
	
	public static ItemStack dimaespadaespada = Mine.newItem(Material.DIAMOND_SWORD, "§6Diamond Sword Sword Sword Sword Sword", 1, 0, " ", "  §7Definitivamente fomos longe demais!");
	public static ItemStack diamond = Mine.newItem(Material.DIAMOND, "§6Diamond Diamond Diamond", 1, 0, " ", "  §7É apenas um diamante.");
	public static ItemStack flint = Mine.newItem(Material.FLINT_AND_STEEL, "§6Flint And Steel Steel Steel", 1, 0, " ", "  §7Flash... Sempre fazendo besteira na linha do tempo.");
	public static ItemStack escudo = Mine.newItem(Material.SHIELD, "§6Escudo de Espadas", 1, 0, " ", "  §7Melhor não chegar perto...");
	
	public void customRecipe() {
		ShapedRecipe multir = new ShapedRecipe(multi);
		
		multir.shape("@@@", "@@@", "@@@");
		
		multir.setIngredient('@', Material.WORKBENCH);
		
		Main.getPlugin(Main.class).getServer().addRecipe(multir);
	}
}
