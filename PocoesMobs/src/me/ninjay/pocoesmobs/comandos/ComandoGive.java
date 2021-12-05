package me.ninjay.pocoesmobs.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.pocoesmobs.estruturas.ItemAPI;

public class ComandoGive implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.getInventory().addItem(ItemAPI.zumbi);
			p.getInventory().addItem(ItemAPI.aranha);
			p.getInventory().addItem(ItemAPI.enderman);
			p.getInventory().addItem(ItemAPI.vaca);
			p.getInventory().addItem(ItemAPI.creeper);
			p.getInventory().addItem(ItemAPI.galinha);
			p.getInventory().addItem(ItemAPI.ghast);
			p.getInventory().addItem(ItemAPI.vilager);
			p.getInventory().addItem(ItemAPI.dragao);
		}
		
		return false;
	}

}
