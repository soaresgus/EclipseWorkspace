package me.ninjay.ossosmobs.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ossosmobs.estruturas.ItensAPI;


public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.raiox);
			p.getInventory().addItem(ItensAPI.ossoaranha);
			p.getInventory().addItem(ItensAPI.ossozumbi);
			p.getInventory().addItem(ItensAPI.ossowither);
			p.getInventory().addItem(ItensAPI.ossovillager);
			p.getInventory().addItem(ItensAPI.ossovaca);
			p.getInventory().addItem(ItensAPI.ossoporco);
			p.getInventory().addItem(ItensAPI.ossoovelha);
			p.getInventory().addItem(ItensAPI.ossogalinha);
			p.getInventory().addItem(ItensAPI.ossoesqueleto);
			p.getInventory().addItem(ItensAPI.ossocreeper);
			p.getInventory().addItem(ItensAPI.ossoq);
		}
		return false;
	}

}
