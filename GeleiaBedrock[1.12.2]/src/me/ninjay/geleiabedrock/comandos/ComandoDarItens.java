package me.ninjay.geleiabedrock.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.geleiabedrock.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.barras());
			p.getInventory().addItem(ItensAPI.fragmento());
			p.getInventory().addItem(ItensAPI.espada());
			p.getInventory().addItem(ItensAPI.flint());
			p.getInventory().addItem(ItensAPI.arco());
			p.getInventory().addItem(ItensAPI.picareta());
			p.getInventory().addItem(ItensAPI.machado());
			p.getInventory().addItem(ItensAPI.balde());
			p.getInventory().addItem(ItensAPI.capa());
			p.getInventory().addItem(ItensAPI.peito());
			p.getInventory().addItem(ItensAPI.calca());
			p.getInventory().addItem(ItensAPI.bota());
			p.getInventory().addItem(ItensAPI.ender());
			p.getInventory().addItem(ItensAPI.golem());
			p.getInventory().addItem(ItensAPI.tnt());
		}
		return false;
	}

}
