package me.ninjay.safeclub.estruturas.api.caixa;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.safeclub.main.Main;
import me.ninjay.safeclub.utils.BukkitConfig;
import me.ninjay.safeclub.utils.Mine;


public class CaixaAPI {
	
	public static BukkitConfig config = new BukkitConfig("caixas.yml", Main.getPlugin(Main.class));
	public static CaixaManager manager;
	
	public static void reload() {
		config.reloadConfig();
		if(config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
		}else {
			manager = new CaixaManager();
			Caixa diaria = new Caixa();
			Caixa all = new Caixa();
			Caixa media = new Caixa();
			Caixa boa = new Caixa();
			
			ItemStack icone = Mine.newItem(Material.EMERALD, "§eCaixa de Recompensa");
			
			ArrayList<ItemStack> itens = new ArrayList<>();
			
			ItemStack a = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete P5");
			Mine.addEnchant(a, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(a, Enchantment.DURABILITY, 3);
			
			ItemStack b = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral P5");
			Mine.addEnchant(b, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(b, Enchantment.DURABILITY, 3);
			
			ItemStack c = Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalça P5");
			Mine.addEnchant(c, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(c, Enchantment.DURABILITY, 3);
			
			ItemStack d = Mine.newItem(Material.DIAMOND_BOOTS, "§eBota P5");
			Mine.addEnchant(d, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(d, Enchantment.DURABILITY, 3);
			
			ItemStack e = Mine.newItem(Material.DIAMOND_SWORD, "§eSharp 6 - 5 Hits");
			e.setDurability((short) 1557);
			Mine.addEnchant(e, Enchantment.DAMAGE_ALL, 6);
			
			ItemStack f = Mine.newItem(Material.DIRT, "§eMais sorte da próxima vez :(");
			
			itens.add(a);
			itens.add(b);
			itens.add(c);
			itens.add(d);
			itens.add(e);
			itens.add(f);
			itens.add(f);
			itens.add(f);
			itens.add(f);
			
			diaria.setNome("diaria");
			diaria.setNumber(1);
			diaria.setIcone(icone);
			diaria.setItens(itens);
			
			ItemStack icone2 = Mine.newItem(Material.ANVIL, "§eCaixa ALL");
			
			ArrayList<ItemStack> itens2 = new ArrayList<>();
			
			ItemStack a2 = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete P5");
			Mine.addEnchant(a2, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(a2, Enchantment.DURABILITY, 3);
			
			ItemStack b2 = Mine.newItem(Material.DIRT, "§eMais sorte da próxima vez :(");
			
			itens2.add(a2);
			itens2.add(b2);
			itens2.add(b2);
			itens2.add(b2);
			itens2.add(b2);
			
			all.setIcone(icone2);
			all.setItens(itens2);
			all.setNome("all");
			all.setNumber(2);
			
			ItemStack icone3 = Mine.newItem(Material.ENDER_CHEST, "§eCaixa Média");
			
			ArrayList<ItemStack> itens3 = new ArrayList<>();
			
			ItemStack a3 = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete P5");
			Mine.addEnchant(a3, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(a3, Enchantment.DURABILITY, 3);
			
			ItemStack b3 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral P5");
			Mine.addEnchant(b3, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(b3, Enchantment.DURABILITY, 3);
			
			ItemStack c3 = Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalça P5");
			Mine.addEnchant(c3, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(c3, Enchantment.DURABILITY, 3);
			
			ItemStack d3 = Mine.newItem(Material.DIAMOND_BOOTS, "§eBota P5");
			Mine.addEnchant(d3, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(d3, Enchantment.DURABILITY, 3);
			
			ItemStack e3 = Mine.newItem(Material.DIAMOND_SWORD, "§eSharp 6");
			Mine.addEnchant(e3, Enchantment.DAMAGE_ALL, 6);
			Mine.addEnchant(e3, Enchantment.DURABILITY, 3);
			
			itens3.add(a3);
			itens3.add(b3);
			itens3.add(c3);
			itens3.add(d3);
			itens3.add(e3);
			
			media.setIcone(icone3);
			media.setItens(itens3);
			media.setNome("media");
			media.setNumber(3);
			
			ItemStack icone4 = Mine.newItem(Material.NETHER_STAR, "§eCaixa Lendária");
			
			ArrayList<ItemStack> itens4 = new ArrayList<>();
			
			ItemStack a4 = Mine.newItem(Material.DIAMOND_HELMET, "§eCapacete P5");
			Mine.addEnchant(a4, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(a4, Enchantment.DURABILITY, 4);
			
			ItemStack b4 = Mine.newItem(Material.DIAMOND_CHESTPLATE, "§ePeitoral P5");
			Mine.addEnchant(b4, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(b4, Enchantment.DURABILITY, 4);
			
			ItemStack c4 = Mine.newItem(Material.DIAMOND_LEGGINGS, "§eCalça P5");
			Mine.addEnchant(c4, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(c4, Enchantment.DURABILITY, 4);
			
			ItemStack d4 = Mine.newItem(Material.DIAMOND_BOOTS, "§eBota P5");
			Mine.addEnchant(d4, Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Mine.addEnchant(d4, Enchantment.DURABILITY, 4);
			
			ItemStack e4 = media.getIcone().clone();
            e4.setAmount(3);
            
			ItemStack f4 = Mine.newItem(Material.PAPER, "§ePasse de Cash");
			Mine.addEnchant(f4, Enchantment.DURABILITY, 1);

			itens4.add(a4);
			itens4.add(b4);
			itens4.add(c4);
			itens4.add(d4);
			itens4.add(e4);
			itens4.add(f4);
			
			boa.setNome("lendaria");
			boa.setNumber(4);
			boa.setIcone(icone4);
			boa.setItens(itens4);
			
			manager.getCaixas().add(boa);
			manager.getCaixas().add(media);
			manager.getCaixas().add(all);
			manager.getCaixas().add(diaria);
			save();
		}
	}
	
	public static void save() {
		config.set("Caixas", manager);
		config.saveConfig();
	}

}
