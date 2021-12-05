package me.ninjay.ninjarankup.estruturas.rank;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjarankup.main.Main;
import me.ninjay.ninjarankup.utils.BukkitConfig;
import me.ninjay.ninjarankup.utils.Mine;

public class RankAPI {

public static RankManager manager;
	
	private static BukkitConfig config = new BukkitConfig("ranks.yml", Main.getPlugin(Main.class));
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("ranks")) {
			manager = (RankManager) config.get("ranks");
		}else {
			manager = new RankManager();
			
			Rank rank1 = new Rank();
			
			rank1.setNome("Carvão III");
			rank1.setId(1);
			rank1.setPerm("carvao3.perm");
			rank1.setGrupo("carvao3");
			rank1.setValor(2000);
			rank1.setTag("&8[C-III]");
			
			ArrayList<String> comandos = new ArrayList<>();
			ArrayList<ItemStack> itens = new ArrayList<>();
			
			comandos.add("say Comando enviado pelo console :D");
			comandos.add("say Teste 123");
			
			ItemStack item1 = Mine.newItem(Material.DIAMOND_SWORD, "&6Espada Teste", 1, 0);
			Mine.addEnchant(item1, Enchantment.DAMAGE_ALL, 4);
			itens.add(item1);
			
			rank1.setComando(comandos);
			rank1.setItens(itens);
			
			rank1.setIcone(Mine.newItem(Material.COAL_BLOCK, "&eCarvão III", 1, 0, " ", "  &7Valor: §2$2.000"));

			manager.getRanks().add(rank1);
			save();
		}
	}
	
	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}
	
}
