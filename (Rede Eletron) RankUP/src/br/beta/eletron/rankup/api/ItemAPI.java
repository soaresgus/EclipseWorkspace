package br.beta.eletron.rankup.api;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemAPI {

	public static ItemStack createItem(ItemStack item, String nome, String[] lore) {
		ItemStack i = new ItemStack(item);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(nome);
		im.setLore(Arrays.asList(lore));
		i.setItemMeta(im);

		return i;
	}

	public static ItemStack createHead(String nome) {
		ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta im = (SkullMeta) i.getItemMeta();
		im.setDisplayName(nome);
		im.setOwner(nome);
		i.setItemMeta(im);

		return i;
	}

}
