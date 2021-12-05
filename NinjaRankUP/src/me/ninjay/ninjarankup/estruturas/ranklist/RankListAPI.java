package me.ninjay.ninjarankup.estruturas.ranklist;


import org.bukkit.Material;

import me.ninjay.ninjarankup.main.Main;
import me.ninjay.ninjarankup.utils.BukkitConfig;
import me.ninjay.ninjarankup.utils.Mine;

public class RankListAPI {

	public static RankListManager manager;
	
	private static BukkitConfig config = new BukkitConfig("rankList.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("rankList")) {
			manager = (RankListManager) config.get("rankList");
		}else {
			manager = new RankListManager();
			
			RankList rank1 = new RankList();
			
			rank1.setIcone(Mine.newItem(Material.COAL_BLOCK, "§aCarvão", 1, 0, " ", "  §7Carvão III: §a$2.000", "  §7Carvão II: §a$4.000", "  §7Carvão I: §a$6.000"));
			rank1.setPagina(1);
			rank1.setSlot(18);
			
			manager.getRankList().add(rank1);
			save();
		}
	}
	
	public static void save() {
		config.set("rankList", manager);
		config.saveConfig();
	}
}
