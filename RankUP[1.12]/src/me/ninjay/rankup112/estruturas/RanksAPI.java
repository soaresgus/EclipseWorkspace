package me.ninjay.rankup112.estruturas;

import org.bukkit.Material;

import me.ninjay.rankup112.main.Main;
import me.ninjay.rankup112.utils.BukkitConfig;
import me.ninjay.rankup112.utils.Mine;

public class RanksAPI {

public static RanksManager manager;
	
	private static BukkitConfig config = new BukkitConfig("ranks.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("ranks")) {
			manager = (RanksManager) config.get("ranks");
		}else {
			manager = new RanksManager();
			
			Ranks rank1 = new Ranks();
			
			rank1.setNome("esmeralda");
			rank1.setIcon(Mine.newItem(Material.EMERALD_BLOCK, "§eEsmeralda III", 1, 0, " ", "  §7Valor: §a$3.000"));
			
			manager.getRanks().add(rank1);
			save();
		}
	}
	
	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}
	
}
