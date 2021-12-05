package me.ninjay.caixas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;

public class CaixaAPI {

	public static BukkitConfig config = new BukkitConfig("caixas.yml",Main.getPlugin(Main.class));
	public static CaixaManager manager;
	public static void reload() {
		config.reloadConfig();
		if(config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
		}else {
			manager = new CaixaManager();
			Caixa basica = new Caixa();
			basica.setName("basica");
			
			ItemStack cbasica = Mine.newItem(Material.CHEST, "§eCaixa Básica");
	        
			ItemStack beacon = Mine.newItem(Material.BEACON, "§eBeacon");
	        ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, "§eEspada Dlç");
	        ItemStack machado = Mine.newItem(Material.IRON_AXE, "§eMachado do eduard bilingue");
	        ItemStack bola = Mine.newItem(Material.SNOW_BALL, "§eBomba de fumaça @@@@");
	        ItemStack eclipse = Mine.newItem(Material.STICK, "§eCajado do eclipse");
	        ItemStack enxada = Mine.newItem(Material.DIAMOND_HOE, "§eEnxada do poder");
	        ItemStack palito = Mine.newItem(Material.STICK, "§ePalito do ninja");
	        ItemStack xoxo = Mine.newItem(Material.ANVIL, "§eBeijinhos :3");
	        ItemStack pow = Mine.newItem(Material.TNT, "§ePow !");
	        ItemStack tendi = Mine.newItem(Material.SPONGE, "§eata");
			
			basica.setIcone(cbasica);
			basica.getPremios().add(beacon);
			basica.getPremios().add(beacon);
			basica.getPremios().add(espada);
			basica.getPremios().add(machado);
			basica.getPremios().add(bola);
			basica.getPremios().add(eclipse);
			basica.getPremios().add(enxada);
			basica.getPremios().add(palito);
			basica.getPremios().add(xoxo);
			basica.getPremios().add(pow);
			basica.getPremios().add(tendi);
			manager.getCaixas().add(basica);
			save();
			
		}
	}
	
	public static void save() {
		config.set("caixas", manager);
		config.saveConfig();
	}
}
