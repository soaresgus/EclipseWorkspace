package me.ninjay.kuststaff.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.kusttags.estruturas.TagsControler;


public class ComandoStaffChat implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			String msg = " ";
			for (int i = 0; i < args.length; i++) {
				msg = String.valueOf(msg) + args[i];
				msg = String.valueOf(msg) + " ";
			}
			
		if(p.hasPermission("staff.chat")) {
			if(args.length > 0) {
			for(Player todos : Bukkit.getOnlinePlayers()) {
				if(todos.hasPermission("staff.chat")) {
					todos.sendMessage("§b§l[STAFF] §f"+TagsControler.getTag(p)+p.getName()+"§7: §f"+msg);
				}
			}
			}else {
				p.sendMessage("§cUtilize: /s <mensagem>.");
			}
		}else {
			p.sendMessage("§cSem permissão.");
		}
		}
		return false;
	}

}
