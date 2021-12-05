package me.ninjay.kuststaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kusttags.estruturas.TagsControler;

public class ComandoStaff implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("staff.use")) {
				p.sendMessage("§eMembros da equipe online nesse servidor:\n ");
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(todos.hasPermission("staff.use")) {
						p.sendMessage("§f  - "+TagsControler.getTag(todos)+todos.getName());
					}
				}
				p.sendMessage(" ");
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
