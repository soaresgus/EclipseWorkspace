package me.ninjay.upsoulth.cash;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.ninjaapi.utils.Mine;

public class ComandoLoja implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			ItemStack deadm = Mine.newItem(Material.IRON_INGOT, "§2§lVines §emensal", 1, 0, "§fValor: §e5 Cash");
			ItemStack deade = Mine.newItem(Material.IRON_BLOCK, "§2§lVines §eeterno", 1, 0, "§fValor: §e20 Cash");
			
			ItemStack soulthm = Mine.newItem(Material.GOLD_INGOT, "§6§lSoulth §emensal", 1, 0, "§fValor: §e10 Cash");
			ItemStack soulthe = Mine.newItem(Material.GOLD_BLOCK, "§6§lSoulth §eeterno", 1, 0, "§fValor: §e25 Cash");
			
			ItemStack dingym = Mine.newItem(Material.DIAMOND, "§b§lJungle §emensal", 1, 0, "§fValor: §e30 Cash");
			ItemStack dingye = Mine.newItem(Material.DIAMOND_BLOCK, "§b§lJungle §eeterno", 1, 0, "§fValor: §e50 Cash");

			ItemStack flowersm = Mine.newItem(Material.EMERALD, "§a§lFlowers §emensal", 1, 0, "§fValor: §e40 Cash");
			ItemStack flowerse = Mine.newItem(Material.EMERALD_BLOCK, "§a§lFlowers §eeterno", 1, 0, "§fValor: §e80 Cash");
            			
			
			Inventory menu = Mine.newInventory("Shop De Cash", 9*4);
			menu.setItem(Mine.getPosition(2, 2), deadm);
			menu.setItem(Mine.getPosition(3, 2), deade);
			
			menu.setItem(Mine.getPosition(2, 4), soulthm);
			menu.setItem(Mine.getPosition(3, 4), soulthe);
			
			menu.setItem(Mine.getPosition(2, 6), dingym);
			menu.setItem(Mine.getPosition(3, 6), dingye);
			
			menu.setItem(Mine.getPosition(2, 8), flowersm);
			menu.setItem(Mine.getPosition(3, 8), flowerse);
			
			
			
			p.openInventory(menu);
		}
		return false;
	}

}
