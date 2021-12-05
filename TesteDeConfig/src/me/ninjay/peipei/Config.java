package me.ninjay.peipei;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Config implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			boolean isEmpty = true;
			for (ItemStack item : p.getInventory().getContents()) {
				if (item != null) {
					isEmpty = false;
					break;
				}

			}
			if (isEmpty) {
				if (p.getInventory().getHelmet() == null) {
					if (p.getInventory().getChestplate() == null) {
						if (p.getInventory().getLeggings() == null) {
							if (p.getInventory().getBoots() == null) {
								p.sendMessage("krai manoo");
								return true;
							}else {
								p.sendMessage("DA N AMIGO KRL");
								
							}
						
						}

					}
					
				}
			}
		}
		return false;
	}

}
