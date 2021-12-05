package me.ninjay.fashmining.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.fashmining.estruturas.ItemAPI;
import me.ninjay.fashmining.utils.Mine;

public class ComandoMinerios implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			Inventory menu = Mine.newInventory("Seus minérios", 9*3);
			
			menu.setItem(Mine.getPosition(2, 2), ItemAPI.coal);
			menu.setItem(Mine.getPosition(2, 3), ItemAPI.lapis);
			menu.setItem(Mine.getPosition(2, 4), ItemAPI.red);
			menu.setItem(Mine.getPosition(2, 5), ItemAPI.ferro);
			menu.setItem(Mine.getPosition(2, 6), ItemAPI.ouro);
			menu.setItem(Mine.getPosition(2, 7), ItemAPI.diamante);
			menu.setItem(Mine.getPosition(2, 8), ItemAPI.emerald);
			
			p.openInventory(menu);
			
		}
		return false;
	}

}
