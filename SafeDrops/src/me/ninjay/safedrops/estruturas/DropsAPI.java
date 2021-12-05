package me.ninjay.safedrops.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safedrops.main.Main;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.Mine;

public class DropsAPI {
	
	public static DropsManager manager;
	
	private static BukkitConfig config = new BukkitConfig("drops.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("drops")) {
			manager = (DropsManager) config.get("drops");
		}else {
			manager = new DropsManager();
			
			Drops mob1 = new Drops();
			
			ItemStack item1 = Mine.newItem(Material.INK_SACK, "§6Bolsinha", 5, 0, "lore1","§clore2");
			Mine.addEnchant(item1, Enchantment.DAMAGE_ALL, 4);
			Mine.addEnchant(item1, Enchantment.DURABILITY, 3);
			
			ItemStack item2 = Mine.newItem(Material.DIRT, "", 3, 0, "");
			
			ItemStack itemb = Mine.newItem(Material.GOLDEN_APPLE, "");
			
			ArrayList<ItemStack> itens = new ArrayList<>();
			
			itens.add(item1);
			itens.add(item2);
			
			mob1.setDrops(itens);
			
			mob1.setItembonus(itemb);
			mob1.setChanceItemBonus(0.50);
			
			mob1.setLooting(10);
			mob1.setDropbonus(5);
			mob1.setMob(EntityType.COW);
			mob1.setAmount(30);
			
			manager.getDrops().add(mob1);
			save();
		}
	}
	public static void save() {
		config.set("drops", manager);
		config.saveConfig();
	}
	
}
