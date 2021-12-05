package me.ninjay.kustespeciais.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.kustespeciais.main.Main;
import me.ninjay.kustespeciais.utils.Mine;

public class ItensAPI {
	
	public static ItemStack crepper = Mine.newItem(Material.MONSTER_EGG, "§6Ovo de Creeper", 1, 50);
	public static ItemStack poder = Mine.newItem(Material.NETHER_STAR, "§6+1 de Poder Máximo", 1, 0, "§fAtivando esse item você aumenta","§f1 ponto em seu poder máximo.", " ", "§fLimite de poder máximo: 15", " ");
	public static ItemStack instantaneo = Mine.newItem(Material.INK_SACK, "§6Poder Instantâneo", 1, 7, "§fAtivando esse item você aumenta","§f1 ponte em seu poder atual.", " ", "§fChance de falha: "+Mine.toString(Main.config.getDouble("instantaneo.chance"))+"%", " "); 
	public static ItemStack kdr = Mine.newItem(Material.PAPER, "§6Reset KDR", 1, 0, "§fAtivando esse item você irá resetar seu KDR", " ");
	public static ItemStack raio() {
		ItemStack raio = Mine.newItem(Material.BLAZE_ROD, "§6Raio Mestre", 1, 0, "§fAtivando esse item você irá", "§fgerar um raio no bloco no qual clicou.", " ");
		ItemMeta meta = raio.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		raio.setItemMeta(meta);
		return raio;
	}
	
	public static ItemStack instantaneoshop = Mine.newItem(Material.INK_SACK, "§6Poder Instantâneo", 1, 7, "§fAtivando esse item você aumenta","§f1 ponte em seu poder atual.", " ", "§fChance de falha: "+Mine.toString(Main.config.getDouble("instantaneo.chance"))+"%", " ", " §fCusto: §a"+Main.config.getInt("instantaneo.valor")+" Cash"); 
	public static ItemStack kdrshop = Mine.newItem(Material.PAPER, "§6Reset KDR", 1, 0, "§fAtivando esse item você irá resetar seu KDR", " ", " §fCusto: §a"+Main.config.getInt("reset")+" Cash");
	public static ItemStack raioshop() {
		ItemStack raio = Mine.newItem(Material.BLAZE_ROD, "§6Raio Mestre", 1, 0, "§fAtivando esse item você irá", "§fgerar um raio no bloco no qual clicou.", " ", " §fCusto: §a"+Main.config.getInt("raio")+" Cash");
		ItemMeta meta = raio.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		raio.setItemMeta(meta);
		return raio;
	}
	
	public static ItemStack boostershop = Mine.newItem(Material.EXP_BOTTLE, "§aBooster de Experiência", 1, 0, "§7* Receba §f1 hora §7de §fDuplo XP §7em qualquer habilidade!", " ", " §fCusto: §a"+Main.config.getInt("booster")+" Cash");
}
