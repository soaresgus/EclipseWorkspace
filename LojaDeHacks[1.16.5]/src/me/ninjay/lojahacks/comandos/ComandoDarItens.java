package me.ninjay.lojahacks.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.lojahacks.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.estagio1);
			p.getInventory().addItem(ItensAPI.estagio2);
			p.getInventory().addItem(ItensAPI.estagio3);
		}
		return false;
	}

}
