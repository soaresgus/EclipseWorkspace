package me.ninjay.nuncafiz.StaffQueUmDoidoMePediu;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoStaff implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("§6§lMembros da equipe online no servidor atual:\n ");
			for(Player todos : Bukkit.getOnlinePlayers()) {
			if(todos.hasPermission("staff.perm")) {
				p.sendMessage(" §f- "+todos.getName());
			}
			}
			p.sendMessage(" ");
		}
		return false;
	}

}
