package me.ninjay.craftsaleatorios.utils;

import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

/**
 * Encantamento Glow
 * 
 * @author Eduard
 * @version 1.1
 */
public class EnchantGlow extends EnchantmentWrapper {

	private static Enchantment glow;

	public EnchantGlow(String i) {
		super(i);
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment other) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	public String getName() {
		return "Glow";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	public static ItemStack addGlow(ItemStack item) {

		if (!item.containsEnchantment(glow))
			item.addUnsafeEnchantment(glow, 1);

		return item;
	}

	public static ItemStack removeGlow(ItemStack item) {

		if (item.containsEnchantment(glow))
			item.removeEnchantment(glow);

		return item;
	}

}
