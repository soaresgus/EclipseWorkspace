package me.ninjay.safecore.comandos.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoClearChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("chat.admin")) {
				for (int i = 0; i < 100; i++) {
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage("§aChat limpo por §a§l" + p.getName());
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
