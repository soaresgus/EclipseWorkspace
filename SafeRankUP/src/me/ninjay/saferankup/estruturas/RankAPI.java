package me.ninjay.saferankup.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;

import me.ninjay.saferankup.main.Main;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.Mine;

public class RankAPI {
	
	public static RankManager manager;
	
	public static BukkitConfig config = new BukkitConfig("ranks.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("ranks")) {
			manager = (RankManager) config.get("ranks");
		}else {
			manager = new RankManager();
			
			Rank rank1 = new Rank();
			
			rank1.setName("Terra III");
			rank1.setId(1);
			rank1.setValor(1000.0);
			rank1.setFileiraRanks(2);
			rank1.setFileirasInvRanks(6);
			rank1.setSlotRanks(2);
			rank1.setIcon(Mine.newItem(Material.DIRT, "§eTerra", 1, 0, " "," §7Valor: §a$???"));
			rank1.setIconRanks(Mine.newItem(Material.DIRT, "§eTerra", 1, 0, " ", " §7Clique para mais informações"));
			manager.getRanks().add(rank1);
			save();
		}
	}
	
	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}

}
