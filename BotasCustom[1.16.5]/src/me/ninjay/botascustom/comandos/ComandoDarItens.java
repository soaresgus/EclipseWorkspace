package me.ninjay.botascustom.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.botascustom.estruturas.ItensAPI;
import me.ninjay.botascustom.utils.Mine;

public class ComandoDarItens implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			p.getInventory().addItem(ItensAPI.pedra);
			p.getInventory().addItem(ItensAPI.gelo);
			p.getInventory().addItem(ItensAPI.prismarine);
			p.getInventory().addItem(ItensAPI.esponja);
			p.getInventory().addItem(ItensAPI.aranha);
			p.getInventory().addItem(ItensAPI.slime);
			p.getInventory().addItem(ItensAPI.perola);
			p.getInventory().addItem(ItensAPI.obsidian);
			
			
		}
		return false;
	}

}
