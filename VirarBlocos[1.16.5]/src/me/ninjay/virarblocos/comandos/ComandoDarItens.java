package me.ninjay.virarblocos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.virarblocos.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			p.getInventory().addItem(ItensAPI.bigorna());
			p.getInventory().addItem(ItensAPI.obsidian());
			p.getInventory().addItem(ItensAPI.fornalha());
			p.getInventory().addItem(ItensAPI.craft());
			p.getInventory().addItem(ItensAPI.bau());
			p.getInventory().addItem(ItensAPI.tnt());
			p.getInventory().addItem(ItensAPI.enchant());
			
		}
		
		return false;
	}

}
