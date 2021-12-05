package me.ninjay.geleiacraft.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.geleiacraft.estruturas.ItensAPI;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.multi);
			p.getInventory().addItem(ItensAPI.woodpic);
			p.getInventory().addItem(ItensAPI.diamond);
			p.getInventory().addItem(ItensAPI.dimaespadaespada);
			p.getInventory().addItem(ItensAPI.flint);
			p.getInventory().addItem(ItensAPI.ironpic);
			p.getInventory().addItem(ItensAPI.stonepic);
			p.getInventory().addItem(ItensAPI.bowbow());
			p.getInventory().addItem(ItensAPI.dimaaxe());
			p.getInventory().addItem(ItensAPI.dimaespada());
			p.getInventory().addItem(ItensAPI.dimapic());
			p.getInventory().addItem(ItensAPI.escudo);
		}
		return false;
	}

}
