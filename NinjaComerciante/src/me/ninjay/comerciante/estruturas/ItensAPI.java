package me.ninjay.comerciante.estruturas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.comerciante.main.Main;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.Mine;

public class ItensAPI {
	
	public static ItensManager manager;
	
	public static BukkitConfig config = new BukkitConfig("itens.yml", Main.getPlugin(Main.class));
	
	public static BukkitConfig configp = new BukkitConfig("config.yml", Main.getPlugin(Main.class));
	public static BukkitConfig info = new BukkitConfig("info.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("itens")) {
			manager = (ItensManager) config.get("itens");
		}else {
			manager = new ItensManager();
			
			Itens item1 = new Itens();
			
			item1.setQuantia(2);
			ItemStack icone = Mine.newItem(Material.ANVIL, "Reparador", item1.getQuantia(), 0, "§5Valor", "§6Linha5");
			ItemStack item = Mine.newItem(Material.ANVIL, "Reparador", item1.getQuantia(), 0, "§5Linha1", "§6Linha2");
			item1.setItem(item);
			item1.setAtivado(true);
			item1.setId(1);
			item1.setValor(1000.0);
			item1.setIcone(icone);
			
			manager.getItens().add(item1);
			save();
		}
	}
	public static void save() {
		config.set("itens", manager);
		config.saveConfig();
	}

}
