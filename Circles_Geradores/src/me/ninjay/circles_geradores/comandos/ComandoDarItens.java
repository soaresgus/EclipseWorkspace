package me.ninjay.circles_geradores.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.circles_geradores.estruturas.ItensAPI;
import me.ninjay.circles_geradores.main.Main;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.gerador());
			p.getInventory().addItem(ItensAPI.obsidian());
		
		}
		return false;
	}

}
