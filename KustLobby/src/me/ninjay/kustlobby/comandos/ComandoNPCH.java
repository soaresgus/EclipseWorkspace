package me.ninjay.kustlobby.comandos;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kustlobby.utils.Mine;


public class ComandoNPCH implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
		if(p.isOp() == true) {
			Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+0.5, p.getLocation().getZ());
			
			Mine.newHologram(loc, "§e§lNOVIDADE!","§70/300");
		}
		}
		return false;
	}

}
