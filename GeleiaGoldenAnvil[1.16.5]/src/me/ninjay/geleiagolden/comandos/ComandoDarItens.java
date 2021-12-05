package me.ninjay.geleiagolden.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.geleiagolden.estruturas.ItensAPI;


public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.bigorna);
			p.getInventory().addItem(ItensAPI.cajado);
			p.getInventory().addItem(ItensAPI.espadareta());
			p.getInventory().addItem(ItensAPI.capacete);
			p.getInventory().addItem(ItensAPI.peitoral);
			p.getInventory().addItem(ItensAPI.calcas);
			p.getInventory().addItem(ItensAPI.botas);
			p.getInventory().addItem(ItensAPI.shuriken());
			p.getInventory().addItem(ItensAPI.chuva);
			p.getInventory().addItem(ItensAPI.corrente);
			p.getInventory().addItem(ItensAPI.picareta());
			p.getInventory().addItem(ItensAPI.machado);
		}
		return false;
	}

}
