package me.ninjay.almas.combustivel;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.almas.main.Main;
import net.eduard.api.lib.BukkitConfig;

public class CombustivelAPI {

	public static BukkitConfig combustivel = new BukkitConfig("combustivel.yml", Main.getPlugin(Main.class));
	public static CombustivelManager manager;
	
	public static void reload() {
		combustivel.reloadConfig();
		if(combustivel.contains("combustiveis")) {
			manager = (CombustivelManager) combustivel.get("combustiveis");
			
		}else {
			manager = new CombustivelManager();
			Combustivel combustivelb = new Combustivel();
			Combustivel combustivelm = new Combustivel();
			Combustivel combustivela = new Combustivel();
			
			combustivelb.setNome("1");
			combustivelm.setNome("2");
			combustivela.setNome("3");
			
			ItemStack combustivel01 = Mine.newItem(Material.IRON_AXE, "§eCombustivel 01");
			ItemStack combustivel02 = Mine.newItem(Material.DIAMOND_AXE, "§eCombustivel 02");
			ItemStack combustivel03 = Mine.newItem(Material.GOLD_AXE, "§eCombustivel 03");
			
			combustivelb.setIcone(combustivel01);
			combustivelm.setIcone(combustivel02);
			combustivela.setIcone(combustivel03);
			save();
		}
	}
	public static void save() {
		combustivel.set("combustiveis", manager);
		combustivel.saveConfig();
		
	}
	
}
