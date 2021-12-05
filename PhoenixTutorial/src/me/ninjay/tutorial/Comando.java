package me.ninjay.tutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("comando")) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§6§lApenas Jogadores");
		
				
			}else {
				if(!sender.hasPermission("comando.use")) {
					sender.sendMessage("§6§lSem permissão");
					return true;
				}
				if(sender.hasPermission("comando.use")) {
					Player p = (Player)sender;
					p.sendMessage("Oi");
				}
			}
		}
		
		
		
		return false;
	}

}
