package me.ninjay.aula;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoLimparChat implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("limpar.chat")) {
				for(int i = 0; i<100; i++) {
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage("§eChat limpo !");
				
				}
				
			}
		
		return false;
	}

}
