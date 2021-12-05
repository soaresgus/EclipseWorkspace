package me.ninjay.loginsoulth.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ComandoLoginSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("login.admin")) {
				Main.locais.set("spawn_login", p.getLocation());
				Main.locais.saveConfig();
				p.sendMessage("§aSpawn do login setado.");
				
			}else {
				return true;
			}
		}
		return false;
	}

}
