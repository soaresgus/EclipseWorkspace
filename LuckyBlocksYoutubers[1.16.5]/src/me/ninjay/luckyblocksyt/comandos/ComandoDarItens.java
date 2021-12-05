package me.ninjay.luckyblocksyt.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.luckyblocksyt.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.jeredy);
			p.getInventory().addItem(ItensAPI.jp);
			p.getInventory().addItem(ItensAPI.jv);
			p.getInventory().addItem(ItensAPI.lua);
			p.getInventory().addItem(ItensAPI.minguado);
			p.getInventory().addItem(ItensAPI.moon);
			p.getInventory().addItem(ItensAPI.robin);
		}
		return false;
	}

}
