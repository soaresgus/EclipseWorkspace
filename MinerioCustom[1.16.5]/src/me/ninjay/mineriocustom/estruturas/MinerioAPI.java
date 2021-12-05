package me.ninjay.mineriocustom.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.mineriocustom.main.Main;
import me.ninjay.mineriocustom.utils.BukkitConfig;
import me.ninjay.mineriocustom.utils.Mine;

public class MinerioAPI {
	
	public static MinerioManager manager;
	
	private static BukkitConfig config = new BukkitConfig("minerios.yml", Main.getPlugin(Main.class));

	public static void reload() {
		config.reloadConfig();
		if(config.contains("minerios")) {
			manager = (MinerioManager) config.get("minerios");
		}else {
			manager = new MinerioManager();
			
			Minerio min1 = new Minerio();
			
			min1.setTipo(Material.RED_CONCRETE);

			min1.setDrop(Material.MUSHROOM_STEW);
			min1.setMin(1);
			min1.setMax(5);
			
			ArrayList<Material> pics = new ArrayList<>();
			
			pics.add(Material.WOODEN_PICKAXE);
			pics.add(Material.STONE_PICKAXE);
			pics.add(Material.GOLDEN_PICKAXE);
			pics.add(Material.IRON_PICKAXE);
			pics.add(Material.DIAMOND_PICKAXE);
			pics.add(Material.NETHERITE_PICKAXE);
			
			min1.setPicareta(pics);
			
			manager.getMinerios().add(min1);
			
			save();
		}
	}
	
	public static void save() {
		config.set("minerios", manager);
		config.saveConfig();
	}
	
}
