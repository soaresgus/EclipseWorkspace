package me.ninjay.onewarps.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.onewarps.main.Main;

public class ComandoArena implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
				if(Main.locais.contains("arena")) {
					p.teleport(Main.locais.getLocation("arena"));
					p.sendMessage("§6Teleportado.");
				}
				if(!Main.locais.contains("arena")) {
					p.sendMessage("§cO Arena não foi setada ainda.");
					return true;
				}
				
			
			}
			
		return false;
	}

}
