package me.ninjay.rankup112.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.rankup112.estruturas.Ranks;
import me.ninjay.rankup112.estruturas.RanksAPI;

public class ComandoRanks implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Ranks rank1 = RanksAPI.manager.getRankByName("esmeralda");
			Ranks rank2 = RanksAPI.manager.getRankByName("ferro");
			
			if(rank1 != null) {
				p.getInventory().addItem(rank1.getIcon());
			}
			if(rank2 != null) {
				p.getInventory().addItem(rank2.getIcon());
			}
		}
		return false;
	}

}
