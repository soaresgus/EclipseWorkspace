package me.ninjay.safeclub.comandos.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbs, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
            p.teleport(ComandoSetSpawn.locais.getLocation("spawn"));			
		}
		return false;
	}

}
