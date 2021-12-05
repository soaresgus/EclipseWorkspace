package me.ninjay.omegakibe.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.lib.modules.BukkitBungeeAPI;

public class ComandoDarMoeda implements CommandExecutor{
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			p.sendMessage("§eTem tal" +BukkitBungeeAPI.getServer(BukkitBungeeAPI.getCurrentServer()).getPlayerCount());
			
		}
		return false;
	}

}
