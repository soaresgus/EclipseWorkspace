package me.ninjay.ninjakitpvp.comandos.global;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ninjay.ninjakitpvp.eventos.EventosGlobal;

public class ComandoFly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("fly.perm")) {
				if(args.length == 0) {
					p.sendMessage("§cUse /fly <on/off>");
					return true;
				}
				if(args[0].equalsIgnoreCase("on")) {
					if(EventosGlobal.spawn.contains(p))  {
						p.setAllowFlight(true);
						p.sendMessage("§aFly ativado.");
					}else {
						p.sendMessage("§cVocê precisa estar no spawn para utilizar.");
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(EventosGlobal.spawn.contains(p))  {
						p.setAllowFlight(false);
						p.sendMessage("§aFly desativado.");
					}else {
						p.sendMessage("§cVocê precisa estar no spawn para utilizar.");
						return true;
					}
				}
			}
		}
		return false;
	}

}
