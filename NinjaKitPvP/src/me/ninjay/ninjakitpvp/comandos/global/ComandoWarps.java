package me.ninjay.ninjakitpvp.comandos.global;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.ninjay.ninjakitpvp.estruturas.ItemAPI;
import me.ninjay.ninjakitpvp.utils.Mine;
public class ComandoWarps implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			Inventory menu = Mine.newInventory("Warps", 9*3);
			
			for(int i = 0; i < 9*3; i++) {
				menu.setItem(i, ItemAPI.svidro);
				break;
			}
			menu.setItem(Mine.getPosition(2, 2), ItemAPI.wlava);
		    menu.setItem(Mine.getPosition(2, 4), ItemAPI.w1v1);
		    
		    
		   
		}
		return false;
	}

}
