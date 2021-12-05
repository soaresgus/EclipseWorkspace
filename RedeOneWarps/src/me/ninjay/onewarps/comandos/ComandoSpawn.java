package me.ninjay.onewarps.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.onewarps.main.Main;

public class ComandoSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
				if(Main.locais.contains("spawn")) {
					p.teleport(Main.locais.getLocation("spawn"));
					p.sendMessage("§6Teleportado.");
					
				}
				if(!Main.locais.contains("spawn")) {
					p.sendMessage("§cO Spawn não foi setado ainda.");
					return true;
				}
				
			
			}
			
		return false;
	}

}
