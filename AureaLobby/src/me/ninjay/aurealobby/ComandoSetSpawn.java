package me.ninjay.aurealobby;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoSetSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if(sender instanceof Player) {
			Player p = (Player) sender;
	    	Main.config.set("spawn", p.getLocation());
	    	Main.config.saveConfig();
	    	return true;
	    }
		return false;
	}

}
