package me.ninjay.safesurvival.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ComandoSpawn implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
					p.sendMessage("§aTeleportado para o spawn.");
					p.teleport(p.getWorld().getSpawnLocation());
				return true;
			}
				if (p.hasPermission("server.admin")) {
					if (args[0].equalsIgnoreCase("setar")) {
						p.sendMessage("§aSpawn setado.");
						p.getWorld().setSpawnLocation(p.getLocation());
					}
				}
		}
		return false;
	}

}
