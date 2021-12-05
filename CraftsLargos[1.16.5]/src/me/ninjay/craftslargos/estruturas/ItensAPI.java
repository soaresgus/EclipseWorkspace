package me.ninjay.craftslargos.estruturas;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.craftslargos.main.Main;
import me.ninjay.craftslargos.utils.Mine;

public class ItensAPI {
	
	public static ItemStack craft() {
		ItemStack item = Mine.newItem(Material.YELLOW_CONCRETE, "§5Crafting Table Larga", 1, 0, "§7Multiplicador III", " ", "  §7Use essa crafting table para fazer", "  §7itens incrivelmente largos!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack beef() {
		ItemStack item = Mine.newItem(Material.COOKED_BEEF, "§5Beef Largo", 1, 0, "§7Saúde II", " ", "  §7Coma essa beef e não sinta fome por um tempo!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack bacon() {
		ItemStack item = Mine.newItem(Material.COOKED_PORKCHOP, "§5Bacon Largo", 1, 0, "§7Saúde II", " ", "  §7Coma essa beef e não sinta fome por um tempo!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack escudo() {
		ItemStack item = Mine.newItem(Material.SHIELD, "§6Escudo Longo", 1, 0, "§7Proteção V", " ", "  §7Como vai olhar enquanto defende?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack olho() {
		ItemStack item = Mine.newItem(Material.ENDER_EYE, "§5Olho do Fim Longo", 1, 0, "§7Speedrun X", " ", "  §7Achar a stronghold vai ser mais fácil", "  §7que tirar doce de criança!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack peitoral1() {
		ItemStack item = Mine.newItem(Material.IRON_CHESTPLATE, "§5Peitoral Largo I", 1, 0, " ", "  §7No final das contas, até que você economizou.");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
        item.setItemMeta(meta);
        
		return item;
	}
	
	public static ItemStack peitoral2() {
		ItemStack item = Mine.newItem(Material.GOLDEN_CHESTPLATE, "§5Peitoral Largo II", 1, 0, " ", "  §7Quer aprender fazer um peitoral", "  §7como esse? Arrasta pra cima!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack peitoral3() {
		ItemStack item = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§5Peitoral Largo III", 1, 0, " ", "  §7Ok Ok, ninguém será capaz de te enfrentar!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack peitoral4() {
		ItemStack item = Mine.newItem(Material.NETHERITE_CHESTPLATE, "§5Peitoral Largo IV", 1, 0, "§7Proteção Infinity", "§7Inquebrável Infinity", " ", "  §7ta de brinquexion with me cara?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 999999, true);
		meta.addEnchant(Enchantment.DURABILITY, 999999, true);
		
		meta.setUnbreakable(true);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada1() {
		ItemStack item = Mine.newItem(Material.STONE_SWORD, "§5Espada Larga I", 1, 0, "§7Reach I", " ", "  §7Eu juro que isso não é hack!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada2() {
		ItemStack item = Mine.newItem(Material.IRON_SWORD, "§5Espada Larga II", 1, 0, "§7Reach II", " ", "  §7Espero que nenhum moderador esteja olhando...");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada3() {
		ItemStack item = Mine.newItem(Material.GOLDEN_SWORD, "§5Espada Larga III", 1, 0, "§7Reach III", " ", "  §7Era essa espada que você queria?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada4() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SWORD, "§5Espada Larga IV", 1, 0, "§7Reach V", " ", "  §7Será que dá pra cutucar buraco", "  §7de tatu com uma dessas?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack espada5() {
		ItemStack item = Mine.newItem(Material.NETHERITE_SWORD, "§6Espada Larga V", 1, 0, "§7Reach X", " ", "  §7Deve dar para catar manga com uma dessas!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta1() {
		ItemStack item = Mine.newItem(Material.STONE_PICKAXE, "§5Picareta Larga I", 1, 0, "§7Oportunismo I", " ", "  §7Boa para dar aquela mineradinha em off");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta2() {
		ItemStack item = Mine.newItem(Material.IRON_PICKAXE, "§5Picareta Larga II", 1, 0, "§7Oportunismo II", " ", "  §7Vale fazer speedrun com isso?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta3() {
		ItemStack item = Mine.newItem(Material.GOLDEN_PICKAXE, "§5Picareta Larga III", 1, 0, "§7Oportunismo III", " ", "  §7Será que ela quebra 3x mais rápido?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta4() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§5Picareta Larga IV", 1, 0, "§7Oportunismo IV", " ", "  §7ta pensando o mesmo que eu?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack picareta5() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Picareta Larga V", 1, 0, "§7Oportunismo V", "§7Rico I", " ", "  §7Live de 24 horas minerando em", "  §7linha reta seria fácil com uma dessas!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado1() {
		ItemStack item = Mine.newItem(Material.STONE_AXE, "§5Machado Largo I", 1, 0, "§7Apple Beast I", " ", "  §7Newton descobriu a gravidade em 1986...", "  §7As maçãs flutavam antes disso?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado2() {
		ItemStack item = Mine.newItem(Material.IRON_AXE, "§5Machado Largo II", 1, 0, "§7Apple Beast II", " ", "  §7Quanto será que a loja de", "  §7artefatos antigos paga em uma dessa?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado3() {
		ItemStack item = Mine.newItem(Material.GOLDEN_AXE, "§5Machado Largo III", 1, 0, "§7Apple Beast III", " ", "  §7Estive pensando, a equipe precisa de um aumento");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado4() {
		ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§5Machado Largo IV", 1, 0, "§7Apple Beast IV", " ", "  §7Então cara, eu recebi um email aqui", "  §7com umas ideias interessantes!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack machado5() {
		ItemStack item = Mine.newItem(Material.NETHERITE_AXE, "§6Machado Largo V", 1, 0, "§7Apple Beast V", " ", "  §7Um machado desse só", "  §7pode ter sido feito em wakanda!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pa1() {
		ItemStack item = Mine.newItem(Material.STONE_SHOVEL, "§5Pa Larga I", 1, 0, "§7Homem de Sorte I", " ", "  §7Pas mundial, trazendo pás para a humanidade!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pa2() {
		ItemStack item = Mine.newItem(Material.IRON_SHOVEL, "§5Pa Larga II", 1, 0, "§7Homem de Sorte II", " ", "  §7Se alguém achar um tesoura me avisa...");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
		meta.addEnchant(Enchantment.DURABILITY, 2, true);
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pa3() {
		ItemStack item = Mine.newItem(Material.GOLDEN_SHOVEL, "§5Pa Larga III", 1, 0, "§7Homem de Sorte III", " ", "  §7Como as pessoas perdem tanta", "  §7coisa assim nas praias?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		//meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pa4() {
		ItemStack item = Mine.newItem(Material.DIAMOND_SHOVEL, "§5Pa Larga IV", 1, 0, "§7Homem de Sorte IV", " ", "  §7Houston, we have a problem.");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
		meta.addEnchant(Enchantment.DURABILITY, 4, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pa5() {
		ItemStack item = Mine.newItem(Material.NETHERITE_SHOVEL, "§6Pa Larga V", 1, 0, "§7Homem de Sorte V", " ", "  §7e vocês acham um vídeo", "  §7comprando hacks um exagero?");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack isqueiro() {
		ItemStack item = Mine.newItem(Material.FLINT_AND_STEEL, "§5Isqueiro Largo I", 1, 0, "§7Queimador III", " ", "  §7só item aleatório tipo ronaldinho gaúcho", "  §7jogando golf com o donald trump");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack maca() {
		ItemStack item = Mine.newItem(Material.ENCHANTED_GOLDEN_APPLE, "§6Maca Dourada Encantada Larga I", 1, 0, "§7Invencível X", "§7Saúde X", "§7Regeneração X", "§7Resistência X", " ", "  §7só item aleatório tipo ronaldinho gaúcho", "  §7jogando golf com o donald trump");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 10, true);
		item.setItemMeta(meta);
		return item;
	}
	
	public static void customCraft() {
		ShapedRecipe rrr = new ShapedRecipe(craft());
		
		rrr.shape("@@@", "@@@");
		
		rrr.setIngredient('@', Material.CRAFTING_TABLE);
		Main.getPlugin(Main.class).getServer().addRecipe(rrr);
	}
	
}
