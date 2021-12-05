package me.ninjay.megataymaquinas.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.megataymaquinas.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;

public class RefinariaAPI {

	public static RefinariaManager manager;
    
	private static BukkitConfig config = new BukkitConfig("refinaria.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		if(config.contains("refinarias")) {
			manager = (RefinariaManager) config.get("refinarias");
		}else {
			manager = new RefinariaManager();
			
			Refinaria refinaria1 = new Refinaria();
			
			 ItemStack icone1 = Mine.newItem(Material.COAL_BLOCK, "§eRefinaria01", 1, 0, "§eLORE", "§eLOREE");
			 ItemStack combustivel1 = Mine.newItem(Material.COAL, "§eCombustivel01",1, 0);
			 ItemStack essencia1 = Mine.newItem(Material.GLOWSTONE_DUST, "§eEssencia01", 1, 0);
			 Mine.addEnchant(combustivel1, Enchantment.DAMAGE_ALL, 2);
			 Mine.addEnchant(combustivel1, Enchantment.DURABILITY, 2);
			 
			 refinaria1.setNome("refinaria1");
			 refinaria1.setNumero(1);
			 refinaria1.setCombustivel(combustivel1);
			 refinaria1.setEssencia(essencia1);
			 refinaria1.setIcone(icone1);
			 refinaria1.setPrice(10);
			 
			 manager.getRefinarias().add(refinaria1);
			 save();
		}
	}
	
	public static void save() {
		config.set("refinarias", manager);
		config.saveConfig();
	}
}
