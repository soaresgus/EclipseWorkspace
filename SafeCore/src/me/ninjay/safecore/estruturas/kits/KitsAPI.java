package me.ninjay.safecore.estruturas.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safecore.main.Main;
import me.ninjay.safecore.utils.Mine;
import me.ninjay.utils.utils.BukkitConfig;

public class KitsAPI {

	public static KitsManager manager;

	public static BukkitConfig config = new BukkitConfig("kits.yml", Main.getPlugin(Main.class));

	public static void reload() {
		config.reloadConfig();
		if (config.contains("kits")) {
			manager = (KitsManager) config.get("kits");
		} else {
			manager = new KitsManager();

			Kits kit1 = new Kits();

			kit1.setName("kit1");
			kit1.setPerm("kit1.perm");

			ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§aKit1", 1, 0, "§clore1", "§alore2");
			Mine.addEnchant(item, Enchantment.DAMAGE_ALL, 3);
			Mine.addEnchant(item, Enchantment.DURABILITY, 2);

			kit1.setIcone(item);

			ItemStack item1 = Mine.newItem(Material.DIAMOND_SWORD, "§aItem1", 1, 0, "§clore1", "§alore2");
			Mine.addEnchant(item1, Enchantment.DAMAGE_ALL, 3);
			Mine.addEnchant(item1, Enchantment.DURABILITY, 2);
			ItemStack item2 = Mine.newItem(Material.DIAMOND_BLOCK, "§aItem2", 1, 0, "§clore1", "§alore2");

			ArrayList<ItemStack> itens = new ArrayList<ItemStack>();

			itens.add(item1);
			itens.add(item2);

			kit1.setId(1);

			kit1.setSlotIcone(2);
			kit1.setCooldown(60L);

			kit1.setItens(itens);

			manager.getKits().add(kit1);
			save();
		}
	}

	public static void save() {
		config.set("kits", manager);
		config.saveConfig();
	}

}
