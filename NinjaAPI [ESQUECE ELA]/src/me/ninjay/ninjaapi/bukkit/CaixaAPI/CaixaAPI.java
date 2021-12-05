package me.ninjay.ninjaapi.bukkit.CaixaAPI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.main.Main;
import me.ninjay.ninjaapi.utils.BukkitConfig;
import me.ninjay.ninjaapi.utils.Mine;

public class CaixaAPI {
	
	public static BukkitConfig config = new BukkitConfig("caixas.yml", Main.getPlugin(Main.class));
	public static CaixaManager manager;
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
		}else {
			manager = new CaixaManager();
			Caixa basica = new Caixa();
			
			ItemStack icone = Mine.newItem(Material.ENDER_CHEST, "§eCaixa Misteriosa");
			
			ArrayList<ItemStack> itens = new ArrayList<>();
			
			itens.add(Mine.newItem(Material.DIAMOND, "§eporra"));
			
			basica.setNome("basica");
			basica.setNumber(1);
			basica.setIcone(icone);
			basica.setItens(itens);
			
			manager.getCaixas().add(basica);
			save();
		}
	}
	
	public static void save() {
		config.set("caixas", manager);
		config.saveConfig();
	}

}
