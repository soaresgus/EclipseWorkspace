package me.ninjay.megataymaquinas.estruturas;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.ninjay.megataymaquinas.main.Main;
import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;

public class MaquinaAPI {
		
   public static MaquinaManager manager;
   
   private static BukkitConfig maquinac = new BukkitConfig("maquina.yml", Main.getPlugin(Main.class));

   public static void reload() {
	   if(maquinac.contains("maquinas")) {
		   manager = (MaquinaManager) maquinac.get("maquinas");
	   }else {
		   manager = new MaquinaManager();
		   
		   Maquina maquina1 = new Maquina();
		   
		   ItemStack icone1 = Mine.newItem(Material.IRON_BLOCK, "§eMaquina01", 1, 0, "§eLORE", "§eLOREE");
		   ItemStack drop1 = Mine.newItem(Material.INK_SACK, "§eDrop01",1, 3);
		   Mine.addEnchant(drop1, Enchantment.DAMAGE_ALL, 2);
		   Mine.addEnchant(drop1, Enchantment.DURABILITY, 2);
		   
		   maquina1.setNome("maquina1");
		   maquina1.setDrop(drop1);
		   maquina1.setIcone(icone1);
		   maquina1.setPrice(10);
		   
		   manager.getMaquinas().add(maquina1);
		   save();
	   }
   }
   
   public static void save() {
	   maquinac.set("maquinas", manager);
	   maquinac.saveConfig();
   }
   
}
