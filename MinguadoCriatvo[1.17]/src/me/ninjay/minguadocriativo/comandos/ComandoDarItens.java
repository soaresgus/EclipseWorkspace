package me.ninjay.minguadocriativo.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.minguadocriativo.estruturas.ItensAPI;
import me.ninjay.minguadocriativo.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.comando());
			p.getInventory().addItem(ItensAPI.fragmento());
			p.getInventory().addItem(ItensAPI.mesa());
			p.getInventory().addItem(ItensAPI.picareta());
			p.getInventory().addItem(ItensAPI.espada());
		}
		return false;
	}

}
