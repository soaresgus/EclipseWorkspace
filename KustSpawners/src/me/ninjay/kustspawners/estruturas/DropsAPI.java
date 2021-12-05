package me.ninjay.kustspawners.estruturas;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import me.ninjay.kustspawners.main.Main;
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
			
			Drops drop1 = new Drops();
			
			drop1.setName("Galinha");
			drop1.setMob(EntityType.CHICKEN);
			drop1.setDrop1(Material.RAW_CHICKEN);
			drop1.setDrop2(Material.FEATHER);
			drop1.setChance1(1.00);
			drop1.setChance2(0.50);
			drop1.setLot0Drop1(2);
			drop1.setLot1Drop1(3);
			drop1.setLot2Drop1(4);
			drop1.setLot3Drop1(5);
			drop1.setLot0Drop2(3);
			drop1.setLot1Drop2(4);
			drop1.setLot2Drop2(5);
			drop1.setLot3Drop2(6);
			
			manager.getDrops().add(drop1);
			save();
			
		}
		
	}
	
	public static void save() {
		config.set("drops", manager);
		config.saveConfig();
	}
	
}
