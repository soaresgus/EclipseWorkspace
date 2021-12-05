package me.ninjay.kustkits.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.kustkits.main.Main;
import me.ninjay.kustkits.utils.Mine;
import me.ninjay.utils.utils.BukkitConfig;

public class KitAPI {
	
	public static KitManager manager;
	
	private static BukkitConfig config = new BukkitConfig("kits.yml", Main.getPlugin(Main.class));
	
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("kits")) {
			manager = (KitManager) config.get("kits");
		}else {
			manager = new KitManager();
			
			Kit kit1 = new Kit();
			
			kit1.setName("iniciante");
			kit1.setNome("Iniciante");
			kit1.setIniciante(true);
			kit1.setIcone(Mine.newItem(Material.WOOD, "§eKit Iniciante", 1, 0, "lore1", "lore2", "lore3"));
			
			ArrayList<ItemStack> itens = new ArrayList<>();
			ItemStack item1 = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada divina", 1, 0, "lore1");
			Mine.addEnchant(item1, Enchantment.DAMAGE_ALL, 2);
			Mine.addEnchant(item1, Enchantment.DURABILITY, 3);
			ItemStack item2 = Mine.newItem(Material.TNT, null, 64, 0);
			
			itens.add(item1);
			itens.add(item2);
			
			kit1.setItens(itens);
			kit1.setCooldown(20);
			kit1.setId(1);
			kit1.setSlot(11);
			kit1.setVip(false);
			kit1.setPerm("iniciante.kit");
			
			manager.getKits().add(kit1);
			save();
		}
	}

	public static void save() {
		config.set("kits", manager);
		config.saveConfig();
	}
}
