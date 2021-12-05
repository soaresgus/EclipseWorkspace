package me.ninjay.multiferramenta.estruturas;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.multiferramenta.utils.Mine;


public class ItensAPI {
	
	public static ItemStack espadareta() {
		ItemStack item = Mine.newItem(Material.STONE_PICKAXE, "§6EspadaReta", 1, 0, "§fUma espada e uma picareta de pedra","§fem uma!", " ", "§eEVOLUIR PARA MULTIFERRAMENTA:", " §fJunte com um PaChado na bigorna", " ", "§eHABILIDADE DE ESPADARETA:"," §fO dano de uma §cespada §fde pedra!"," §fA velocidade de uma §cpicareta §fde pedra!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pachado() {
		ItemStack item = Mine.newItem(Material.STONE_PICKAXE, "§6PaChado", 1, 0, "§fUma pá e um machado de pedra","§fem um!", " ", "§eEVOLUIR PARA MULTIFERRAMENTA:", " §fJunte com uma EspadaReta na bigorna", " ", "§eHABILIDADE DE PACHADO:"," §fO dano e a velocidade de um §cmachado §fde pedra!"," §fA velocidade de uma §cpá §fde pedra!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 0.8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multibasico() {
		ItemStack item = Mine.newItem(Material.STONE_PICKAXE, "§6Multi Ferramenta Nivel Basico", 1, 0, "§fTodas as ferramentas de pedra","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INICIANTE:", " §fMatar §c5 Zumbis §e(0/5)", " ", "§eHABILIDADE DE NÍVEL BÁSICO:"," §fO dano de uma §cespada §fde pedra!"," §fA velocidade de uma §cpicareta, machado, e pá §fde pedra!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multiiniciante() {
		ItemStack item = Mine.newItem(Material.IRON_PICKAXE, "§6Multi Ferramenta Nivel Iniciante", 1, 0, "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL INTERMEDIÁRIO:", " §fMatar §c5 Esqueletos §e(0/5)", " §fMinerar §c10 Ouros §e(0/10)", " ", "§eHABILIDADE DE NÍVEL INICIANTE:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c3x3x3!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multiintermediario() {
		ItemStack item = Mine.newItem(Material.IRON_PICKAXE, "§6Multi Ferramenta Nivel Intermediario", 1, 0, "§fTodas as ferramentas de ferro","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL AVANÇADO:", " §fMatar §c5 Aranhas §e(0/5)", " §fMatar §c10 Zumbis §e(0/10)", " §fMinerar §c5 Diamantes §e(0/5)", " §fQuebrar §c20 Obsidians §e(0/20)", " ", "§eHABILIDADE DE NÍVEL INTERMEDIÁRIO:"," §cTodas §fas habilidades anteriores!"," §fMinérios quebrados serão §cderretidos§f!", " §fQuebrar §cterras e arreias §ftenha 2%", " §fde chance de dropar §cossos§f!", " §fMatar mobs dropa §cmaçã dourada§f!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multiavancado() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Multi Ferramenta Nivel Avancado", 1, 0, "§fTodas as ferramentas de diamante","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL PROFISSIONAL:", " §fMatar §c10 Porcos §e(0/10)", " §fMatar §c10 Ovelhas §e(0/10)", " §fMatar §c10 Cavalos §e(0/10)", " §fQuebrar §c50 Areias §e(0/50)", " ", "§eHABILIDADE DE NÍVEL AVANÇADO:"," §cTodas §fas habilidades anteriores!"," §fQuebra em uma área de §c5x5x5§f!", " §fMobs droparam o §cdobro §fde looting!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multiprofissional() {
		ItemStack item = Mine.newItem(Material.DIAMOND_PICKAXE, "§6Multi Ferramenta Nivel Profissional", 1, 0, "§7Aspecto Flamejante II", "§7Fortuna III", " ", "§fTodas as ferramentas de diamante","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL ESPECIALISTA:", " §fMinerar §c30 Ferros §e(0/30)", " §fMinerar §c50 Carvões §e(0/50)", " §fMinerar §c5 Lapis Lazuli §e(0/5)", " ", "§eHABILIDADE DE NÍVEL PROFISSIONAL:"," §cTodas §fas habilidades anteriores!"," §fEncantamento de §cAspecto Flamejante§f!", " §fEncantamento de §cFortuna III§f!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multiespecialista() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Multi Ferramenta Nivel Especialista", 1, 0, "§7Aspecto Flamejante II", "§7Fortuna III", " ", "§fTodas as ferramentas de netherite","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL ELITE:", " §fMatar §c10 Esqueletos Wither §e(0/10)", " §fMatar §c10 Blazes §e(0/10)", " ", "§eHABILIDADE DE NÍVEL ESPECIALISTA:"," §cTodas §fas habilidades anteriores!"," §fDropa §cmaçãs douradas §fao quebrar folhas de árvores!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multielite() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Multi Ferramenta Nivel Elite", 1, 0, "§7Aspecto Flamejante II", "§7Fortuna III", " ", "§fTodas as ferramentas de netherite","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL NOTCH:", " §fMatar §c20 Piglins §e(0/20)", " §fMatar §c1 Ghast §e(0/1)", " §fMinerar §c10 Minérios de Quartzo §e(0/10)", " §fQuebrar §c50 Areias das almas §e(0/50)", " ", "§eHABILIDADE DE NÍVEL ELITE:"," §cTodas §fas habilidades anteriores!"," §fDropa §c4x §fmais minérios!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multinotch() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Multi Ferramenta Nivel Notch", 1, 0, "§7Aspecto Flamejante II", "§7Fortuna III", " ", "§fTodas as ferramentas de netherite","§fem uma!", " ", "§eEVOLUIR PARA NÍVEL DEUS:", " §fMatar §c20 Blazes §e(0/20)", " §fQuebrar §c50 Folhas de árvores §e(0/50)", " ", "§eHABILIDADE DE NÍVEL NOTCH:"," §cTodas §fas habilidades anteriores!"," §fDropa §c8x §floots de mobs!", " §fMate em §cum hit §ftodos os mobs!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack multideus() {
		ItemStack item = Mine.newItem(Material.NETHERITE_PICKAXE, "§6Multi Ferramenta Nivel Deus", 1, 0, "§7Aspecto Flamejante II", "§7Fortuna III", " ", "§fTodas as ferramentas de netherite","§fem uma!", " ", "§eVocê está no último nível!", " ", "§eHABILIDADE DE NÍVEL DEUS:"," §cTodas §fas habilidades anteriores!", " §fPoder de §cVooar§f!", " §fQuebre em uma área de §c10x10x10§f!", " §fDropa os minérios §c16x §fmais!", " §fDropa §c16x §fmais drops de mobs!");
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 3, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack.damage", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
		
		AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attack.speed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
		
		item.setItemMeta(meta);
		return item;
	}
}
