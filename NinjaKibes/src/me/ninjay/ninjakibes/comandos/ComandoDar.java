package me.ninjay.ninjakibes.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakibes.estruturas.ItemAPI;

public class ComandoDar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUse: /dar <slime/lancador/lancadorsupremo>.");
				return true;
			}
			if(args[0].equalsIgnoreCase("slime")) {
				p.getInventory().addItem(ItemAPI.slime);
				return true;
			}
			if(args[0].equalsIgnoreCase("lancador")) {
				p.getInventory().addItem(ItemAPI.lanca);
				return true;
			}
			if(args[0].equalsIgnoreCase("lancadorsupremo")) {
				p.getInventory().addItem(ItemAPI.lanca20);
				return true;
			}
			if(args[0].equalsIgnoreCase("teste")) {
				p.getInventory().addItem(ItemAPI.teste);
				return true;
			}
	
			
		}
		return false;
	}

}
