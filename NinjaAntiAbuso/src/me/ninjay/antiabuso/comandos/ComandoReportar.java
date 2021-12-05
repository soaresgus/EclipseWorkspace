package me.ninjay.antiabuso.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoReportar implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length <= 1) {
				p.sendMessage("§cUtilize /reportar <nick> <motivo>");
				return true;
			}else {
				Player r = Bukkit.getPlayer(args[0]);
				if(r != null) {
					p.sendMessage("§aDenúncia enviada com sucesso.");
				}
			}
		}
		return false;
	}

}
