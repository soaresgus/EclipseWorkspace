package me.ninjay.gravetoscustom.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.gravetoscustom.main.Main;
import me.ninjay.gravetoscustom.utils.Mine;

public class ItensAPI {
	
	/*public static ItemStack bigorna = Mine.newItem(Material.ANVIL, "§6Bigorna de Ouro", 1, 0, " ", "  §eNão sei como você descobriu o crafting disso…", "  §eMas use com sabedoria!");*/
	
	public static ItemStack carne() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto de Carne", 1, 0, " ", "  §eAtaque seus inimigos com uma incrível repulsão!");
		Mine.addEnchant(item, Enchantment.KNOCKBACK, 100);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack ferro() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto de Ferro", 1, 0, " ", "  §eQuebre blocos e drope barras de ferro!");
		return item;
	}
	
	public static ItemStack ouro() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto de Ouro", 1, 0, " ", "  §eQuebre blocos e drope barras de ouro!");
		return item;
	}
	
	public static ItemStack dima() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto de Diamante", 1, 0, " ", "  §eQuebre blocos e drope diamante!");
		return item;
	}
	
	public static ItemStack explo() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto Explosivo", 1, 0, " ", "  §eQuebre blocos e cause uma EXPLOSÃO!");
		return item;
	}
	
	public static ItemStack ender() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Ender Graveto", 1, 0, " ", "  §eClique com o botão direito", "§e  e arremesse uma pérola do fim!");
		return item;
	}
	
	public static ItemStack fogo() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto de Fogo", 1, 0, " ", "  §eClique com o botão direito", "§e  e arremesse uma bola de fogo explosiva!");
		return item;
	}
	
	public static ItemStack bau() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto Bau", 1, 0, " ", "  §eClique com o botão direito", "§e  e tenha acesso a um cofre especial!");
		return item;
	}
	
	public static ItemStack strong() {
		ItemStack item = Mine.newItem(Material.STICK, "§6Graveto da Stronghold", 1, 0, " ", "  §eClique com o botão direito", "§e  e revele a coordenada da stronghold!");
		return item;
	}

	
	public static void recipe() {
		ShapedRecipe carner = new ShapedRecipe(carne());
		carner.shape("#", "#");
		carner.setIngredient('#', Material.PORKCHOP);
		Main.getPlugin(Main.class).getServer().addRecipe(carner);
		
		ShapedRecipe ferror = new ShapedRecipe(ferro());
		ferror.shape("#", "#");
		ferror.setIngredient('#', Material.IRON_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(ferror);
		
		ShapedRecipe ouror = new ShapedRecipe(ouro());
		ouror.shape("#", "#");
		ouror.setIngredient('#', Material.GOLD_INGOT);
		Main.getPlugin(Main.class).getServer().addRecipe(ouror);
		
		ShapedRecipe dimar = new ShapedRecipe(dima());
		dimar.shape("#", "#");
		dimar.setIngredient('#', Material.DIAMOND);
		Main.getPlugin(Main.class).getServer().addRecipe(dimar);
		
		ShapedRecipe explor = new ShapedRecipe(explo());
		explor.shape("#", "#");
		explor.setIngredient('#', Material.GUNPOWDER);
		Main.getPlugin(Main.class).getServer().addRecipe(explor);
		
		ShapedRecipe enderr = new ShapedRecipe(ender());
		enderr.shape("#", "#");
		enderr.setIngredient('#', Material.ENDER_PEARL);
		Main.getPlugin(Main.class).getServer().addRecipe(enderr);
		
		ShapedRecipe fogor = new ShapedRecipe(fogo());
		fogor.shape("#", "#");
		fogor.setIngredient('#', Material.BLAZE_ROD);
		Main.getPlugin(Main.class).getServer().addRecipe(fogor);
		
		ShapedRecipe baur = new ShapedRecipe(bau());
		baur.shape("#", "#");
		baur.setIngredient('#', Material.CHEST);
		Main.getPlugin(Main.class).getServer().addRecipe(baur);
		
		ShapedRecipe strongr = new ShapedRecipe(strong());
		strongr.shape("#", "#");
		strongr.setIngredient('#', Material.ENDER_EYE);
		Main.getPlugin(Main.class).getServer().addRecipe(strongr);
	}
}
