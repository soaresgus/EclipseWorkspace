package me.ninjay.safecore.comandos.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoToggleGlobal implements CommandExecutor {

	public static boolean global = true;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("chat.admin")) {
				if (args.length == 0) {
					p.sendMessage("§cUtilize: /toggleglobal <on/off>");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					p.sendMessage("§aGlobal ativado.");
					global = true;
				} else if (args[0].equalsIgnoreCase("off")) {
					p.sendMessage("§aGlobal desativado.");
					global = false;
				}
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
