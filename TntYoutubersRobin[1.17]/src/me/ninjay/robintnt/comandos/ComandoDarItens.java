package me.ninjay.robintnt.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.robintnt.estruturas.ItensAPI;
import me.ninjay.robintnt.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.beto);
			p.getInventory().addItem(ItensAPI.davi);
			p.getInventory().addItem(ItensAPI.faisca);
			p.getInventory().addItem(ItensAPI.jhow);
			p.getInventory().addItem(ItensAPI.robin);
		}
		return false;
	}

}
