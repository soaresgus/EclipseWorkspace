package me.ninjay.curso.caixa;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.curso.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;

public class CaixaAPI {

	public static BukkitConfig config = new BukkitConfig("caixa.yml", Main.getPlugin(Main.class));
	
	public static CaixaManager manager;
	public static void reload() {
		config.reloadConfig();
		if (config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
		}else {
			manager = new CaixaManager();
			Caixa basica = new Caixa();
			basica.setName("basica");
		
			ItemStack cbasica = Mine.newItem(Material.CHEST, "�eCaixa B�sica");
	        
	        ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, "�eEspada Dl�");
	        ItemStack machado = Mine.newItem(Material.IRON_AXE, "�eMachado do eduard bilingue");
	        ItemStack bola = Mine.newItem(Material.SNOW_BALL, "�eBomba de fuma�a @@@@");
	        ItemStack eclipse = Mine.newItem(Material.STICK, "�eCajado do eclipse");
	        ItemStack enxada = Mine.newItem(Material.DIAMOND_HOE, "�eEnxada do poder");
	        ItemStack palito = Mine.newItem(Material.STICK, "�ePalito do ninja");
	        ItemStack xoxo = Mine.newItem(Material.ANVIL, "�eBeijinhos :3");
	        ItemStack pow = Mine.newItem(Material.TNT, "�ePow !");
	        ItemStack tendi = Mine.newItem(Material.SPONGE, "�eata");
			
	        
			basica.setIcone(cbasica);
			manager.getCaixas().add(basica);
			save();
			
		}
	}
	
	public static void save() {
		config.set("caixas", manager);
		config.saveConfig();
	}
}
