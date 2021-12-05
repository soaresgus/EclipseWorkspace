package me.ninjay.safecore.comandos.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.safecore.utils.Mine;
import net.md_5.bungee.api.ChatColor;

public class ComandoAviso implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("chat.admin")) {
				if (args.length == 0) {
					p.sendMessage("§cUtilize: /aviso <mensagem>");
					return true;
				}
				String msg = " ";
				for (int i = 0; i < args.length; i++) {
					msg = String.valueOf(msg) + args[i];
					msg = String.valueOf(msg) + " ";
					msg = ChatColor.translateAlternateColorCodes('&', msg);
				}
				for (int i = 0; i < 100; i++) {
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage("§c§lAVISO >>§f" + msg);
				Mine.sendTitle("§c§lAVISO", "§f§lLEIA O CHAT", 10, 50, 10);
			}else {
				p.sendMessage("§cSem permissão.");
			}
		}
		return false;
	}

}
