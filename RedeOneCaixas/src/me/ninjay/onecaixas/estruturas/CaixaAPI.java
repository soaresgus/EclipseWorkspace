package me.ninjay.onecaixas.estruturas;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ninjay.onecaixas.main.Main;
import me.ninjay.utils.utils.BukkitConfig;
import me.ninjay.utils.utils.Mine;

public class CaixaAPI {
	public static ArrayList<ItemRandom> premios = new ArrayList<>();
	public static ArrayList<ItemStack> premio = new ArrayList<>();
	public static BukkitConfig config = new BukkitConfig("caixas.yml", Main.getPlugin(Main.class));
	public static CaixaManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");
		} else {
			manager = new CaixaManager();
			Caixa basica = new Caixa();

			basica.setNome("basica");
			basica.setValor(1);

			ItemStack icone = Mine.newItem(Material.ENDER_CHEST, "§eCaixa Básica");

			basica.setIcone(icone);
            
          	ItemStack a = Mine.newItem(Material.DIRT, "§eItem Normal - 1%"); //beacon
			ItemStack b = Mine.newItem(Material.DIRT, "§eItem com Lore - 3%",1,0,"Lore linha 1","lore linha 2","e vai indo");
			
			//capa 5 ^
			
			ItemStack c = Mine.newItem(Material.DIAMOND_SWORD, "§eItem com um encantamento - 3%");
			ItemMeta cm = c.getItemMeta();       
			cm.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			c.setItemMeta(cm);
			
			//peito 5 ^
			
			ItemStack d = Mine.newItem(Material.DIAMOND_SWORD, "§eItem com vários encantamentos - 3%");
			ItemMeta dm = d.getItemMeta();
			dm.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			dm.addEnchant(Enchantment.KNOCKBACK, 1, true);
			dm.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
			d.setItemMeta(dm);
			
			//calça 5 ^
			
			ItemStack e = Mine.newItem(Material.DIRT, "§eItem Normal - 3%");
			
			//bota 5 ^
			
			ItemStack f = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");
			
			//capa 4 ^
			
			ItemStack g = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");

			//peito 4 ^
			
			ItemStack h = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");

			//calça 4 ^
			
			ItemStack i = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");

			//bota 4 ^
			
			ItemStack j = Mine.newItem(Material.DIRT, "§eItem Normal - 5%");
			
			//espada ^
			
			ItemStack k = Mine.newItem(Material.DIRT, "§eItem Normal - 5%");

			//espada ^
			
			ItemStack l = Mine.newItem(Material.DIRT, "§eItem Normal - 5%");

			//espada ^
			
			ItemStack m = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");
			
			//32 cap ^
			
			ItemStack n = Mine.newItem(Material.DIRT, "§eItem Normal - 3%");

			//64 cap ^
			
			ItemStack o = Mine.newItem(Material.DIRT, "§eItem Normal - 4%");
			
			//pic ruim ^
			
			ItemStack p = Mine.newItem(Material.DIRT, "§eItem Normal - 3%");

			//pic ^
			
			ItemStack q = Mine.newItem(Material.DIRT, "§eItem Normal - 3%");

			//pic ^
			
			ItemStack r = Mine.newItem(Material.DIRT, "§eItem Normal - 16%");

			//xp ^
			
			ItemStack s = Mine.newItem(Material.DIRT, "§eItem Normal - 11%");

			//dima ^
			
			ItemStack t = Mine.newItem(Material.DIRT, "§eItem Normal - 12%");

			//gold ^
			
			ItemStack u = Mine.newItem(Material.DIRT, "§eItem Normal - 13%");

			//iron ^
			
			premio.add(a);
			premio.add(b);
			premio.add(c);
			premio.add(d);
			premio.add(e);
			premio.add(f);
			premio.add(g);
			premio.add(h);
			premio.add(i);
			premio.add(j);
			premio.add(k);
			premio.add(l);
			premio.add(m);
			premio.add(n);
			premio.add(o);
			premio.add(p);
			premio.add(q);
			premio.add(r);
			premio.add(s);
			premio.add(t);
			premio.add(u);
			
			premios.add(new ItemRandom(a, 1, 1, 0.1));
			premios.add(new ItemRandom(b, 1, 1, 0.3));
			premios.add(new ItemRandom(c, 1, 1, 0.3));
			premios.add(new ItemRandom(d, 1, 1, 0.3));
			premios.add(new ItemRandom(e, 1, 1, 0.3));
			premios.add(new ItemRandom(f, 1, 1, 0.4));
			premios.add(new ItemRandom(g, 1, 1, 0.4));
			premios.add(new ItemRandom(h, 1, 1, 0.4));
			premios.add(new ItemRandom(i, 1, 1, 0.4));
			premios.add(new ItemRandom(j, 1, 1, 0.5));
			premios.add(new ItemRandom(k, 1, 1, 0.5));
			premios.add(new ItemRandom(l, 1, 1, 0.5));
			premios.add(new ItemRandom(m, 1, 1, 0.4));
			premios.add(new ItemRandom(n, 1, 1, 0.3));
			premios.add(new ItemRandom(o, 1, 1, 0.4));
			premios.add(new ItemRandom(p, 1, 1, 0.3));
			premios.add(new ItemRandom(q, 1, 1, 0.3));
			premios.add(new ItemRandom(r, 1, 1, 0.16));
			premios.add(new ItemRandom(s, 1, 1, 0.11));
			premios.add(new ItemRandom(t, 1, 1, 0.12));
			premios.add(new ItemRandom(u, 1, 1, 0.13));
		    
			basica.setPrize(premios);
			
			manager.getCaixas().add(basica);
			save();
		}
	}
	public static void save() {
		config.set("caixas", manager);
		config.saveConfig();
	}

}
