package me.ninjay.kustickets.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoCancelar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(ComandoTickets.value.containsKey(p.getName())) {
				ComandoTickets.value.remove(p.getName());
				ComandoTickets.saveres.remove(p.getName());
				ComandoTickets.saveint.put(p, 1);
				p.sendMessage("§cAção cancelada.");
			}else { 
				p.sendMessage("§cAção cancelada.");
				ComandoTickets.value.remove(p.getName());
				ComandoTickets.saveres.remove(p.getName());
				ComandoTickets.saveint.put(p, 1);
			}
			
		}
		
		return false;
	}
}
