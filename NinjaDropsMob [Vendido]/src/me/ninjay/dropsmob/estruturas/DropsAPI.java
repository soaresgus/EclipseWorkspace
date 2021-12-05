package me.ninjay.dropsmob.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.dropsmob.main.Main;
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
			
			 ItemStack drop1 = Mine.newItem(Material.INK_SACK, "§eDrop01",1, 3);
			   Mine.addEnchant(drop1, Enchantment.DAMAGE_ALL, 2);
			   Mine.addEnchant(drop1, Enchantment.DURABILITY, 2);
			   ItemMeta drop1m = drop1.getItemMeta();
			   ArrayList<String> lore = new ArrayList<String>();
			   lore.add("teste1");
			   lore.add("teste2");
			   drop1m.setLore(lore);
			   drop1.setItemMeta(drop1m);
			
			mob1.setMob(EntityType.COW);
			mob1.setDrop(drop1);
			mob1.setLot1(2);
			mob1.setLot2(3);
			mob1.setLot3(4);
			mob1.setLot4(5);
			mob1.setLot5(6);
			mob1.setLot6(7);
			mob1.setLot7(8);
			mob1.setLot8(9);
			mob1.setLot9(10);
			mob1.setLot10(11);
			mob1.setNormal(1);
		
			manager.getDrops().add(mob1);
			save();
			
		}
	}
	public static void save() {
		config.set("drops", manager);
		config.saveConfig();
	}

}
