package me.ninjay.teste112.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.ninjay.teste112.utils.Mine;

public class ComandoTeste implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.sendMessage("§eSite: §6§lsalve.com");
			ItemStack item = Mine.newItem(Material.DIAMOND_AXE, "§eMachado divino", 1, 0, "qual foi doido", "yeah yeah");
			p.getInventory().addItem(item);
			Inventory inv = Mine.newInventory("Só salvinho", 9*3);
			inv.setItem(Mine.getPosition(2, 5), item);
			p.openInventory(inv);
		}
		return false;
	}

}
