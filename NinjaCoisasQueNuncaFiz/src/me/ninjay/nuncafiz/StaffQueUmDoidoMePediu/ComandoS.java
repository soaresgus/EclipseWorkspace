package me.ninjay.nuncafiz.StaffQueUmDoidoMePediu;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoS implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			for(Player todos : Bukkit.getOnlinePlayers()) {
				if(todos.hasPermission("staff.perm")) {
					 String msg = "";
			          for (int i = 0; i < args.length; i++) {
			            msg = String.valueOf(msg) + args[i];
			            msg = String.valueOf(msg) + " ";
			          }
			          todos.sendMessage("§d[S] §7"+p.getName()+": §f"+msg);
					}
				}
			}
		return false;
	}

}
