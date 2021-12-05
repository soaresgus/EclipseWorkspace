package me.ninjay.olympiclobby.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.olympiclobby.main.Main;


public class ComandoSetSpawn implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("spawn.admin")) {
				p.sendMessage("§eSetado.");
				Main.config.set("spawn", p.getLocation());
				Main.config.saveConfig();
			}else {
				return true;
			}
			
		}
		return false;
	}

}
