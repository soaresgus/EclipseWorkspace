package me.ninjay.almas.maquinas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.ninjay.almas.main.Main;
import me.ninjay.ninjaapi.utils.Mine;
import net.eduard.api.lib.BukkitConfig;

public class MaquinaAPI {

	public static BukkitConfig config = new BukkitConfig("maquinas.yml", Main.getPlugin(Main.class));
	public static MaquinaManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("maquinas")) {
			manager = (MaquinaManager) config.get("maquinas");
		} else {
			manager = new MaquinaManager();
			Maquina maquinab = new Maquina();
			Maquina maquinam = new Maquina();
			Maquina maquinaa = new Maquina();

			maquinab.setName("1");
			maquinam.setName("2");
			maquinaa.setName("3");

			ItemStack icone01 = Mine.newItem(Material.GRASS, "§eMaquina 01"); // ==
			ItemStack icone02 = Mine.newItem(Material.STONE, "§eMaquina 02"); // icones
			ItemStack icone03 = Mine.newItem(Material.WOOD, "§eMaquina 03"); // ==

			ItemStack drop01 = Mine.newItem(Material.COAL, "§eDrop 01"); // ==
			ItemStack drop02 = Mine.newItem(Material.IRON_INGOT, "§eDrop 02"); // drops
			ItemStack drop03 = Mine.newItem(Material.GOLD_INGOT, "§eDrop 03"); // ==

			maquinab.setIcone(icone01);
			maquinam.setIcone(icone02);
			maquinaa.setIcone(icone03);

			maquinab.setDrop(drop01);
			maquinam.setDrop(drop02);
			maquinaa.setDrop(drop03);

			maquinab.setValor("10.0");
			maquinam.setValor("20.0");
			maquinaa.setValor("30.0");
			
			maquinab.setAlmas(10.0d);
			maquinam.setAlmas(20.0d);
			maquinaa.setAlmas(30.0d);

			manager.getMaquinas().add(maquinab);
			manager.getMaquinas().add(maquinam);
			manager.getMaquinas().add(maquinaa);
			save();
		}

	}

	public static void save() {
		config.set("maquinas", manager);
		config.saveConfig();
	}

}
