package me.ninjay.kustcaixas.estruturas;

import org.bukkit.Material;

import me.ninjay.kustcaixas.main.Main;
import me.ninjay.kustcaixas.utils.Mine;
import me.ninjay.utils.utils.BukkitConfig;

public class CaixaAPI {
	
	public static CaixaManager manager;
	
	private static BukkitConfig config = new BukkitConfig("caixas.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
			
		}else {
			
			manager = new CaixaManager();
			
			Caixa caixa1 = new Caixa();
			
			caixa1.setName("basica");
			caixa1.setNome("Básica");
			caixa1.setIcone(Mine.newItem(Material.CHEST, "§eCaixa Básica", 1, 0, " §7Clique direito para abrir"));
			caixa1.setPreco1(10);
			caixa1.setPreco5(40);
			caixa1.setPreco10(90);
			caixa1.setPreco25(240);
			caixa1.setSlotLoja(Mine.getPosition(2, 3));
			caixa1.setIconeLoja1(Mine.newItem(Material.CHEST, "§eCaixa Básica", 1, 0, " ", " §eValor: §f10"));
			caixa1.setIconeLoja5(Mine.newItem(Material.CHEST, "§eCaixa Básica", 5, 0, " ", " §eValor: §f40"));
			caixa1.setIconeLoja10(Mine.newItem(Material.CHEST, "§eCaixa Básica", 10, 0, " ", " §eValor: §f90"));
			caixa1.setIconeLoja25(Mine.newItem(Material.CHEST, "§eCaixa Básica", 25, 0, " ", " §eValor: §f240"));
			
			manager.getCaixas().add(caixa1);
			save();
		}
	}
	
	public static void save() {
		config.set("caixas", manager);
		config.saveConfig();
	}


}
