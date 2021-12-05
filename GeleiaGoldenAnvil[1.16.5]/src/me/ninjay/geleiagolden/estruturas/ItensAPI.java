package me.ninjay.geleiagolden.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.geleiagolden.main.Main;
import me.ninjay.geleiagolden.utils.Mine;

public class ItensAPI {
	
	public static ItemStack bigorna = Mine.newItem(Material.ANVIL, "§6Bigorna de Ouro", 1, 0, " ", "  §7Pelos poderes de Odin... Digo, Loki.");
	public static ItemStack cajado = Mine.newItem(Material.DIAMOND_HOE, "§5Cajado do Fim", 1, 0, " ", "  §7Thanos teria inveja dessa joia.");
	public static ItemStack espadareta() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§5EspadaReta", 1, 0, " ", "  §7Você não poderia simplesmente", "  §7continuar carregando duas ferramentas?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack capacete = Mine.newItem(Material.IRON_HELMET, "§6Capacete de Pena", 1, 0, " ", "  §7Sério isso cara?");
	public static ItemStack peitoral = Mine.newItem(Material.IRON_CHESTPLATE, "§6Peitoral de Maça Dourada", 1, 0, " ", "  §7Minecraft já não é mais o mesmo, James.");
	public static ItemStack calcas = Mine.newItem(Material.IRON_LEGGINGS, "§6Calças de Fogo", 1, 0, " ", "  §7Imagino que não será uma boa ideia vestir isso...");
	public static ItemStack botas = Mine.newItem(Material.IRON_BOOTS, "§6Botas de Escada", 1, 0, " ", "  §7Ok, vou mandar um email ao Notch...");
	public static ItemStack shuriken() {
		ItemStack item =Mine.newItem(Material.SNOWBALL, "§9Shuriken de Diamante", 1, 0, " ", "  §7@-@ oni... oni-chan?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 50, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
		
	}
	public static ItemStack chuva = Mine.newItem(Material.STONE_HOE, "§9Chuva de Flechas", 1, 0, " ", "  §7O título deveria ser:", "  §7minecraft, mas nada faz sentido...");
	public static ItemStack corrente = Mine.newItem(Material.CHAIN, "§aCorrente de Espinhos", 1, 0, " ", "  §7Gostei, essa eu gostei...");
	public static ItemStack picareta() {
		ItemStack item = Mine.newItem(Material.GOLDEN_PICKAXE, "§6Picareta Totem", 1, 0, " ", "  §7Você realmente gastou um totem com isso?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado = Mine.newItem(Material.IRON_AXE, "§6Machado de Pólvora", 1, 0, " ", "  §7Alô? Eu gostaria de fazer uma denúncia, tem um maluco...");
	
	public static void recipe() {
		ShapedRecipe bigornar = new ShapedRecipe(bigorna);
		bigornar.shape("###", " @ ", "@@@");
		bigornar.setIngredient('#', Material.GOLD_BLOCK);
		bigornar.setIngredient('@', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(bigornar);
	
		ShapedRecipe magenta = new ShapedRecipe(new ItemStack(Material.MAGENTA_DYE));
		magenta.shape(" # ", " @ ", " # ");
		magenta.setIngredient('#', Material.IRON_NUGGET);
		magenta.setIngredient('@', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(magenta);
		
	}

}
